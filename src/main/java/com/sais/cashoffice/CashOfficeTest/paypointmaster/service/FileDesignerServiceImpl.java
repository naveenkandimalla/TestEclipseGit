package com.sais.cashoffice.CashOfficeTest.paypointmaster.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sais.cashoffice.CashOfficeTest.entities.TPpCrFileFormatHdr;
import com.sais.cashoffice.CashOfficeTest.entities.TPpCrFileFormatLine;
import com.sais.cashoffice.CashOfficeTest.entities.TPpTemplate;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.FileDesignerHdrForm;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.FileDesignerhdrLinesForm;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.TPpCrFileFormatHdrRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.TPpCrFileFormatLineRepository;
import com.sais.cashoffice.exception.ErrorDetails;
import com.sais.cashoffice.exception.Response;

@Service
public class FileDesignerServiceImpl implements FileDesignerService {

	@Autowired
	ModelMapper modelmapper;

	@Autowired
	TPpCrFileFormatHdrRepository hdrRepo;

	@Autowired
	TPpCrFileFormatLineRepository ffLinesRepo;

	@Override
	@Transactional
	public ResponseEntity<?> saveFileFormatHdrDetails(FileDesignerhdrLinesForm form,String createdby) {
		//System.out.println("succesfully we enter into service implement");
		String message = "";
		Response resp = null;
		TPpCrFileFormatHdr id = null;
		TPpCrFileFormatLine flId = null;
		try {
			TPpCrFileFormatHdr ffh = modelmapper.map(form, TPpCrFileFormatHdr.class);
			ffh.setNoOfCreditHdrLines(Long.valueOf(form.getNoOfCrHdrLines()));
			ffh.setPaypointId(form.getPpId());
			ffh.setPaypointName(form.getPpName());
			ffh.setCreationDate(new Date());
			//System.out.println("we are ready for calling find by paypointid");
			TPpCrFileFormatHdr tpt = hdrRepo.findByPaypointId(form.getPpId());
			//System.out.println(tpt+"--find by paypointid");
			if (tpt != null) {
				ffh.setPaypointFileId(tpt.getPaypointFileId());
				ffh.setModifiedBy(createdby);
				ffh.setModifiedDatetime(new Date());
				id = hdrRepo.save(ffh);
				message = message + "Updated data into T_PP_CR_FILE_FORMAT_HDR for paypoint " + id.getPaypointId();
			   System.out.println("code line is 56 succesfully updated reord in with PP_FILE_FORMAT_ID---> "+id.getPaypointFileId());
			} else {
			//	System.out.println("if new record is ready for inserting---->");
				ffh.setCreatedBy(createdby);
				ffh.setCreationDate(new Date());
				id = hdrRepo.save(ffh);	
				//System.out.println(id+"--code line is 61 checking id with which its inserted");
				message = message + "Inserted data into T_PP_CR_FILE_FORMAT_HDR for paypoint " + id.getPaypointId()
						+ " generated record id :" + id.getPaypointFileId();
				 //System.out.println("code line is 56 succesfully inserted reord in with PP_FILE_FORMAT_ID---> "+id.getPaypointFileId());	
			}
			
			if (form.getFieldName() != null) {
				System.out.println("after successfully insert/update we are ready for to det file table ");
				TPpCrFileFormatLine ffl = modelmapper.map(form, TPpCrFileFormatLine.class);
				System.out.println(ffl.getFieldName()+"---very import one");
				ffl.setPaypointId(id.getPaypointId());
				ffl.setPaypointName(id.getPaypointName());
				ffl.setPpFileId(id.getPaypointFileId());
				ffl.setLineType("LINES");
				System.out.println(id.getPaypointFileId()+"code line 77 this both are very import");
				System.out.println(ffl.getFieldName()+"code line 78");
				TPpCrFileFormatLine tffl = ffLinesRepo.findByPpFileIdAndFieldName(id.getPaypointFileId(),
						ffl.getFieldName());
				if (tffl != null) {
					System.out.println("updating T_PP_CR_FILE_FORMAT_LINE table");
				System.out.println("updatig the data T_PP_CR_FILE_FORMAT_LINE");
					ffl.setPpFileFormatId(tffl.getPpFileFormatId());
					ffl.setFieldSequence(tffl.getFieldSequence());
					ffl.setModifiedBy(createdby);
					ffl.setModifiedDatetime(new Date());
					flId = ffLinesRepo.save(ffl);
					message = message + " Updated data into T_PP_CR_FILE_FORMAT_LINE for fileFormat Id "
							+tffl.getPpFileFormatId();
					//System.out.println("updating with id --->code line 86"+tffl.getPpFileFormatId());
					
				} else {
					System.out.println("creating the data T_PP_CR_FILE_FORMAT_LINE");
					ffl.setFieldSequence(ffLinesRepo.getMaxSequenceByFileId(id.getPaypointFileId()) + 1);
					System.out.println(ffl.getFieldSequence()+"---max value");
					Date creationdate = new Date();
					ffl.setCreationDate(creationdate);
					ffl.setCreatedBy(createdby);
					flId = ffLinesRepo.save(ffl);
					message = message + " inserted data into T_PP_CR_FILE_FORMAT_LINES for paypoint "
							+ flId.getPaypointId() + " generated record id :" + flId.getPpFileFormatId();
					System.out.println("after inserting "+ flId.getPpFileFormatId());
				}

			}
			resp=new Response(200, message);
			return new ResponseEntity<>(resp, HttpStatus.OK);
		} catch (Exception e) {
			
			message = "Failed to Assign File to paypoint" + form.getPpId() + " !";
			ErrorDetails error = new ErrorDetails(new Date(), message, null);
			return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	public List<FileDesignerHdrForm> findAllAssignedFileDetails() {
		List<FileDesignerHdrForm> list = new ArrayList<FileDesignerHdrForm>();
//		List<TPpCrFileFormatHdr> tpcf = hdrRepo.findAll();
//		System.out.println(tpcf.size());
		hdrRepo.findAll().forEach((hdr) -> {
			FileDesignerHdrForm fdhf = new FileDesignerHdrForm();
			fdhf.setPpId(hdr.getPaypointId());
			fdhf.setPpName(hdr.getPaypointName());
			fdhf.setPaypointFileId(hdr.getPaypointFileId());
			fdhf.setFileName(hdr.getFileName());
			fdhf.setCurrency(hdr.getCurrency());
      		fdhf.setNoOfCrHdrLines(String.valueOf(hdr.getNoOfCreditHdrLines()));
			list.add(fdhf);
		});
		return list;
				
				//return null;

	}

	@Override
	public List<FileDesignerhdrLinesForm> findAllAssignedFieldDetails(long ppId) {
		List<FileDesignerhdrLinesForm> list = new ArrayList<FileDesignerhdrLinesForm>();
		Long ppfieldid= hdrRepo.findByPaypointId(ppId).getPaypointFileId();
		List<TPpCrFileFormatLine> pp =ffLinesRepo.findByPpFileId(ppfieldid);
		System.out.println(ppfieldid);
		System.out.println(pp);
		
		if(pp != null && !pp.isEmpty()){
			
			for(TPpCrFileFormatLine hdrl:pp ){
				
				FileDesignerhdrLinesForm fdhl = new FileDesignerhdrLinesForm();			
				fdhl.setFieldSequence((long) hdrl.getFieldSequence());
				System.out.println(fdhl.getFieldSequence());
				fdhl.setFieldName(hdrl.getFieldName());
				System.out.println(fdhl.getFieldName());
				fdhl.setDelimiter(hdrl.getDelimiter());
				System.out.println(fdhl.getDelimiter());
				System.out.println(hdrl.getStartPosition());
				fdhl.setStartPosition(hdrl.getStartPosition());
			    System.out.println(fdhl.getStartPosition());
				fdhl.setEndPosition(hdrl.getEndPosition());
				System.out.println(fdhl.getEndPosition());
				fdhl.setLength(hdrl.getLength());
				System.out.println(fdhl.getLength());
				fdhl.setDatatype(hdrl.getDataType());
				System.out.println(hdrl.getDataType());
				fdhl.setConstants(hdrl.getConstants());
				System.out.println(hdrl.getConstants());
				fdhl.setPpFileFormatId(hdrl.getPpFileFormatId());
				System.out.println(fdhl.getPpFileFormatId());
				fdhl.setPpId(ppId);
				System.out.println(fdhl.getPpId());
				fdhl.setPaypointFileId(hdrRepo.findByPaypointId(ppId).getPaypointFileId());
				list.add(fdhl);
			  }
			
//	
	    }
		return list;
	}

	@Override
	public ResponseEntity<String> deleteFieldWithId(long id) {
		try {
			ffLinesRepo.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}
}
