package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetUnspecified;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Det_Sundry;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.TBankStmtHdrRepository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.sundryrepository;

@Service
public class Det_Sundry_Serviceimpl implements Det_Sundry_Service {

	@Autowired
	private sundryrepository tSundry;
	// Date date = new Date(0);
	
	
	
	

	
	@Override
	public List<Det_Sundry> fetchallDet_Sundry(double sr) {
		
		List<Det_Sundry> tDet_Sundry = new ArrayList<Det_Sundry>();
		List<Object[]> appi = tSundry.getallDet_Sundry(sr);
		
		
		 
		
		if(appi != null && !appi.isEmpty() ) {
			
			for(Object[] object:appi) {
				
			
				 if(object[4]==null){
					 return tDet_Sundry;
					 
				 }
			System.out.print(object[4]);
				
				Date date = new Date(((Timestamp) object[1]).getTime());
				Det_Sundry tsd =new Det_Sundry();
				tsd.setbK_TRANSACTION_TYPE((String) object[0]);
				tsd.setpERIOD((Date)date);
				tsd.setaLLOCATED_AMOUNT((BigDecimal) object[2]);
				tsd.setbK_TRANSACTION_DESC((String) object[3]);
				tsd.setBk_sundry_id((double) object[4]);
				tsd.setBk_stmt_id((double) object[5]);
				
				tDet_Sundry.add(tsd);
			}
			
			
			
		}
		return tDet_Sundry;
	}






	@Override
	public double sundrydateinsert(String createdby, double bkstmtid, String transtype, java.util.Date period,
			BigDecimal allocatedamount, java.util.Date creationdate) {
	
		return  tSundry.sundrydateinsert(createdby, bkstmtid, transtype, period, allocatedamount, creationdate);
	}






	@Override
	public double sundryidmax() {
		
		return tSundry.sundryidmax();
	}






	@Override
	public int sundrydeletearecord(double sundryid) {
		// TODO Auto-generated method stub
		return tSundry.sundrydeletearecord(sundryid);
	}

}
