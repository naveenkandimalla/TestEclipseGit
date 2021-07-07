package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;
import com.sais.cashoffice.CashOfficeTest.admin.repository.LoginAccessRepository;


@Service
public class LoginAccessServiceImpl implements LoginAccessService {
	
	@Autowired
	private LoginAccessRepository lar;

	@Override	
		public List<User> userAuthenticate(String uName, String Pwd){	
		
			List<User> loginauth = new ArrayList<>();
			
		     List<Object[]> appList = lar.userAuthenticate(uName, Pwd);
		     if (appList != null && !appList.isEmpty()) {
				for (Object[] object : appList) {
					User appForm = new User();
					//System.out.println("UnAllocated Amount	:", appForm.setrcptNo((double) object[0]));
					appForm.setUserId((double) object[0]);
					appForm.setUsername((String) object[1]);	
					appForm.setBranchCode((String) object[2].toString());
					appForm.setFirstName((String) object[3].toString());
					appForm.setLastName((String) object[4].toString());
					appForm.setAttribute1((String) object[5].toString());
					loginauth.add(appForm);	
					System.out.println("User Id:"+ object[0]);
					System.out.println("User Branch Code:"+ object[2].toString());
					System.out.println("User Name:"+ object[3].toString()+" "+object[4].toString());
				}	
			}
		    //System.out.println("User Name:"+ uName);
		    return loginauth;
		}
		
		
		
	

}
