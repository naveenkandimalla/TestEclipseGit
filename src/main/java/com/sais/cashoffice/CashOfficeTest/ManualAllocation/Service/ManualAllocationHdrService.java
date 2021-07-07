package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationFromdet;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationHdr;

public interface ManualAllocationHdrService {
	
	public int insertintomanualallochdr(double receiptno,BigDecimal totalallocatedamount,
            BigDecimal totalunallocatedamount,BigDecimal totalpoliciesamount,
            Date creationdate,String createdby,
            Date modifieddate,String modifiedby,
            String attribute,String bankstmtflag,String postingstatus);

	
	
	public Object deletemanualallocationtodetrecord(double manualhdrid,double manualtodelid,BigDecimal totalallocatedamount,
            BigDecimal totalunallocatedamount,BigDecimal totalpoliciesamount,
            String modifiedby,Date modifieddate);
	
	
	public Object getmanualhdrid(double receipt);
	
	public Object updatetpomanualhdr(double manualhdrid,BigDecimal totalallocatedamount,
            BigDecimal totalunallocatedamount,BigDecimal totalpoliciesamount,
            String modifiedby,Date modifieddate);
	
	public List<ManualAllocationFromdet> fetchmanualhdrdetails(double receipt);
}
