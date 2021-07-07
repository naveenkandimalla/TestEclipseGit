package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.util.Date;

import javax.validation.Valid;

import com.sais.cashoffice.CashOfficeTest.entities.TPaymentTpp;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PaymentReceiptTppForm;

public interface PaymentReceiptTppSerive {
	
	public double insertTppDetails(double rcptallid,double activityid,Date period,
            int paypointid,double grossamount,double allocatedamount,String createdby);

}
