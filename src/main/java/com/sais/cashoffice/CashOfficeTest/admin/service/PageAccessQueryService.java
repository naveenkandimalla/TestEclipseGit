package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.List;

import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessQueryModel;

public interface PageAccessQueryService {
	
	public List<PageAccessQueryModel> fetchrolebypageaccessid(double pageaccessid);

}
