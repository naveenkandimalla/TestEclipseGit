package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.entities.TDepositSlip1;
import com.sais.cashoffice.CashOfficeTest.entities.TDepositedDenomination;
import com.sais.cashoffice.CashOfficeTest.transaction.model.DenominationForm;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PrintBankForm;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PrintBankReceiptForm;

public interface PrintBankService {
	
	public List<PrintBankForm> getCashOffDet(String userID);	
	public List<DenominationForm> getDenominationDetails();	
	public List<PrintBankReceiptForm> getReceiptDetails(LocalDate date);	
	public double getUserDetails(String userID,DenominationForm form);	
	public TDepositedDenomination saveReceipt(String demo,BigDecimal amount);
}
