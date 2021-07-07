package com.sais.cashoffice.CashOfficeTest.admin.service;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

public interface passwordResetService {
	
	public User getdetailsofauser(String username);
	public Object updatepassword(String username,String password,double userid);

}
