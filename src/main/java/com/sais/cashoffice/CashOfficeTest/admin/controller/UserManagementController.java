package com.sais.cashoffice.CashOfficeTest.admin.controller;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
import com.sais.cashoffice.CashOfficeTest.admin.model.BranchCode;
import com.sais.cashoffice.CashOfficeTest.admin.model.GroupMemberDetails;
import com.sais.cashoffice.CashOfficeTest.admin.model.TGroups;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;
import com.sais.cashoffice.CashOfficeTest.admin.model.UserGroupdetails;
import com.sais.cashoffice.CashOfficeTest.admin.service.GroupMemberDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.admin.service.TGroupsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.admin.service.UserGroupdetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.admin.service.UserManagementServiceImpl;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserManagementController {
	
	@Autowired
	private UserManagementServiceImpl usermanagementserviceimpl;
	
	
	@Autowired
	private TGroupsServiceImpl tgs;
	
	@Autowired
	private UserGroupdetailsServiceImpl ugs;
	
	@Autowired
	private GroupMemberDetailsServiceImpl gmd;
	
	
	// used for fetching the branches names 
	@GetMapping(path = "/admin/branchnames")
    public List<BranchCode> fetchalldetailsofbranchname(){
		
		return usermanagementserviceimpl.getallbranchnames();
	}
	
	
	// used for fetching the existing users
	
	@GetMapping(path = "/admin/usermanagement")
     public List<User> fetchalldetailsofusers(){
		
		return usermanagementserviceimpl.getallusers();
	}
	
	  
	 @PostMapping(path="/admin/usersave")
	 public ResponseEntity<?> saveuserDetails(@RequestParam("branchcode") String branchcode, @RequestBody User c,@RequestParam("createdby") String createdby){
		 
		 System.out.println(c.getUsername());
		 System.out.println(c.getFirstName());
		 System.out.println(c.getLastName());
		 System.out.println(c.getPassword());
		 System.out.println(c.getEnabled());
		 System.out.println(branchcode);
		System.out.println(createdby);
		 
		 
		 c.setBranchCode(branchcode);
		 System.out.println(c.getBranchCode()); 
		 Date creationdate = new Date();
		 c.setCreationDate(creationdate);
		
		 double userid =usermanagementserviceimpl.saverecorduser(c.getFirstName(), c.getLastName(), c.getUsername(),
				                                                  c.getPassword(), creationdate, createdby,
				                                                  c.getEnabled(), c.getBranchCode());
		 
		 
		 System.out.println(userid);
		 
		 return  ResponseEntity.ok().body(userid);
		 
		
		
	 }
	 
	  
	 
	
	 @PutMapping(path="/admin/usermanagement/userupdatedrecord")
	 public ResponseEntity<?> updateRecord(@RequestParam("userid") double userid,@RequestParam("branchcode") String branchcode,@RequestBody User c){
    
       System.out.println(c.getFirstName());
       System.out.println(c.getLastName());
       System.out.println(c.getUsername());
       System.out.println(userid);
       System.out.println(branchcode);
       c.setModifiedBy("test");
	    Date modifieddate = new Date();
 
	    
	    double sucessd=usermanagementserviceimpl.update(c.getFirstName(), c.getLastName(), c.getUsername(), c.getEnabled(), c.getModifiedBy(),modifieddate, userid,branchcode);
	 
       	System.out.print(sucessd);
	 
		 return ResponseEntity.ok().body(sucessd);
       
     
	 
}
	 
	 
	 
	  // fetching tgroup details
	 
	 @GetMapping(path="/admin/usermangement/tgroupdetails")
	 public List<TGroups> fetchtgroupdetails(){
		 
		 
		 return tgs.getallgroupsdetails();
	 }
	 
	 
	 // fetching the user group details 
	 @GetMapping(path="/admin/usermangement/usergroupdetails")
      public List<UserGroupdetails> fetchusergroupdetails(@RequestParam("username") String username){
		 
		 return ugs.getusergroupdetails(username);
	 }
	 
	 // inserting record to group member table
	 @PostMapping(path="/admin/usermangement/insertrecordgroupmember")
	 public ResponseEntity<?> insertrecordgroupmemner(@RequestBody GroupMemberDetails gm,@RequestParam("enable") String enable){
		 
		 
		 System.out.println(gm.getGroupId());
		 System.out.println(gm.getUsername());
		 System.out.println(enable);
		 System.out.println(gm.getCreationDate());
		 System.out.println(gm.getCreatedBy());
		 
		 Date creationdate = new Date();
	 double groupmmid = gmd.insertrecordgroupmember(gm.getGroupId(), gm.getUsername(),
			                                           enable, creationdate, gm.getCreatedBy());
		 
		 System.out.println(groupmmid);
		 
		 return ResponseEntity.ok().body(groupmmid);
				 
	 }
	 
	 
	 // update group member record 
	 
	 @PutMapping(path="/admin/usermangement/updategroupmember")
	 public ResponseEntity<?> updaterecordgroupmember(@RequestBody GroupMemberDetails gm,@RequestParam("enable") String enable){
		 
		 
		 System.out.println(gm.getGroupId());
		 System.out.println(gm.getGroupMemId());
		 System.out.println(enable);
		// System.out.println(gm.getModifiedDatetime());
		 System.out.println(gm.getModifiedBy());
		 
		 Date modifieddate = new Date();
		 
		// char enablecode= (char) enable;
		
		 double groupmemid = gmd.updaterecordgroupmember(gm.getGroupMemId(), enable,
				 gm.getGroupId(), modifieddate, gm.getModifiedBy());
		 
		 System.out.println(groupmemid);
	 
		 return ResponseEntity.ok().body(groupmemid);
				 
	 }
	 
	 
	 
	 
	 
	 
}

