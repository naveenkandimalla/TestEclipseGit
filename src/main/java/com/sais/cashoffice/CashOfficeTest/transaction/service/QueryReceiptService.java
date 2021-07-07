package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.util.List;

import com.sais.cashoffice.CashOfficeTest.transaction.model.QueryReceiptForm;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ReceiptAllocationDetailsVo;

public interface QueryReceiptService {
	
	public List<QueryReceiptForm> getReceipt(String userName);
	
	public List<QueryReceiptForm> getCashierDetails();
	
	//public List<QueryReceiptForm> getRcptDetails(String cond);
	
	public List<QueryReceiptForm> getRcptDetailsWithID(double No);
	
	public List<QueryReceiptForm> getRcptDtlsWithID(double No);
	
	public List<ReceiptAllocationDetailsVo> fetchReceiptAllocationDetails(double receiptNum);
	
	
}
