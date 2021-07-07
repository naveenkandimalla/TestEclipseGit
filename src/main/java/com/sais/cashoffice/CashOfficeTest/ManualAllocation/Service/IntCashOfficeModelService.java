package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;
import java.util.Date;

public interface IntCashOfficeModelService {
	
	public double insertrecordintotintcashoffice(double receiptnumber,
            String paymentfor,
            Date duedate,
            BigDecimal partyid,
            BigDecimal allocatedamount,
            int currency,
            char status,
            Date creationdate,
            String createdby,
            String policycode);

}
