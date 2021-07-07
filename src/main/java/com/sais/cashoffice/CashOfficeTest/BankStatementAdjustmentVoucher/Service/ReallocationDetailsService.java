package com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Model.ReallocationDetails;

public interface ReallocationDetailsService {

	List<ReallocationDetails> getreallocationdetails(double bankstmtid);
	int insertrecordinterfacetable(double bankstmtid,String applicationcode,String Transcationcode,String cashiername,
            Date creationdate,String createdby,char postingstatus,double bktoreallocid,BigDecimal amount);
	int updatepostingstatusbkstmtrealloc(double bkstmtreallocid,char postingstatus,String postedby,Date posteddate );
	
}
