package com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Service;

import java.util.Date;

public interface MisallocpartialhdrService {
	
	public int insertnewrecordmisallpartialhdr(double totalrevamount,double totalamount,
            String transcationtype,String postingstatus,Date creationdate,
            String createdby,Date modifieddate,String modifiedby);

	Object updatepostingstatusPremium(String postedby,Date postingdate,double hdrid);
	Object updatepostingstatuspartialmisallochdr(String postedby,Date postingdate,double hdrid);
	
	Object updatepostingstatusReverse(String postedby,Date postingdate,double hdrid);
	Object updatepolpartialmisallocationhdr(double hdrid,String transcationtype,double allocatedamount,String modifiedby,Date modifieddate);
}
