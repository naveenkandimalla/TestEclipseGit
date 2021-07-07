package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetExclusions;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.DetExclusionsRepository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.PolicyExclusionRepository;

@Service
public class DetExclusionsServiceImpl implements DetExclusionsService {
	
	@Autowired
	private DetExclusionsRepository tbser;
	
	@Autowired
	private PolicyExclusionRepository pe;
	
	Date date = new Date();

	@Override
	public List<DetExclusions> getdetailsexclusions(double sr) {
		
		List<DetExclusions> bsd = new ArrayList();
		List<Object[]> bkdet = tbser.getallDetailsfromTBkStmtDetExclusion(sr);
		
		System.out.println("size----->"+bkdet.size());

		if (bkdet != null && !bkdet.isEmpty() ) {
		    for(Object[] object:bkdet) {
		    	
		    	if(object[6]==null){
		    		return bsd;
		    	}
			    
		    	DetExclusions tbk = new DetExclusions();
			    tbk.setpERIOD((Date) object[0]);
			    tbk.setpOLICY_CODE((String) object[1] );
			    tbk.setpOLICY_STATUS_ID((int) object[2]);
			    tbk.setpAYOR((String) object[3] );
			    tbk.seteXPECTED_PREMIUM((BigDecimal) object[4]);
		        tbk.setaLLOCATED_AMOUNT((BigDecimal) object[5]);
		        tbk.setPolicyexculsionid((double) object[6]);
		        
		         bsd.add(tbk);
			  
		}
			
	}
	
		return bsd;
		
		
	}

	@Override
	public int deleterecordtbkdetexclusion(double bkdetstmtexclusionid) {
  
		return pe.deleterecordtbkdetexclusion(bkdetstmtexclusionid);
	
	}
	
	

}
