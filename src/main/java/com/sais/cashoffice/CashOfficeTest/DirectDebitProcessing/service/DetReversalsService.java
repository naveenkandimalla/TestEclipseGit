package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetReversals;

public interface DetReversalsService {
    
	List<DetReversals> fetchDetReversals(double sr);
	
	   int reversalrecordinsert(String createdby,double stmtid,String transcationtype,
               Date period,String policycode,String payor,
               String policystatus,BigDecimal exceptedamount,
               BigDecimal allocatedamount,Date creationdate);
	

	
	int deletereversalrecord(double reversalid);
}
