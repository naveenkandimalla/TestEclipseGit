package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.UserGroupdetails;
import com.sais.cashoffice.CashOfficeTest.admin.repository.UserGroupdetailsRepository;

@Service
public class UserGroupdetailsServiceImpl implements UserGroupdetailsService{
	
	@Autowired
	private UserGroupdetailsRepository ugr;

	@Override
	public List<UserGroupdetails> getusergroupdetails(String username) {
		
		List<UserGroupdetails> ugp = new ArrayList<UserGroupdetails>();
		
		List<Object[]>  appi = ugr.getusergroupdetails(username);
		
		try{
		
			 if(appi !=null && !appi.isEmpty() ){
				 
				 for(Object[] obj:appi){
					 
					 
//					 private double userid;
//						private String username;
//						private String firstname;
//						private String lastname;
//						private double groupmemid;
//						private double groupid;
//						private char enable;
//						private String groupname;
//						private String groupdesc;
					 
					 UserGroupdetails u = new UserGroupdetails();
					 u.setUserid((double) obj[0]);
					 u.setUsername((String) obj[1]);
					 u.setFirstname((String) obj[2]);
					 u.setLastname((String) obj[3]);
					 u.setGroupmemid((double) obj[4]);
					 u.setGroupid((double) obj[5]);
					 u.setEnable((String) obj[6]);
					 u.setGroupname((String) obj[7]);
					 u.setGroupdesc((String) obj[8]);
					 
					 ugp.add(u);
					 
				 }
					 
				 }
			 
			      return ugp;
			 }catch(NullPointerException e){
				 
				 return null;
			 }
		
		
		
	}

}
