package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.BankDetailsModel;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.BankDetailsRepository;


@Service
public class BankDetailsServiceImpl implements BankDetailsService {

	@Autowired
	public BankDetailsRepository bdr;
	
	
	@Override
	public List<BankDetailsModel> getbankdetails() {
		
		return bdr.getbankdetails();
	}
	
	
}
