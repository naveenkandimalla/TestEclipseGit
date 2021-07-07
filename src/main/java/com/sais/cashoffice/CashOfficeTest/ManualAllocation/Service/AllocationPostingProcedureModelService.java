package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;
import java.util.Date;

public interface AllocationPostingProcedureModelService {
	
	public Object allocatedamountforposting(BigDecimal policyid, Date duetime,double feeid,
            double listid );

}
