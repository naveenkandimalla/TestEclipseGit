package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.admin.model.BranchCode;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;


public interface UserManagementService {
	
	public List<User> getallusers();
	
//	User saveUserDetails(User u);
	
    int update(String firstname,String lastname,String Username,int enable,String modifiedby,Date modifieddate,double userid,String branchcode);
	
	User getUserDetailsByName(String name);
	
	public List<BranchCode> getallbranchnames();
	
	 int saverecorduser(String firstname,
	    		String lastname,String Username,String password,Date creationdate,String createdby,int enable,String branchcode);
	    
}
