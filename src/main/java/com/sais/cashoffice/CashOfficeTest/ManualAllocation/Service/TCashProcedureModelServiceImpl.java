package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository.TCashProcedureModelRepository;

@Service
public class TCashProcedureModelServiceImpl implements TCashProcedureModelService {

	@Autowired
	private TCashProcedureModelRepository tcpr;
	
	@Override
	public double insertrecordinotcash(String policycode, BigDecimal feeamount, double receiptno, String loginidname,
			BigDecimal payamount, String purposeid, BigDecimal partyid, String insertedby, String updatedby,
			BigDecimal paybalance) {
		
		return tcpr.insertrecordinotcash(policycode, feeamount, 
				                         receiptno, loginidname, payamount,
				                         purposeid, partyid, insertedby,
                                           updatedby, paybalance);
	}

}
