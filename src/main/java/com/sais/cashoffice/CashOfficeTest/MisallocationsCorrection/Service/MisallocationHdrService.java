package com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public interface MisallocationHdrService {
	
	
	public int misallochdrnewrecord(BigDecimal totalreversalamount,BigDecimal totalamount,String postingstatus,Date creationdate,String createdby,Date modificationdate,String modifiedby);
	
    public double misallochdrupdaterecord(double misallocahdrid
          ,BigDecimal totalreversalamount,
          BigDecimal totalamount,
          Date modificationdate,
          String modifiedby);

    public Object misallocationpostingstatus(double misallocationhdrid,String postedby,Date postingDate);	
	
    
    
}
