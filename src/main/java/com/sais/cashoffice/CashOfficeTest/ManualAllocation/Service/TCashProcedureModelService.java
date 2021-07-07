package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;

public interface TCashProcedureModelService {
	
	public double insertrecordinotcash(
			String policycode,
			 BigDecimal feeamount,
			 double receiptno,
			 String loginidname,
			 BigDecimal payamount,
			 String purposeid,
			 BigDecimal partyid,
			 String insertedby,
			 String updatedby,
			 BigDecimal paybalance
			
			);

}
