package com.sais.cashoffice.CashOfficeTest.paypointcollectionhistory.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.paypointcollectionhistory.model.ReceiptDetailsModel;

public interface ReceiptDetailsModelService {
	
	List<ReceiptDetailsModel> getReceiptDetails(BigDecimal paypointid,Date period);

}
