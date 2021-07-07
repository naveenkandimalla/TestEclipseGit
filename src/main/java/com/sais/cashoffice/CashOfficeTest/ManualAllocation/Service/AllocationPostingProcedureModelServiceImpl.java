package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository.AllocationPostingProcedureModelRepository;

@Service
public class AllocationPostingProcedureModelServiceImpl implements AllocationPostingProcedureModelService {

	@Autowired
	private AllocationPostingProcedureModelRepository appr;
	
	
	@Override
	public Object allocatedamountforposting(BigDecimal policyid, Date duetime, double feeid, double listid) {
		
		return appr.allocatedamountforposting(policyid, duetime, feeid, listid);
	}

}
