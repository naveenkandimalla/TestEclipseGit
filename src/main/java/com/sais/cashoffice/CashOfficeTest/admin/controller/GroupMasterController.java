package com.sais.cashoffice.CashOfficeTest.admin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.admin.model.TGroups;
import com.sais.cashoffice.CashOfficeTest.admin.service.GroupMasterServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class GroupMasterController {
	
	@Autowired
	private GroupMasterServiceImpl gms;
	
	
	@PostMapping(path="/admin/groupmaster/insertrecordgroup")
	public ResponseEntity<?> insertrecordtgroup(@RequestBody TGroups tg){
		
		System.out.println(tg.getCreatedby());
		System.out.println(tg.getGroupdesc());
		System.out.println(tg.getGroupname());
		
		Date creationdate = new Date();
		
		 double groupid =	(double) gms.insertrecordtgroup(tg.getGroupname(), tg.getGroupdesc(), tg.getCreatedby(), creationdate);
	   System.out.println(groupid);
		
	  return ResponseEntity.ok().body(groupid);
	}
	
	
	
	@PutMapping(path="/admin/groupmaster/updaterecordgroup")
	public ResponseEntity<?> updaterecordtgroup(@RequestBody TGroups tg){
		
		System.out.println(tg.getModifiedby());
		System.out.println(tg.getId());
		System.out.println(tg.getGroupname());
		System.out.println(tg.getGroupdesc());
		
		Date modifieddate = new Date();
		
		 double groupid = (double) gms.updaterecordtgroup(tg.getGroupname(), tg.getGroupdesc(), tg.getModifiedby(), modifieddate, tg.getId());
		 
		 System.out.println(groupid);
		 
	  return ResponseEntity.ok().body(groupid);
	}
	
	

}
