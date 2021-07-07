package com.sais.cashoffice.CashOfficeTest.paypointcollectionhistory.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.paypointcollectionhistory.model.ReceiptDetailsModel;
import com.sais.cashoffice.CashOfficeTest.paypointcollectionhistory.repository.ReceiptDetailsRepository;

@Service
public class ReceiptDetailsModelServiceimpl implements ReceiptDetailsModelService {
	
	@Autowired
	private ReceiptDetailsRepository rdr;

	@Override
	public List<ReceiptDetailsModel> getReceiptDetails(BigDecimal paypointid, Date period) {
		
		List<ReceiptDetailsModel> ReceiptDetails1 = new ArrayList<ReceiptDetailsModel>();
		
		System.out.println("calling repository rrocedure ");
	
		List<Object[]> rd = rdr.getReceiptdetails(paypointid, period);
		
		
      if (rd != null) {
			
			
			for(Object[] object:rd) {
				
				ReceiptDetailsModel rcd = new ReceiptDetailsModel();
				
				System.out.println("coming from procedure ppe recerpit----->"+ object[0]);
				
				rcd.setReceiptno((double) object[0]);
				rcd.setReceiptamount((BigDecimal) object[1]);
				rcd.setRecepitdate((Date) object[2]);
				
				ReceiptDetails1.add(rcd);
				
			}
      }
		return ReceiptDetails1;
	}

}
