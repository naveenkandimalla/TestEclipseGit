package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetUnspecified;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Det_Sundry;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.TBankStmtHdrRepository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.UnspecifiedRepository;

@Service
public class DetUnspecifiedServiceImpl implements DetUnspecifiedService {

	@Autowired
	private UnspecifiedRepository UnspecifiedRepository;
	Date date = new Date(0);
	
	
	@Override
	public List<DetUnspecified> fetchallDetUnspecified(double sr) {
	     List<DetUnspecified> DetUnspecified = new ArrayList<DetUnspecified>();
	     List<Object[]> appi = UnspecifiedRepository.getallDetUnspecified(sr);
	     
	     
	     
	     if(appi != null ) {
				for(Object[] object:appi) {
					
					
					 if(object[0]==null){
						 return DetUnspecified;
						 
					 }
					 Date date = new Date(((Timestamp) object[2]).getTime());
					DetUnspecified tsd =new DetUnspecified();
					
					
					tsd.setbK_STMT_DET_UNSP_ID((double)object[0]);
					tsd.setbK_TRANSACTION_TYPE((String) object[1]);
					tsd.setpERIOD(date);
					tsd.setaLLOCATED_AMOUNT((BigDecimal) object[3]);
					tsd.setcREDIT_YN((char) object[4]);
					tsd.setbK_TRANSACTION_DESC((String) object[5]);
					tsd.setBk_stmt_id((double) object[6]);
					DetUnspecified.add(tsd);
				}
			}
			
	     
			return DetUnspecified;
	
	}


	





	@Override
	public int unspecifiedrecorddeleted(double unspecifiedid) {
		// TODO Auto-generated method stub
		return UnspecifiedRepository.unspecifiedrecorddeleted(unspecifiedid);
	}








	@Override
	public double unspecifiedrecordinsert(String createdby, double bankstmtid, java.util.Date period,
			BigDecimal allocatedamount, java.util.Date Creationdate, String transcationtype) {
		System.out.println("from service impl--->"+period);
		System.out.println(Creationdate);
		return UnspecifiedRepository.unspecifiedrecordinsert(createdby, bankstmtid,
				                                            period, allocatedamount, 
				                                            Creationdate, transcationtype);
	}





	


}
