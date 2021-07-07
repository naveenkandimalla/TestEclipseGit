package com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service;

import java.util.List;

import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.ReceiptDetailsModel;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.RecepitStmtDetails;

public interface RecepitStmtDetailsService {
	
	List<ReceiptDetailsModel> getallreceiptdetails(double recepitno);
	
	List<RecepitStmtDetails> getallstmtdetailsBankstmt(double recepitno);

}
