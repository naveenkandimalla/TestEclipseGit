package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.List;

import com.sais.cashoffice.CashOfficeTest.admin.model.UserGroupdetails;

public interface UserGroupdetailsService {

	 List<UserGroupdetails> getusergroupdetails(String username);
}
