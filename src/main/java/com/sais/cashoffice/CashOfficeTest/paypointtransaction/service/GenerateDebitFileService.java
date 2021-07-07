package com.sais.cashoffice.CashOfficeTest.paypointtransaction.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.GenDebitFileForm;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.GenerateDebitFile;

public interface GenerateDebitFileService {

	ResponseEntity<?> generateManualDebitFile(GenDebitFileForm form,String user);
	
	public List<GenerateDebitFile> getpaypointtransdebitfilerecords(BigDecimal paypointid,Date paypointduedate,double pphdrid);

}
