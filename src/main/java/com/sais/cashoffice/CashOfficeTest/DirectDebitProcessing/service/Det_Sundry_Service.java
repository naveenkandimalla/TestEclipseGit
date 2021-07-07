package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Det_Sundry;

public interface Det_Sundry_Service {
   
	List<Det_Sundry> fetchallDet_Sundry(double sr);
	
	double sundrydateinsert(String createdby,double bkstmtid,String transtype,Date period,BigDecimal allocatedamount,Date creationdate);
	
	 double sundryidmax();
	 
	 int sundrydeletearecord(double sundryid);
}
