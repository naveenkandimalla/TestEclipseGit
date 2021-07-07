package com.sais.cashoffice.CashOfficeTest.admin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.admin.model.ModuleModel;
import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessAuthority;
import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessMaster;
import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessQueryModel;
import com.sais.cashoffice.CashOfficeTest.admin.service.ModuleModelServiceImpl;
import com.sais.cashoffice.CashOfficeTest.admin.service.PageAccessAuthorityServiceImpl;
import com.sais.cashoffice.CashOfficeTest.admin.service.PageAccessMasterServiceImpl;
import com.sais.cashoffice.CashOfficeTest.admin.service.PageAccessQueryServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class PageAccessMasterController {
	
	
	@Autowired
	private ModuleModelServiceImpl mms;
	
	
	@Autowired
	private PageAccessMasterServiceImpl pams;
	
	
	@Autowired
	private PageAccessAuthorityServiceImpl paas;
	
	@Autowired
	private PageAccessQueryServiceImpl pas;
	
	
	// fetching t_module details 
	@GetMapping(path="/admin/PageAccessMaster/ModuleDetails")
	public List<ModuleModel> fetchtmoduledetails(){
		
		
		return mms.getModuledetails();	
		
		
	}
	
	// fetching T_PAGEACCESS_MASTER details 
	@GetMapping(path="/admin/PageAccessMaster/tpageaccessmaster")
	public List<PageAccessMaster> fetchtpagemasterdetails(){
		
		
		return pams.getpageaccessMasterdetails();
		
		
	}
	
	
	// inserting record into T_PAGEACCESS_MASTER
	@PostMapping(path="/admin/PageAccessMaster/insertrecordpageaccesmaster")
	public ResponseEntity<?> insertrecordpageaccessmaster(@RequestBody PageAccessMaster pm){
		
		System.out.println(pm.getScreenCode());
		System.out.println(pm.getScreenDesc());
		System.out.println(pm.getUrl());
		System.out.println(pm.getModuleid());
		System.out.println(pm.getCreatedBy());
		System.out.println(pm.getStatus());
		
		Date createddate = new Date();
		char e;
		char s = pm.getStatus();
		 if(s=='o'){
			 
			e='1'; 
			 
		 }else{
			 e='0';
		 }
		
		
		double pageaccessid = (double) pams.insertrecordpageaccessmaster(pm.getScreenCode(), pm.getScreenDesc(),
				                                                 pm.getUrl(), pm.getModuleid(), createddate, 
				                                                 pm.getCreatedBy(),e);
		return  ResponseEntity.ok().body(pageaccessid);
		
	}
	
	
	// update record data T_PAGEACCESS_MASTER
	@PutMapping(path="/admin/PageAccessMaster/updaterecordpageaccesmaster")
	public ResponseEntity<?> updaterecordpageaccessmaster(@RequestBody PageAccessMaster pm){
		
		System.out.println(pm.getPageaccessId());
		System.out.println(pm.getScreenCode());
		System.out.println(pm.getScreenDesc());
		System.out.println(pm.getUrl());
		System.out.println(pm.getModuleid());
		System.out.println(pm.getModifiedBy());
		System.out.println(pm.getStatus());
		Date modifiteddate = new Date();
		
		char e;
		char s = pm.getStatus();
		 if(s=='o'){
			 
			e='1'; 
			 
		 }else{
			 e='0';
		 }
		
		double pageaccessid = (double) pams.updaterecordpageaccessmaster(pm.getPageaccessId(),pm.getScreenCode(),
				                                                pm.getScreenDesc(), pm.getUrl(), pm.getModuleid(),
				                                                  modifiteddate, pm.getModifiedBy(),e);
		
		
		return ResponseEntity.ok().body(pageaccessid);
	}
	
	
	// fetch pageaccess authority details using pageaccess id 
	@GetMapping(path="/admin/PageAccessMaster/getpageaccesdetailsbypageaccesid")
	public List<PageAccessQueryModel>  fetchpageaccessdetailsbyrole(@RequestParam("pageaccessid") double pageaccessid ){
		
		System.out.println(pageaccessid);
		
		return pas.fetchrolebypageaccessid(pageaccessid);
	}
	
	
	
	
	// inserting record into T_PAGEACCESS_AUTHORITIES
		@PostMapping(path="/admin/PageAccessMaster/insertpageaccessauthority")
		public ResponseEntity<?> insertrecordpageaccessauthorities(@RequestBody PageAccessAuthority pa){
			
			System.out.println(pa.getAuthority());
			System.out.println(pa.getEnabled());
			System.out.println(pa.getPageaccessId());
			System.out.println(pa.getCreatedBy());
			
			Date createddate = new Date();
			char e;
			char s = pa.getEnabled();
			 if(s=='o'){
				 
				e='1'; 
				 
			 }else{
				 e='0';
			 }
			
			
		double PAGEACCESS_ROLE_ID = (double) paas.insertrecordpageaccessauthority(pa.getAuthority(), e, 
					                                                         pa.getPageaccessId(), createddate, 
					                                                         pa.getCreatedBy());
			
			return ResponseEntity.ok().body(PAGEACCESS_ROLE_ID);
           	
		}
		
		
		// update record data T_PAGEACCESS_AUTHORITIES
		@PutMapping(path="/admin/PageAccessMaster/updaterecordpageaccessauthority")
		public ResponseEntity<?> updaterecordpageaccessauthorities(@RequestBody PageAccessAuthority pa) {
			
	
			System.out.println(pa.getPageaccessRoleId());
			System.out.println(pa.getPageaccessId());
			System.out.println(pa.getAuthority());
			System.out.println(pa.getEnabled());
			System.out.println(pa.getModifiedBy());
			
			Date modifieddate = new Date();
			
			System.out.println(modifieddate);
			char e;
			char s = pa.getEnabled();
			 if(s=='o'){
				 
				e='1'; 
				 
			 }else{
				 e='0';
			 }
			
			
			double PAGEACCESS_ROLE_ID = (double) paas.updaterecordT_PAGEACCESS_AUTHORITIES( pa.getPageaccessId(),
				                                                              pa.getAuthority(), modifieddate,
				                                                             e, pa.getModifiedBy(),pa.getPageaccessRoleId());			
		return ResponseEntity.ok().body(PAGEACCESS_ROLE_ID);
			
		}
  
	 
	
	

}
