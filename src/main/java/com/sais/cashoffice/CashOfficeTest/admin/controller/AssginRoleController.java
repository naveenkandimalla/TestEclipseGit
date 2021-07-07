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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.admin.model.AssignRoleQueryModel;
import com.sais.cashoffice.CashOfficeTest.admin.model.GroupAuthorityModel;
import com.sais.cashoffice.CashOfficeTest.admin.model.Group_Authorities_Master;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;
import com.sais.cashoffice.CashOfficeTest.admin.repository.AssignRoleRepository;
import com.sais.cashoffice.CashOfficeTest.admin.service.AssignRoleServiceImple;
import com.sais.cashoffice.CashOfficeTest.admin.service.UserManagementServiceImpl;




@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class AssginRoleController {
   
	 @Autowired
	private AssignRoleServiceImple ars;
	 
	 
	 @Autowired
	 private AssignRoleRepository ar;
	
	 
	 //fetching the roleid,role name details
	 @GetMapping(path="/admin/roledetails")
	 public List<Group_Authorities_Master> fetchallgroupusers(){
		 
		 return ars.getallGroupAuthorities();
		 
	 }
	 
	 
	 // insert record to authority group GROUP_AUTHORITIES_MASTER
	 @PostMapping(path="/admin/usermangement/insertgroupauthoritymaster")
	 public ResponseEntity<?> insertgroupauthority(@RequestBody Group_Authorities_Master gam){
		 
		 
		 System.out.println(gam.getAuthority());
		 System.out.println(gam.getGroupauthoritydesc());
		 System.out.println(gam.getCreatedBy());
		 
		 Date creationdate = new Date();
		 String status = (String) ars.insertrecordgroupauthority(gam.getAuthority(), gam.getGroupauthoritydesc(), creationdate, gam.getCreatedBy());
		 
		 System.out.println(status);
		 return ResponseEntity.ok().body(1);
	 }
	 
	 
	 
	 // update record to authority group GROUP_AUTHORITIES_MASTER
	 @PutMapping(path="/admin/usermangement/updategroupauthoritymaster")
	 public ResponseEntity<?> updategroupauthority(@RequestBody Group_Authorities_Master gam){
		 
		 
		 System.out.println(gam.getAuthority());
		 System.out.println(gam.getGroupauthoritydesc());
		 System.out.println(gam.getModifiedBy());
		 System.out.println(gam.getCreationDate());
		 
		 Date modifieddate = new Date();
		 String status = (String) ars.updaterecordgroupauthority(gam.getAuthority(), gam.getGroupauthoritydesc(), modifieddate, gam.getModifiedBy(), gam.getCreationDate());
		 
		 System.out.println(status);
		 
		 return  ResponseEntity.ok().body(1);
	 }
	 

	 // fetch assign role querydetails 
	 
	 @GetMapping(path="/admin/usermangement/assignroledetails")
	 public List<Object[]> fetchassignroles(@RequestParam("authority") String authority){
		
		 System.out.println(" authority --->"+authority);
 
		 
		 return ar.fetchassignroledetails(authority);
	 }
	 
	 
	 // insert record into groupauthority
	 
	 @PostMapping(path="/admin/usermangement/insertrecordgroupauthority")
	 public ResponseEntity<?>  insertrecordgroupauthority(@RequestBody GroupAuthorityModel gam){
		 char e;
		 System.out.println(gam.getAuthority());
		 System.out.println(gam.getGroupid());
		 System.out.println(gam.getEnabled());
		 System.out.println(gam.getCreatedby());
		 char s = gam.getEnabled();
		 if(s=='o'){
			 
			e='1'; 
			 
		 }else{
			 e='0';
		 }
		 
		 Date creationdate = new Date(); 
		 
		 String status = (String) ars.insertrecordgroupauyhorities(gam.getAuthority(), gam.getGroupid(), e, creationdate, gam.getCreatedby());
		
		System.out.println(status);
		
		return ResponseEntity.ok().body(1);
		
	 }
	 
	 
	 
	 @PutMapping(path="/admin/usermangement/updaterecordgroupauthority")
	 public ResponseEntity<?>  updaterecordgroupauthority(@RequestBody GroupAuthorityModel gam){
		 char e;
		
		 System.out.println(gam.getGroupid());
		 System.out.println(gam.getEnabled());
		 System.out.println(gam.getModifiedby());
		 char s = gam.getEnabled();
		 if(s=='o'){
			 
			e='1'; 
			 
		 }else{
			 e='0';
		 }
		 
		 Date modifidationdate = new Date(); 
		 
		String status = (String) ars.updaterecordgroupauyhorities(gam.getEnabled(), modifidationdate, gam.getModifiedby(), gam.getGroupid());
				
		
		System.out.println(status);
		
		return ResponseEntity.ok().body(1);
		
	 }
}
