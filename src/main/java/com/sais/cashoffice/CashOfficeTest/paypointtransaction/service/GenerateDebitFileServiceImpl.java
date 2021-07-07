package com.sais.cashoffice.CashOfficeTest.paypointtransaction.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.sais.cashoffice.CashOfficeTest.CashOfficeTestApplication;
import com.sais.cashoffice.CashOfficeTest.entities.TPpCrFileFormatHdr;
import com.sais.cashoffice.CashOfficeTest.entities.TPpTemplate;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.PaypointTemplateRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.TPpCrFileFormatHdrRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.service.FileService;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.GenDebitFileForm;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.GenerateDebitFile;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.GenerateDebitFileResponse;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.repository.TpaypointDrHdrRepository;
import com.sais.cashoffice.exception.Response;


@Service
public class GenerateDebitFileServiceImpl implements GenerateDebitFileService {

	private static final Logger LOGGER = LogManager.getLogger(GenerateDebitFileServiceImpl.class);
	
	// below line of code is used for creating a new folder with the name DebitFiles in the server location
	public static final Path tempDebits = Paths.get("PremiumDebits");
	
	
	@Autowired
	private EntityManager entityManager;

	@Autowired
	PaypointTemplateRepository ppTmplrepo;
	
	@Autowired
	TpaypointDrHdrRepository tdr;

