package com.sais.cashoffice.CashOfficeTest.paypointtransaction.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sais.cashoffice.CashOfficeTest.entities.TPaypointCrHdr;
import com.sais.cashoffice.CashOfficeTest.entities.TPaypointCrLine;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.TPpCrFileFormatHdrRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.TPpCrFileFormatLineRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.service.FileService;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.CreditFileFieldFormatForm;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.CreditFileForm;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.CreditFileUploadForm;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.repository.TpaypointCrHdrRepository;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.repository.TpaypointCrLinesRepository;
import com.sais.cashoffice.exception.Response;

@Service
public class CreditFileUploadServiceImpl implements CreditFileUploadService {
	private static final Logger LOGGER = LogManager.getLogger(CreditFileUploadServiceImpl.class);
	@Autowired
	FileService fileservice;

	@Autowired
	TPpCrFileFormatLineRepository crFileFormatRepo;

	@Autowired
	TPpCrFileFormatHdrRepository filecrHdr;

	@Autowired
	TpaypointCrHdrRepository crdtHdr;

	@Autowired
	TpaypointCrLinesRepository crdtLineRepo;

	@Autowired
	ModelMapper modelmapper;

	private List<CreditFileForm> crFileLines = new ArrayList<CreditFileForm>();
	

	public List<CreditFileForm> getCrFileLines() {
		return crFileLines;
	}

	public void setCrFileLines(List<CreditFileForm> crFileLines) {
		this.crFileLines = crFileLines;
	}

