package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetUnspecified;

public interface DetUnspecifiedService {
    
	List<DetUnspecified> fetchallDetUnspecified(double sr);
	double unspecifiedrecordinsert(String createdby,double bankstmtid,
			                       Date period,BigDecimal allocatedamount,
			                       Date Creationdate,String transcationtype);
	int unspecifiedrecorddeleted(double unspecifiedid);
}
