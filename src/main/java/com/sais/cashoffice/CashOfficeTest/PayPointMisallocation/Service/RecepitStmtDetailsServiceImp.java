package com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Repository.RecepitStmtDetailsRepository;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.ReceiptDetailsModel;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.RecepitStmtDetails;

@Service
public class RecepitStmtDetailsServiceImp implements RecepitStmtDetailsService {
	
	@Autowired
	private RecepitStmtDetailsRepository rsdr;

	@Override
	public List<ReceiptDetailsModel> getallreceiptdetails(double recepitno) {
		
		List<ReceiptDetailsModel> RecepitStmtDetails = new ArrayList<ReceiptDetailsModel>();
		
		List<Object[]> appi = rsdr.getallreceiptdetails(recepitno);
		
		
		 if( appi != null && !appi.isEmpty() ){
			  
			  for(Object[] object:appi){
	          
				  
				  ReceiptDetailsModel rsd = new ReceiptDetailsModel();                                                                 


				  rsd.setReceiptno((double) object[0]);
				  rsd.setPostingstatus((char) object[1]);
				  rsd.setPeriod((Date) object[2]);
				  rsd.setPaypointid((BigDecimal) object[3]);
				  rsd.setPaypointname((String) object[4]);
				  rsd.setAmount((BigDecimal) object[5]);
				  
				  RecepitStmtDetails.add(rsd);
			  }
			  
		 }
			
		
		return RecepitStmtDetails;
	}

	@Override
	public List<RecepitStmtDetails> getallstmtdetailsBankstmt(double recepitno) {
		 
     List<RecepitStmtDetails> RecepitStmtDetails = new ArrayList<RecepitStmtDetails>();
		
		List<Object[]> appi = rsdr.getallstmtdetailsBankstmt(recepitno);
		
		
		 if( appi != null && !appi.isEmpty() ){
			  
			  for(Object[] object:appi){
	          
				  
				  RecepitStmtDetails rsd = new RecepitStmtDetails();                                                                 
			
				  	  
				  rsd.setRecepitno((String) object[0]);
				  rsd.setPostingstatus((char) object[1]);
				  rsd.setPeriod((Date) object[2]);
				  rsd.setPaypointid((BigDecimal) object[3]);
				  rsd.setPaypointname((String) object[4]);
				  rsd.setAmount((BigDecimal) object[5]);
				  
				  RecepitStmtDetails.add(rsd);
			  }
			  
		 }
			
		
		return RecepitStmtDetails;
		
	}

}