	@Override
	public ResponseEntity<?> uploadCreditFile(CreditFileUploadForm formData, MultipartFile file,String createdby)  {
		boolean status = true;
		Response resp = null;
		CreditFileForm creditFileForm = null;
		String msg = "";
		LOGGER.debug("Paypoint ID : " + formData.getPaypointId());
		try {
			// saving the uploaded file to server location
			status = saveCreditFileToServer(formData.getCreditFile(), file);
			// after saving process the file based on the file type
			if (status == true) {
				
				// reading the file name which is uploaded from front end 
				String strFileName = file.getOriginalFilename();// formData.getCreditFile();
				
				// reading the server location path were the file is store
				String strFileDPath = FileService.creditFilesLocation + File.separator + strFileName;
				
				// getting data from T_PP_CR_FILE_FORMAT_LINES to determine which fields should be there in the uploaded cr file
				CreditFileFieldFormatForm fldDetails = crFileFormatRepo
						.getCreditFileFieldFormat(Long.valueOf(formData.getPaypointId()), 1, "LINES");
				
				// result 
				System.out.println(fldDetails.getFileName());
				System.out.println(fldDetails.getPpId());
				System.out.println(fldDetails.getCurrency());
				System.out.println(fldDetails.getFieldName());
				System.out.println(fldDetails.getNoOfCrHdrLines());
				System.out.println(fldDetails.getPpFileFormatId());
				
				
				String strDelimeterType;
				LOGGER.debug("Delimeter Type   :" + fldDetails.getDelimiter());
			
				if (fldDetails.getDelimiter() == null) {
					resp = new Response(200, "Plesae Check The Credit File Format in File Designer Unauthorized Operation Delimiter Cannot be Empty");
					return new ResponseEntity<>(resp, HttpStatus.OK);
					
				} else {
					strDelimeterType = fldDetails.getDelimiter();
					// handling credit file with "P" as delimiter
					if (strDelimeterType.equalsIgnoreCase("P")) {
						System.out.println("if delimter is of  type p");
						this.setCrFileLines(
								ParseStringFIXWidth(strFileDPath, formData.getPaypointId(), creditFileForm));
					} else {
						// handling credit file with ","(comma) as delimiter
						if ((file.getContentType().equalsIgnoreCase("application/vnd.ms-excel"))
								|| (file.getContentType().equalsIgnoreCase("CSV"))) {
							LOGGER.debug("Parse CSV Section");
							System.out.println("because delimiter is of ',' and file type is csv then we will call csv parser which will read csv stored file");
							this.setCrFileLines(
									ParseStringDeli(strFileDPath, formData.getPaypointId(), creditFileForm));
						} else {
							LOGGER.debug("Parse .txt file Section");
							this.setCrFileLines(
									ParseStringDeli(strFileDPath, formData.getPaypointId(), creditFileForm));

						}

					}
					
					System.out.println("Total Records :------------"+crFileLines.size());
					
					if (crFileLines.size() > 0) {
						
						
						  if(crFileLines.get(0).getStatusofcolumnscount()==1){
							  resp = new Response(200,"Uploaded File header column count is not same as File Designed template For This Paypoint");
								return new ResponseEntity<>(resp, HttpStatus.OK);
						  }
						
						LOGGER.info("Record Insertion started........" + this.getCrFileLines().size());
						
						Date period = SplitMergeServiceImpl.convertToDate(formData.getPeriod());
						
						crFileLines.stream().forEach(elt -> elt.setCollection_Period(period));
						
						// saving credit file data into corresponding tables
						msg = insertCrHdr(crFileLines, strFileName, period, formData.getPaypointId(),createdby);
						System.out.println(msg);
					}else{
						 resp = new Response(200,"uploaded credit file does not contains any records");
						 return new ResponseEntity<>(resp, HttpStatus.OK);
					}
				}
			}else {
				    System.out.println(status);
					resp = new Response(200, "error occured while Uploading the credit file");
					return new ResponseEntity<>(resp, HttpStatus.OK);
			}
		} 
		
		catch(NullPointerException e){
			
			resp = new Response(200, "Error occured while comparing Field Sequence order with Template Designed for this paypoint id");
			return new ResponseEntity<>(resp, HttpStatus.OK);
			
		}
		
		catch (Exception e) {
			 System.out.println(e);
			resp = new Response(200, "error occured while Uploading the credit file");
			return new ResponseEntity<>(resp, HttpStatus.OK);
		     
		}
		
		
		resp = new Response(200, msg);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	
    // below code is used for loading the uploaded credit file into server location
	public boolean saveCreditFileToServer(String filePath, MultipartFile file) throws Exception {
		
		boolean status = false;
		BufferedReader brReader = null;
		BufferedWriter brWriter = null;
		try {
			
			
			if ((file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) || (file.getContentType().equalsIgnoreCase("CSV"))) {
						
				   fileservice.store(file, FileService.creditFilesLocation);
				   status = true;
			} else {
				  System.out.println("here file formatt is of .txt file");
				  fileservice.store(file, FileService.creditFilesLocation);
				  status = true;
			}
		} catch (RuntimeException e) {
			     e.printStackTrace();
			    throw new Exception("Error Occured while parsing credit File ");
		} finally {
			LOGGER.debug("cleaning up file resources");
			try {
				if (brReader != null) {
					brReader.close();
				}

				if (brWriter != null) {
					brWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

	
 private List<CreditFileForm> ParseStringDeli(String strFileDPath, String paypointId, CreditFileForm creditFileForm)
			throws Exception {

 // ----------- code started for dealing with template designed for give template
		String strFile = strFileDPath;
	
// STEP 1 -- Deals with header count which are define in T_PP_CR_FILE_FORMAT_LINES table
		int header_Count = 0;
		header_Count = (int) filecrHdr.findByPaypointId(Long.valueOf(paypointId)).getNoOfCreditHdrLines();
		System.out.println("No of headers contains in Design Template------>"+header_Count);
		
 // STEP 2 -- Deals with Fieldscount in which are define  T_PP_CR_FILE_FORMAT_LINES table
		int fieldCount = getFieldCount(paypointId);
		System.out.println("Fields count from Design Template---->"+fieldCount);
			
// STEP 3 -- Dealing the actual fields present in the uploaded file
		int Tokens = getCountTokens(strFileDPath, header_Count);
		System.out.println("number of fields avaliable in Uploaded credit file---->"+Tokens);
      
// Step 4 -- comparing the file colums count with credit file template we design columns
		if(!(fieldCount==Tokens)){
			CreditFileForm cf = new CreditFileForm();
			cf.setStatusofcolumnscount(1);
			crFileLines.add(cf);
			return crFileLines;	
		}

// Step 5 -- Getting Fields Name from Design Template file
		String[] fieldname = getFieldName(Tokens, paypointId);
		
		for(int i=0;i<fieldname.length;i++){
			System.out.println(fieldname[i]);
		}
			
// STEP 6 -- reading data from uploaded credit file		
		String strLine = "";
		StringTokenizer st = null;
		int line_Number = 0;
		int token_Number = 0;
		boolean first_Line;

		// defining the type of class which we are dealing with  let us consider all the data inside the uploaded file as String type
		Class[] types = new Class[] {};
		types = new Class[] { String.class };
		
		// reading wheather uploaded file has header file or not 
		if (header_Count > 0) {
			first_Line = true;
		} else {
			first_Line = false;
		}

		// Number of Trailer Record by using this logic we restrict the no of records to be saved 
		String Trailer_Const = "9999***";
		String strDelimiter = ",";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(strFile));
			while ((strLine = br.readLine()) != null) {
				// by using this logic we are skipping the header file by using increament style because pointer while moved down for each while condition
				if (header_Count > 0) {
					header_Count = header_Count - 1;
					continue;
				} else {
					
					if (strLine.startsWith(Trailer_Const)) {
						continue;
					} else {
						// here we are using this class object to map the fields in the uploded credit file
						creditFileForm = new CreditFileForm();
						line_Number++;
						st = new StringTokenizer(strLine, strDelimiter);

						while (st.hasMoreTokens()) {
							
							//here token_number is used for counting the no of word present along the line which are seperated by delimiter ',';
							token_Number++;
							Method method = null;
							String strFieldName = null;
							// read the fields data
							String strField = st.nextToken();

							if (token_Number > Tokens) {
								continue;
							} else {
								if (fieldname.length > 0) {
									strFieldName = fieldname[token_Number - 1];
									if ((strFieldName == null) || (strFieldName.isEmpty())) {
										continue;
									} else {
										// by using getMethodName we used created setter method using the filed name
										strFieldName = getMethodName(strFieldName);
										System.out.println("SetterMethod Name-->"+strFieldName);
										//now after getting the setter method  we are calling the method from java object
										method = creditFileForm.getClass().getMethod(strFieldName, types);
										// after calling the java method we are revoking that method by passing java class name and value to be set for setter method
										method.invoke(creditFileForm, strField.trim());
									}
								}
							}

						}

					}
					token_Number = 0;
					this.getCrFileLines().add((CreditFileForm) creditFileForm);
				}
			}
		} finally {
			// to avoid memory leaks
			if (br != null) {
				br.close();
			}
		}
		LOGGER.debug("File Reading Finished And Total Records " + crFileLines.size());
		return crFileLines;
	}

	public List<CreditFileForm> ParseStringFIXWidth(String strInputFile, String strPayPointID, Object ObjcreditFileDTO)
			throws IOException {

		LOGGER.info("ParseStringFIXWidth Method Invoked");
		System.out.println("ParseStringFIXWidth Method Invoked");
		try

		{
			// Getting File Name
			String strFilNameNew = ParseFileName(strInputFile);
			
			System.out.println("Getting File Name from the file path position--->"+strFilNameNew);

			// Reading File buffer
			// -----------------------------------------------------------
			String strFile = strInputFile;
			BufferedReader br = new BufferedReader(new FileReader(strFile));

			String strLine = "";
			StringTokenizer st = null;
			int line_Number = 0;
			int token_Number = 0;

			Class[] types = new Class[] {};
			types = new Class[] { String.class };

			// Number of Header Record
			// ---------------------------------------------------------
			int fieldCount = getFieldCount(strPayPointID);
			long header_Count = 0;
			header_Count = filecrHdr.findByPaypointId(Long.valueOf(strPayPointID)).getNoOfCreditHdrLines();
			// header_Count= getNumberOflines(strPayPointID,"HEADER");
			LOGGER.debug(" Total Header  Records" + header_Count);
			
			boolean first_Line;
			if (header_Count > 0) {
				first_Line = false;
			} else {
				first_Line = true;
			}

			// Number of Trailer Record
			// --------------------------------------------------------
			String Trailer_Const = "9999***";
			String strDelimiter = ",";

			// Reading file
			while ((strLine = br.readLine()) != null) {
				Method method = null;
	
				if (header_Count > 0) {
					LOGGER.debug("Header line invoked");
					header_Count = header_Count - 1;
					first_Line = false;
					continue;

				} else if (strLine.startsWith(Trailer_Const)) {
					LOGGER.debug("Trailer line invoked");
					continue;
				} else {

					String strFieldName = null;
					ObjcreditFileDTO = new CreditFileForm();

					int lenLine = 0;
					lenLine = strLine.length();
					System.out.println("String lenght " + lenLine);
					int i = 0;
					int startPosition, endPosition;
					String strFieldValue;
					while ((lenLine > 0) && (i < fieldCount)) {

						CreditFileFieldFormatForm crf = crFileFormatRepo
								.getCreditFileFieldFormat(Long.valueOf(strPayPointID), i + 1, "LINES");
						LOGGER.debug("fileFormatDTO --------------->" + crf);
						strFieldName = crf.getFieldName();

						if (crf != null) {
							startPosition = crf.getStartPosition();
							endPosition = crf.getEndPosition();
							LOGGER.debug("Start Positio:" + startPosition);
							LOGGER.debug("End Position :" + endPosition);
							strFieldValue = strLine.substring(startPosition, endPosition);
							LOGGER.debug("Field Name :" + strFieldName);
							LOGGER.debug("Field Lenght :" + strFieldValue.length());
							LOGGER.debug("Field Value :" + strFieldValue);
							// strFieldName = getMethodName(strFieldName);
							lenLine = lenLine - strFieldValue.length();
							LOGGER.debug("Linght Of Line :" + lenLine);
							String strField = strFieldValue;
							strFieldName = getMethodName(strFieldName);
							method = ObjcreditFileDTO.getClass().getMethod(strFieldName, types);
							method.invoke(ObjcreditFileDTO, strField.trim());
						}

						i++;
					}

				}

				crFileLines.add((CreditFileForm) ObjcreditFileDTO);
			}

			LOGGER.debug("File Reading Finished And Total Records " + crFileLines.size());

		}

		catch (Exception e)

		{
			LOGGER.error("Error Occured : ", e);

		}
		return crFileLines;
	}


	private String insertCrHdr(List<CreditFileForm> crFileLines, String strFileName, Date period, String paypointId,String createdby)
			throws Exception {
		String msg = "";
		Set<String> upstatus = new HashSet<String>(Arrays.asList("U", "I"));
		Set<String> processedstatus = new HashSet<String>(Arrays.asList("P"));
		
		List<TPaypointCrHdr> uploadedList = crdtHdr
				.findByPaypointIdAndUploadPeriodAndFileStatusIn(Long.valueOf(paypointId), period, upstatus);
		List<TPaypointCrHdr> processedList = crdtHdr
				.findByPaypointIdAndUploadPeriodAndFileStatusIn(Long.valueOf(paypointId), period, processedstatus);
		
		System.out.println("processedList  file status as D-->"+processedList.size());
		System.out.println("uploadedList   file status as U or I--->"+uploadedList.size());
		
		
		
		// uploaded file status is D 
		if (processedList.size() > 0) {	
			msg = "Cr File already uploaded  for the Paypoint Id " + paypointId + " for the Period " + period;
		} else if (uploadedList.size() > 0) {
			
			TPaypointCrHdr creditHdr = uploadedList.get(0);
			
			if (creditHdr != null) {
				List<TPaypointCrLine> crdtLine = crdtLineRepo.findByCreditHdrid(creditHdr.getPpCrHdrId());
				crdtLine.stream().forEach(elt -> elt.setStatus("D"));
				// crdtLine.setStatus("D");
				crdtLineRepo.saveAll(crdtLine);
				creditHdr.setFileStatus("D");
				crdtHdr.save(creditHdr);
				msg = "Record is Update Successfully!";
			}
			// below commented code is very step because depends on that case only we can either insert new record even record is exist with same paypoint with same period
			//uploadedList.clear();
		}
		
		if (uploadedList.size() == 0 && processedList.size() == 0) {
			TPaypointCrHdr entity = new TPaypointCrHdr();
			entity.setPaypointId(Long.valueOf(paypointId));
			entity.setFileName(strFileName);
			entity.setUploadPeriod(period);
			entity.setFileStatus("U");
			entity.setCreatedBy(createdby);
			entity.setCreationDate(new Date());

			TPaypointCrHdr id = crdtHdr.save(entity);
			if (id != null) {
				msg = "Record generated successfully!";
				insertCrLines(crFileLines, id.getPpCrHdrId(), id.getPaypointId(), period, createdby);
			} else {
				throw new Exception("Error while Saving Credit header Details");
			}

		}
		return msg;
	}

	
	private String insertCrLines(List<CreditFileForm> crFileLines, long ppCrHdrId, long paypointId, Date period,String createdby)
			throws Exception {
		
		String msg = "";
		String currency = filecrHdr.findCurrencyByPaypointId(paypointId);
		System.out.println("cureency type--->"+currency);
		Double premium;
		for (CreditFileForm crdtLine : crFileLines) {
			
			if (crdtLine.getPension_premium() == null) {
				crdtLine.setPension_premium("0");
			}
			if (crdtLine.getLife_premium() == null) {
				crdtLine.setLife_premium("0");
			}
			if (crdtLine.getPremium() == null) {
				crdtLine.setPremium("0");
			}
			premium = Double.parseDouble(crdtLine.getPremium().toString())
					+ Double.parseDouble(crdtLine.getLife_premium().toString())
					+ Double.parseDouble(crdtLine.getPension_premium().toString());
			if (currency.equals("THEBE")) {
				premium = premium / 100;
			}
			
			
			TPaypointCrLine crline = modelmapper.map(crdtLine, TPaypointCrLine.class);
			
			crline.setPolicyCode(crdtLine.getPolicy_code());  
			crline.setPaypointId(paypointId);
			crline.setPartyIdentificationCode(null);
			crline.setPartyName(crdtLine.getEmployee_name());
			//crline.setPolicyCode(crdtLine.getPolicy_number());
			// crline.setProductId(0);
			crline.setEmployeeCode(crdtLine.getEmployee_number());
			crline.setStrikeDay(null);
			crline.setBankCode(null);
			crline.setBranchCode(null);
			crline.setBankAccountCode(null);
			crline.setBankAccountHolder(null);
			// crline.setBankAccountType(null);
			crline.setCrAmount(new BigDecimal(premium));
			crline.setTPaypointCrHdr(crdtHdr.findById(ppCrHdrId).orElse(null));
			crline.setCollectionPeriod(period);
			crline.setCreationDate(new Date());
			crline.setCreatedBy(createdby);
			try {
				crdtLineRepo.save(crline);
				msg = "Saved Data into Credit lines Successfully";
			} catch (Exception e) {
				throw new Exception("Error while saving data into Credit lines");
			}

		}
		return msg;

	}

	public List<CreditFileForm> ParseCSV(String strInputFile, String strPayPointID, Object ObjcreditFileDTO)
			throws Exception {
     
		 System.out.println("---------------parse csv file begin");
		
		 
		// refer to this articale to understnd the code better
		// https://www.callicoder.com/java-read-write-csv-file-opencsv/
		LOGGER.info("ParseStringDeli Method Invoked");
		LOGGER.debug("Paypoint ID :" + strPayPointID);
		LOGGER.debug("Input File Name: " + strInputFile);

		LOGGER.info("CSV ParseStringDeli Method Invoked");
		LOGGER.debug("Paypoint ID :" + strPayPointID);
		LOGGER.debug("Input File Name: " + strInputFile);

		long headerCount = 0;
		CSVReader reader = null;
		try {
			headerCount = filecrHdr.findByPaypointId(Long.valueOf(strPayPointID)).getNoOfCreditHdrLines();
			System.out.println("we are reading template which we design in order to read a file by knowing heades-->"+headerCount);
			
			int Tokens = getCountTokensForCSV(strInputFile, (int) headerCount);
			String[] columns = getFieldName(Tokens, strPayPointID);
			
			

			// String Trailer_Const = "9999***";
			LOGGER.debug("ARRAY LENGTH :" + columns.length);
			
			
			ColumnPositionMappingStrategy<CreditFileForm> strategy = new ColumnPositionMappingStrategy<CreditFileForm>();
			strategy.setType(CreditFileForm.class);
			strategy.setColumnMapping(columns);
			
			CsvToBean<CreditFileForm> csvToBean = new CsvToBeanBuilder<CreditFileForm>(new FileReader(strInputFile))
					.withMappingStrategy(strategy).withSkipLines(1).withIgnoreLeadingWhiteSpace(true).build();
			
			
	                 	
			crFileLines = csvToBean.parse();

			LOGGER.debug("Number of record :" + crFileLines.size());
			System.out.println("Number of record finally read from server side  csv file-->:" + crFileLines.size());
		} catch (Exception e) {
			throw new Exception("Error raised at Parsing given CSV credit file");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return crFileLines;

	}

	private int getFieldCount(String strPayPointID) {
		return (int) crFileFormatRepo.getFieldCount(Long.valueOf(strPayPointID));
	}

	public String getMethodName(String name) {
		String strMethod = null;
		try {
			strMethod = "set" + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		} catch (Exception e) {
			LOGGER.error("Error Occured : ", e);

		}
		return strMethod;
	}

	public String ParseFileName(String strInputFile) {
		// String strPayPointID
		String strFileName = null;
		try {
			int lastIndex = strInputFile.lastIndexOf("/");
			strFileName = strInputFile.substring(lastIndex + 1);

		} catch (Exception e) {

		}

		return strFileName;
	}

	public int getCountTokensForCSV(String strFile, int header_Count) throws IOException {
		// System.out.println(name);

		LOGGER.info("Get Token count For CSV Meyhod Invoked");
		int countTokens = 0;
		BufferedReader inputFile = null;
		String[] line;
		try {
			// inputFile = new BufferedReader(new FileReader(strFile));
			CSVReader reader = new CSVReader(new FileReader(strFile));

			// For each line read, increment the counter
			int i = 0;
			int count = 0;
			
			while ((line = reader.readNext()) != null) {
				

				{
					count = line.length;
					
					System.out.println("final count condition < 3 --->"+count);
					if (i > 3) {
						return count;
					}

					i++;
				}	   

		}
			
		} catch (Exception e) {
			System.out.println(e);
			LOGGER.error("Error Occured : ", e);

		} finally {
			// inputFile.close();
			line = null;

		}

		return countTokens;
	}

	/******************************************************************
	 * This function will returns field name for paypoint
	 *************************************************************/
	public String[] getFieldName(int countTokens, String strPayPointID) throws IOException {

		String[] fieldname = new String[countTokens];
		try {
			System.out.println("Number of tokens:   " + countTokens);
			for (int i = 0; i < countTokens; i++) {
				
			//by using below code we can get the column fields from T_PP_CR_FILE_FORMAT_LINES table
				CreditFileFieldFormatForm crf = crFileFormatRepo.getCreditFileFieldFormat(Long.valueOf(strPayPointID),
						i + 1, "LINES");
				if (crf != null) {
					fieldname[i] = crf.getFieldName();
				}else{
					System.out.println("Sequence order is in different size");
				}
			}

		} catch (Exception e) {
			System.out.println("error occurd while fetching fields name from template");
			System.out.println(e);

		}

		return fieldname;
	}

	public int getCountTokens(String strFile, int header_Count) throws IOException {
		int countTokens = 0;
		BufferedReader inputFile = null;
		String line = "";
		
		try {
			// loading the file location of uploaded file
			inputFile = new BufferedReader(new FileReader(strFile));
			int i = 0;
			while (((line = inputFile.readLine()) != null)) {
				
				System.out.println(line);
				
				// considering header will not be greater than 3 then we can have all the fields count
				if (i > 3) {
					return countTokens;
				}
				
				// if header is greater than 0, initally any uploaded file will have alteast one header
				if (header_Count > 0) {
					System.out.println("before"+header_Count);
					header_Count = header_Count - 1;
					System.out.println("after"+header_Count);
					continue;

				} else {
					StringTokenizer st = null;
					st = new StringTokenizer(line, ",");
					countTokens = st.countTokens();
					System.out.println(countTokens);
				}
				i++;
			}


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			inputFile.close();
			line = null;
		}

		return countTokens;
	}

}
