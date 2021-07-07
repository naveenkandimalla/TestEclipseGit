package com.sais.cashoffice.CashOfficeTest.paypointmaster.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sais.cashoffice.CashOfficeTest.entities.TFileNamingFormat;
import com.sais.cashoffice.CashOfficeTest.entities.TPayPoint;
import com.sais.cashoffice.CashOfficeTest.entities.TPpAttribute;
import com.sais.cashoffice.CashOfficeTest.entities.TPpTemplate;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.AssignDbtFileTmpt;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.DebitFileTemplateModel;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.FileNamingFormatForm;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.FileNamingFormatRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.PaypointAttrbutesRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.PaypointRepository;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.PaypointTemplateRepository;
import com.sais.cashoffice.exception.ErrorDetails;
import com.sais.cashoffice.exception.Response;

@Service
public class PaypointServiceImpl implements PaypointService {

	@Autowired
	PaypointRepository ppRepo;

	@Autowired
	PaypointAttrbutesRepository paRepo;

	@Autowired
	FileService fileservice;

	@Autowired
	ModelMapper modelmapper;

	@Autowired
	PaypointTemplateRepository ppTmplrepo;

	@Autowired
	FileNamingFormatRepository fnfRepo;

	@Override
	public List<TPayPoint> fetchAllPaypoints() {
		// TODO Auto-generated method stub
		return this.ppRepo.findAll();
	}

	@Override
	public List<TPpAttribute> fetchPaypointAttributes() {
		// TODO Auto-generated method stub
		return this.paRepo.findAll();
	}

