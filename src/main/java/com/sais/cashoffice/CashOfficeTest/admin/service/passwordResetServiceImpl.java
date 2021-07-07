package com.sais.cashoffice.CashOfficeTest.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;
import com.sais.cashoffice.CashOfficeTest.admin.repository.PasswordResetRepository;


@Service
public class passwordResetServiceImpl implements passwordResetService {
	
	@Autowired
	private PasswordResetRepository pr;

	@Override
	public User getdetailsofauser(String username) {
		// TODO Auto-generated method stub
		return  pr.findByUsername(username);
	}

	@Override
	public Object updatepassword(String username, String password, double userid) {
		
		return pr.updatepassword(username, password, userid);
	}


		
	


	
	

}
