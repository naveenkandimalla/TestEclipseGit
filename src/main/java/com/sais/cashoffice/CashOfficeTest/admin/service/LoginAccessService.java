package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.List;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

public interface LoginAccessService {
	
	public List<User> userAuthenticate(String uName, String Pwd);

}