	@Transactional
	@Override
	public ResponseEntity<?> assignDebitFileTemplate(AssignDbtFileTmpt form, MultipartFile file,String createdby,String modifiedby) {
		String message = "";
		Response resp = null;
		TPpTemplate id = null;
		TFileNamingFormat fnfid = null;
		try {
			//fileservice.store(file,FileService.templatesLocation);
			//message = "You have successfully uploaded debitfile " + file.getOriginalFilename() + "!";
			form.setPpTemplateCode(file.getOriginalFilename());
			//form.setPpTemplatePath(FileService.templatesLocation.toUri().toString());
		
			// setting up pp_template entity for saving
			TPpTemplate asgnTmpl = modelmapper.map(form, TPpTemplate.class);
			System.out.println("check box values "+form.getOtherPremOnly());
			System.out.println("check box values "+form.getPensionOnly());
			
			asgnTmpl.setOtherPremOnlyYn(form.getOtherPremOnly());
			asgnTmpl.setPensionOnlyYn(form.getPensionOnly());
			asgnTmpl.setPaypointId(Long.valueOf(form.getPpId()));
			asgnTmpl.setPpAttributeId(form.getPpAttributeId());
			TPpTemplate tpt = ppTmplrepo.findByPaypointId(form.getPpId());
			if (tpt != null) {
				asgnTmpl.setPpTemplateId(tpt.getPpTemplateId());
				asgnTmpl.setModifiedBy(modifiedby);
				asgnTmpl.setModifiedDatetime(new Date());
				id = ppTmplrepo.save(asgnTmpl);
				message = message + " Updated data into T_PP_TEMPLATE for paypoint " + tpt.getPpTemplateId();
			} else {
				asgnTmpl.setCreatedBy(createdby);
				asgnTmpl.setCreationDate(new Date());
				id = ppTmplrepo.save(asgnTmpl);
				message = message + " inserted data into T_PP_TEMPLATE for paypoint " + id.getPpTemplateId();
			}

			// setting file_naming_format entity
			FileNamingFormatForm fnf = new FileNamingFormatForm();
			fnf.setPaypointId(Long.valueOf(form.getPpId()));
			fnf.setConstant(form.getFfConstantValue());
			fnf.setPeriod(form.getFfPeriod());
			fnf.setStrikeDate(form.getFfStrikeday());
			fnf.setFileExtension(form.getFfFileExtension());
			TFileNamingFormat filenf = modelmapper.map(fnf, TFileNamingFormat.class);
			filenf.setPpTemplate(id);
			
			//fetching T_PP_TEMPLATE 
			System.out.println(filenf.getPpTemplate().getPpTemplateId());
			TFileNamingFormat tfnf = fnfRepo.findByPaypointId(form.getPpId());
			System.out.println("PP_FILE_NAME_FORMAT_ID {} : "+tfnf.getPpFileNameFormatId());

			if (tfnf != null) {
				filenf.setPpFileNameFormatId(tfnf.getPpFileNameFormatId());
				filenf.setModifiedBy(modifiedby);
				filenf.setModifiedDatetime(new Date());
				fnfid = fnfRepo.save(filenf);
				message = message + " Updated data into T_FILE_NAMING_FORMAT for paypoint " + fnfid.getPaypointId();
			} else {
				filenf.setCreatedBy(createdby);
				filenf.setCreationDate(new Date());
				//double filenamefromatteid= fnfRepo.fetchmaxfilenamingid();
				//filenf.setPpFileNameFormatId(filenamefromatteid);
				fnfid = fnfRepo.save(filenf);
				System.out.println(fnfid.getPpTemplate().getPpTemplateId());
				message = message + " inserted data into T_FILE_NAMING_FORMAT for paypoint " + fnfid.getPaypointId();
			}
			System.out.println(ResponseEntity.status(HttpStatus.OK).body(message));
			resp = new Response(200, message);
			return new ResponseEntity<>(resp, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Failed to Assign template to paypoint " + file.getOriginalFilename() + "! " + e.getMessage();
			ErrorDetails error = new ErrorDetails(new Date(), message, null);
			return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@Override
	public List<AssignDbtFileTmpt> fetchAsgndPayPointDetails() {
		List<TPpTemplate> tmplList = ppTmplrepo.findAll();	
	    List<AssignDbtFileTmpt> result = new ArrayList<AssignDbtFileTmpt>();
	    
	    // converting for each loop to for loop
	    //for (TPpTemplate pt : tmplList)
	    
	      // previously developed by code
	 	  //asgtmplForm.setPpName(this.ppRepo.findById(pt.getPaypointId()).orElse(null).getPayPointName());
	 			
	    //System.out.println(asgtmplForm.getPpAttributeDesc());
		
		//System.out.println(pt.getPpTemplateId());
		
		//pervious code developed
		//TFileNamingFormat tfnf = pt.getFileNamingFormats().get(0);
		
		// new code for the same scenario of above code
		
		//pervious code developed			
	    //asgtmplForm.setFfConstantValue(tfnf.getConstant());
        //asgtmplForm.setFfPeriod(tfnf.getPeriod());
        //asgtmplForm.setFfStrikeday(tfnf.getStrikeDate());
         //asgtmplForm.setFfFileExtension(tfnf.getFileExtension());
	     //	result.add(asgtmplForm);
	    
	    
		
		for (int i = 0; i < tmplList.size(); i++) {
			TPpTemplate pt = tmplList.get(i);
			AssignDbtFileTmpt asgtmplForm = new AssignDbtFileTmpt();
			
			asgtmplForm.setPpId(pt.getPaypointId());
	        
			
			asgtmplForm.setPpName(this.ppRepo.fetchpaypointname(pt.getPaypointId()));
			
			asgtmplForm.setSelectTemplate(pt.getPpTemplateCode());
		    asgtmplForm.setPpAttributeId(pt.getPpAttributeId());
			asgtmplForm.setPensionOnly((char)pt.getPensionOnlyYn());
			asgtmplForm.setOtherPremOnly(pt.getOtherPremOnlyYn());
			asgtmplForm.setPpAttributeDesc(this.paRepo.findById(pt.getPpAttributeId()).orElse(null).getAttrComDesc());
			
			
			
			List<Object[]> tfbf = ppTmplrepo.fetchTfileNamingfromattebypptemplateid(pt.getPpTemplateId());
			
			
			if((tfbf.size())-1 > i ){
				
			
				for (int j = 0; j <=i; j++) {
					Object[] appi = tfbf.get(j);
					asgtmplForm.setFfConstantValue((String)appi[0]);
					asgtmplForm.setFfPeriod((String) appi[1]);
					asgtmplForm.setFfStrikeday((String) appi[2]);
					asgtmplForm.setFfFileExtension((String) appi[3]);
				}
				
			}
			
		
			// final we are returning the object
			result.add(asgtmplForm);
		}
		return result;
	}

	@Override
	public List<DebitFileTemplateModel> getalltemplatedetails() {
		
		
		List<DebitFileTemplateModel> dt = new ArrayList<DebitFileTemplateModel>();
		List<Object[]> appi = paRepo.ftechtemplatedetails();
		
		if(appi != null &&  !appi.isEmpty()) {
			for(Object[] object:appi) {
				DebitFileTemplateModel t = new DebitFileTemplateModel();
				
				t.setPaypointid((BigInteger) object[0]);
				t.setPaypointname((String) object[1]);
				t.setTemplatecode((String) object[2]);
				t.setAttributedesc((String) object[3]);
				t.setConstant((String) object[4]);
				t.setPeriod((String) object[5]);
				t.setStrikedate((String) object[6]);
				t.setFileextension((String) object[7]);
				t.setPpattributeid((BigInteger) object[8]);
				String pension=(String) object[9]; 
				char p= pension.charAt(0);
				t.setPensiononly(p);
				String otherpension=(String) object[10]; 
				char op= otherpension.charAt(0);
				t.setOtherpensiononly(op);
				dt.add(t);
			}	
			
		}	
		return dt;
	}
}
