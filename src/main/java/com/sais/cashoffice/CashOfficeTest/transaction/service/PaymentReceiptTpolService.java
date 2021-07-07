package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.Valid;

import com.sais.cashoffice.CashOfficeTest.entities.TPaymentTpol;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PaymentReceiptTpol;

public interface PaymentReceiptTpolService {
	
	public double insertTpolDetails(double p_rcpt_all_id,double P_App_Activity_id,
            Date p_Period,String p_Policy_code,String p_Policy_Status,
            String p_Payor,BigDecimal p_Arrears_Amount,
            BigDecimal p_Expected_Amt,
            BigDecimal p_All_Amt,String createdby,LocalDate createdDate);


}
