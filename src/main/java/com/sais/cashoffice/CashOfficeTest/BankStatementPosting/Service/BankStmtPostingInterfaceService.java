package com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Service;

import java.util.Date;

public interface BankStmtPostingInterfaceService  {
	
	public Object insertrecorbkstmtpostinginferace(double BankStmtId, 
            String transcationcode,
            double Cashierid,
            Date creationdate,
            String createdby,
            char postingstatus);
	
	public double fetchcashierid(String loginname);

}
