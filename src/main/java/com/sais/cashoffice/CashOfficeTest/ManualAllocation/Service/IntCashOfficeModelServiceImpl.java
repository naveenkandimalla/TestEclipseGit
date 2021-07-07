package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository.IntCashOfficeModelRepository;

@Service
public class IntCashOfficeModelServiceImpl  implements IntCashOfficeModelService{

	@Autowired
	private IntCashOfficeModelRepository icm;

	@Override
	public double insertrecordintotintcashoffice(double receiptnumber, String paymentfor, Date duedate,
			BigDecimal partyid, BigDecimal allocatedamount, int currency, char status, Date creationdate,
			String createdby, String policycode) {
	
		return icm.insertrecordintotintcashoffice( receiptnumber, paymentfor,
				                                   duedate, partyid, allocatedamount,
				                                   currency, status, creationdate,
				                                   createdby, policycode);
	}
	
	
	
	
	
	

}
