package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.util.Date;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.entities.TPaymentTpol;
import com.sais.cashoffice.CashOfficeTest.entities.TPaymentTpp;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PaymentReceiptTppForm;
import com.sais.cashoffice.CashOfficeTest.transaction.repository.PaymentReceiptRepoTpp;

@Service
public class PaymentReceiptTppServiceImpl implements PaymentReceiptTppSerive{
	
	@Autowired
	private PaymentReceiptRepoTpp paymentTppRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public double insertTppDetails(double rcptallid,double activityid,Date period,
			                       int paypointid,double grossamount,double allocatedamount,
			                       String createdby) {

	
		
		double tppid= paymentTppRepo.insertTppDetails(rcptallid,activityid,period,
				                                  paypointid,grossamount,allocatedamount,
				                                  createdby);
	
		return tppid;
	}

}
