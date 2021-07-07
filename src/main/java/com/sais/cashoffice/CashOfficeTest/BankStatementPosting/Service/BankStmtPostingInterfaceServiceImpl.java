package com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Repository.BankStmtPostingInterfaceRepository;



@Service
public class BankStmtPostingInterfaceServiceImpl implements BankStmtPostingInterfaceService {
	
	@Autowired
	private  BankStmtPostingInterfaceRepository bpir;

	@Override
	public Object insertrecorbkstmtpostinginferace(double BankStmtId, String transcationcode, double Cashierid,
			Date creationdate, String createdby, char postingstatus) {
		
		return bpir.insertrecorbkstmtpostinginferace(BankStmtId, transcationcode,
				                                      Cashierid, creationdate, 
				                                      createdby, postingstatus);
	}

	@Override
	public double fetchcashierid(String loginname) {
		
		return bpir.fetchcashierid(loginname);
	}

}
