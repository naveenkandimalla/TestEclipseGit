package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.entities.TCashOffActivity1;
import com.sais.cashoffice.CashOfficeTest.entities.TPaymentTpol;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PaymentReceiptTpol;
import com.sais.cashoffice.CashOfficeTest.transaction.repository.PaymentReceiptRepoTpol;

@Service
public class PaymentReceiptTpolServiceImpl implements PaymentReceiptTpolService {

	@Autowired
	private PaymentReceiptRepoTpol paymentTpolRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public double insertTpolDetails(double rcptallid, double activityid, Date period, String policycode,
			String policystatus, String payour, BigDecimal arrearamount, BigDecimal exceptedamount,
			BigDecimal allocatedamount, String createdby, LocalDate createdDate) {

		double recpttpolid = paymentTpolRepo.insertTpolDetails(rcptallid, activityid, period, policycode, policystatus,
				payour, arrearamount, exceptedamount, allocatedamount, createdby,createdDate);

		return recpttpolid;
	}

}