	@Override
	public ResponseEntity<?> generateManualDebitFile(GenDebitFileForm form,String user) {
		
		GenerateDebitFileResponse response = new GenerateDebitFileResponse();
		
		// path format is converted into string formatte
		String pathtostorge = tempDebits.toString();
		try {
			response = fetchResultSet(form, pathtostorge,user);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	
	// below code deals with creating a empty file and writing the data using java object
	private GenerateDebitFileResponse fetchResultSet(GenDebitFileForm form, String pathstorge,String user) throws Exception {
		
		TPpTemplate templateDetails = ppTmplrepo.findByPaypointId(form.getPaypointId());
		GenerateDebitFileResponse fileresponse = new GenerateDebitFileResponse();
		
		try{	
		//calling the procedure from db
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PE_GENERATE_DR_RECS");
		
		// Declare the parameters in the same order
       query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(4, Date.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(7, Character.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(8, Character.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
       query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);
       query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);
       query.registerStoredProcedureParameter(12, Double.class, ParameterMode.OUT);
       query.registerStoredProcedureParameter(13, Integer.class, ParameterMode.OUT);
       query.registerStoredProcedureParameter(14, String.class, ParameterMode.OUT);
       
       
       int paypointid = form.getPaypointId() ; 
       int templateid = templateDetails.getPpTemplateId();
       int ppattributeid = templateDetails.getPpAttributeId();
       
          System.out.println("input parameters for the procedure");
          System.out.println(paypointid);
          System.out.println(form.getPeriod());
          System.out.println(form.getStrikeDateFrom());
          System.out.println(form.getStrikeDateTo());
          System.out.println(templateid);
          System.out.println(ppattributeid);
          System.out.println(templateDetails.getPensionOnlyYn());
          System.out.println(templateDetails.getOtherPremOnlyYn());
          
       
    // Pass the parameter values
	query.setParameter(1, paypointid);
	query.setParameter(2, form.getPeriod());
	query.setParameter(3, form.getStrikeDateFrom());
	query.setParameter(4, form.getStrikeDateTo());
	query.setParameter(5,templateid);
	query.setParameter(6, ppattributeid);
	query.setParameter(7,templateDetails.getPensionOnlyYn());
	query.setParameter(8,templateDetails.getOtherPremOnlyYn());
	query.setParameter(9,user);
	
	// Execute query(run the procedure with given inputs)
    boolean excute = query.execute();
    
    System.out.println("status of  query excuted--->"+excute);
     
  // Get output parameters
     String paymentmode = (String) query.getOutputParameterValue(10);
     String FileName = (String) query.getOutputParameterValue(11);
     double ppdrhdrid = (Double) query.getOutputParameterValue(12);
     int successid = (int) query.getOutputParameterValue(13);
     String outmessage  = (String)  query.getOutputParameterValue(14);
     
     System.out.println(paymentmode);
     System.out.println(FileName);
     System.out.println(ppdrhdrid);
     System.out.println(successid);
     System.out.println(outmessage);
     
     if(successid==0 || successid==2 || successid==3 ){
    	 
    	 fileresponse.setStatus(successid);
    	 fileresponse.setErrorMsg(outmessage);
    	 fileresponse.setsFlag(false);
    	 return fileresponse;
    	 
     }else{
    	 
    	  if(!FileName.endsWith(".TXT") && !FileName.endsWith(".CSV")){
    		  fileresponse.setStatus(0);
    		  fileresponse.setErrorMsg("Template File Formate is Different from .CSV/.TXT ");
    		  fileresponse.setsFlag(false); 
    		  return fileresponse;
    	  }
    	 
    // now the file ends with extension of wheather .txt or .csv file 
    	   // reading whether directory is already exist or not
    	 File reportFileDir = new File(pathstorge);
			if (!reportFileDir.exists()) {
			        boolean createReportDir = reportFileDir.mkdir();
				System.out.println("Created Reports Dir : " + createReportDir);
		    }
			
			// now creating a new file inside above directory with your file name 
			File createnewfile = new File(reportFileDir,FileName);
			 if(!createnewfile.exists()){
				 boolean createReportDir = createnewfile.createNewFile();
			 }else{
				 System.out.println("already file is generated");
			
				 // deleting old file
				  boolean deleteexistingfile =  createnewfile.delete();
				  System.out.println("existing record is deleted or not --->"+deleteexistingfile);
				   
				  //creating new file 
				  boolean createReportDir = createnewfile.createNewFile();  	 
			 }
			
		// if payment mode is of DDE type	 
		if(paymentmode.equals("DDE") ){
				  System.out.println("paymemt mode is of DDE type");
                  BigDecimal paypointiddr = new BigDecimal(paypointid);
				  List<GenerateDebitFile> gd = getpaypointtransdebitfilerecords(paypointiddr,form.getPeriod(),ppdrhdrid);
			 if(gd.size()>0){
				   // now checking wheather the file is of txt or csv based on it we will load the data into it
				  if(FileName.endsWith(".TXT") || FileName.endsWith(".txt") ){
				    		System.out.println("the file is of plain text type");
				    		String pathfile = tempDebits + File.separator +FileName ;
				    		try{	
				    		    writeToFileDDE(gd,pathfile);
				    		} catch(Exception e){
				    			fileresponse.setErrorMsg(e.getMessage());
				    			fileresponse.setsFlag(false);
				    			return fileresponse;
				    		}
				    	}
				    	
				   if(FileName.endsWith(".csv") || FileName.endsWith(".CSV")  ){
				    System.out.println("the file is of .csv type");	
				    String pathfile = tempDebits + File.separator + FileName;
				    		
				    	try{	
				    		writeToCSVFileDDE(gd,pathfile);
				    	} catch(Exception e){
			    			fileresponse.setErrorMsg(e.getMessage());
			    			fileresponse.setsFlag(false);
			    			return fileresponse;
			    			
			    		    }
				    	}
				    	
				    }
				  
			  }else{
				  
				  System.out.println("PAYMENT MODE IS OF TYPE ----->"+paymentmode);
                  BigDecimal paypointiddr = new BigDecimal(paypointid);
				  List<GenerateDebitFile> gd = getpaypointtransdebitfilerecords(paypointiddr,form.getPeriod(),ppdrhdrid);  
			  if(gd.size()>0){
				   // now checking wheather the file is of txt or csv based on it we will load the data into it
				   if(FileName.endsWith(".TXT") || FileName.endsWith(".txt")){
				    	System.out.println("the file is of text type");
				        String pathfile = tempDebits + File.separator +FileName ;
				    try{
				    	 writeToFile(gd,pathfile);
				    } catch(Exception e){
				    			fileresponse.setErrorMsg(e.getMessage());
				    			fileresponse.setsFlag(false);
				    			return fileresponse;	
				    		}	
				    	}
				    	
				if(FileName.endsWith(".CSV") || FileName.endsWith(".CSV") ){
				    System.out.println("the file is of .csv type");
				    String pathfile = tempDebits + File.separator + FileName;	
				  try{	
				       writeToCSVFile(gd,pathfile);
				     } catch(Exception e){
			    			fileresponse.setErrorMsg(e.getMessage());
			    			fileresponse.setsFlag(false);
			    			return fileresponse;
			    			
			    		   }
				    	}
				    }
			  }	
     }
     
        
  }catch(Exception e){
			System.out.println(e);
			fileresponse.setErrorMsg(e.getMessage());
			fileresponse.setsFlag(false);
			return fileresponse;
			
		}
		
		fileresponse.setStatus(1);
		fileresponse.setsFlag(true);
		return fileresponse;
		
	}


	// method used for writing the result set data to file of transcation type eso
	 private static void writeToFileDDE(List<GenerateDebitFile> filedata, String path) {
           BufferedWriter out = null;
           try {
                   File file = new File(path);
                   out = new BufferedWriter(new FileWriter(file, true));
                   
                   out.write("POLICY_CODE");
                   out.write(",");
                   out.write("BANK_ACCOUNT_CODE");
                   out.write(",");
                   out.write("BANK_ACCOUNT_HOLDER");
                   out.write(",");
                   out.write("Premium_Amount");
                   out.write(",");
                   out.write("Strike_Day");
                   out.newLine();
                   
                   for(int i=0;i<filedata.size();i++){
                	   out.write(filedata.get(i).getPolicycode());
                	   out.write(",");
                	   out.write(filedata.get(i).getBankaccountcode());
                	   out.write(",");
                	   out.write(filedata.get(i).getBankaccountholder());
                	   out.write(",");
                	   BigDecimal dc = filedata.get(i).getTotal_life_OTHER_THEBES(); 
                	   out.write(dc.toString());
                	   out.write(",");
                	   out.write(filedata.get(i).getStrikedate());
                	   out.newLine();
                   }
                    
                   out.close();
           } catch (IOException e) {  
        	 e.printStackTrace(); 
           }
   }
	   
	   
	  private static String writeToFile(List<GenerateDebitFile> filedata, String path) {
           BufferedWriter out = null;
           try {
                   File file = new File(path);
                   out = new BufferedWriter(new FileWriter(file, true));
                   
                   out.write("EMPLOYEE_NUMBER");
                   out.write(",");
                   out.write("PARTY_NAME");
                   out.write(",");
                   out.write("Premium_Amount");
                   out.write(",");
                   out.write("Strike_Day");
                   out.newLine();
                   
                   for(int i=0;i<filedata.size();i++){
                	   out.write(filedata.get(i).getEmployeecode());
                	   out.write(",");
                	   out.write(filedata.get(i).getPartyname());
                	   out.write(",");
                	   BigDecimal dc = filedata.get(i).getTotal_life_OTHER_THEBES(); 
                	   out.write(dc.toString());
                	   out.write(",");
                	   System.out.println(filedata.get(i).getStrikedate());
                	   out.write(filedata.get(i).getStrikedate());
                	   out.newLine();
                   }
                   
                   
                   out.close();
           } catch (IOException e) {
        	   
        	   return e.getMessage();
           }
           
            String success = "Record is Succesfuuly written into generated file";
           return success;
   }
	
	// method used for writing the result set data to csv file
	   private static void writeToCSVFile(List<GenerateDebitFile> filedata, String path) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
       
		   System.out.println("initial size----");
		   System.out.println(+filedata.size());
		     BufferedWriter out = null;
         try {
        	   File file = new File(path);
       	       FileWriter writer = new  FileWriter(file);
       	       CSVWriter csvWrite = new CSVWriter(writer);
       	       
       	       // defining header columns
       	       String[] entries = {"Employee_Code","Party_Name","Premium_Amount","Strike_Date"};
       	       csvWrite.writeNext(entries);
       	  
        	   // Create Mapping Strategy to arrange the  column name in order
               ColumnPositionMappingStrategy mappingStrategy=  new ColumnPositionMappingStrategy(); 
               mappingStrategy.setType(GenerateDebitFile.class);  
               
		      // colum names of java object which is coming from result set. 
              String[] columns = new String[]
              { "employeecode", "partyname", "total_life_OTHER_THEBES", "strikedate"};       
              mappingStrategy.setColumnMapping(columns);
                    
              StatefulBeanToCsvBuilder<GenerateDebitFile> builder= new StatefulBeanToCsvBuilder(writer); 
              StatefulBeanToCsv beanWriter =  builder.withMappingStrategy(mappingStrategy).build(); 
                       
              // Write list to StatefulBeanToCsv object 
               beanWriter.write(filedata);
             
               // closing the writer object 
               writer.close();
                  
                  
          } catch (IOException e) {
        	  
        	  e.printStackTrace();
        	   
           }   	   
   }
	
	   private static void writeToCSVFileDDE(List<GenerateDebitFile> filedata, String path) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
	        
		   System.out.println("initial size----"+filedata.size());
		     BufferedWriter out = null;
         try {
        	   File file = new File(path);
       	       FileWriter writer = new  FileWriter(file);
       	       CSVWriter csvWrite = new CSVWriter(writer);
                   
       	       String[] entries = {"POLICY_CODE","BANK_ACCOUNT_CODE","BANK_ACCOUNT_HOLDER","Premium_Amount","Strike_Date"};
       	       csvWrite.writeNext(entries);
       	  
        	   // Create Mapping Strategy to arrange the  column name in order
               ColumnPositionMappingStrategy mappingStrategy=  new ColumnPositionMappingStrategy(); 
               mappingStrategy.setType(GenerateDebitFile.class);  
               
		       // Arrange column name as provided in below array. 
               String[] columns = new String[]
               { "policycode", "bankaccountcode","bankaccountholder", "total_life_OTHER_THEBES", "strikedate"};       
                mappingStrategy.setColumnMapping(columns);
                    
                StatefulBeanToCsvBuilder<GenerateDebitFile> builder= new StatefulBeanToCsvBuilder(writer); 
                StatefulBeanToCsv beanWriter =  builder.withMappingStrategy(mappingStrategy).build(); 
                       
                // Write list to StatefulBeanToCsv object 
                 beanWriter.write(filedata);
             
                 // closing the writer object 
                 writer.close();
                  
                  
          } catch (IOException e) {
        	  e.printStackTrace();
           }
        	         
	       	   
   }
	
	@Override
	public List<GenerateDebitFile> getpaypointtransdebitfilerecords(BigDecimal paypointid,java.util.Date paypointduedate, double pphdrid) {
		   List<GenerateDebitFile> gdf = new ArrayList<GenerateDebitFile>();
		try{
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(paypointduedate);
		  String formatedDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
		  Date paypointduedateperiod = Date.valueOf(formatedDate);
		  
		 // below jpa method will fetch all records which are inserted will running generate debit file procedure
		  List<Object[]>   appi = tdr.getpaypointtransdebitfilerecords(paypointid, paypointduedateperiod,pphdrid);
		  System.out.println(appi.size());   	
	  if(appi != null && !appi.isEmpty()){
			for(Object[] ob:appi){
				GenerateDebitFile df = new GenerateDebitFile();
				
				df.setPaypointid((BigDecimal) ob[0]);
				df.setPartyid((BigDecimal) ob[1]);
				df.setPartyidetificationcode((String) ob[2]);
				df.setEmployeecode((String) ob[3]);
				df.setPartyname((String) ob[4]);
				df.setPolicycode((String) ob[5]);
				df.setProductidcode((String) ob[6]);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         	    String strDate = dateFormat.format(ob[7]);
				df.setStrikedate( (String) strDate);
				df.setBankcode((String) ob[8]);
				df.setBranchcode((String) ob[9]);
				df.setBankaccountcode((String) ob[10]);
				df.setBankaccountholder((String) ob[11]);
				df.setBankaccounttype((String) ob[12]);
				df.setPensionprem((BigDecimal) ob[13]);
				df.setOtherprem((BigDecimal) ob[14]);
				df.setTotal_life_OTHER_THEBES((BigDecimal) ob[15]);
				df.setPaypointduedate((Date) ob[16]);
				df.setCollectionperiod((Date) ob[17]);
				gdf.add(df);		
			}
			
	}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return gdf;
	}

}
