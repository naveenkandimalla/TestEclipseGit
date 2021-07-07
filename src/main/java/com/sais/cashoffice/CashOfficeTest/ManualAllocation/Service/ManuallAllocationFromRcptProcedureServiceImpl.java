package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManuallAllocationFromRcptProcedure;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository.ManuallAllocationFromRcptProcedureRepository;

@Service
public class ManuallAllocationFromRcptProcedureServiceImpl implements ManuallAllocationFromRcptProcedureService {

	@Autowired
	private ManuallAllocationFromRcptProcedureRepository mar;
	
	
	@Override
	public List<ManuallAllocationFromRcptProcedure> getmanualallocationfrmdet(String bankstmtflag, double receiptnum) {
	
		List<ManuallAllocationFromRcptProcedure> manualalloc = new ArrayList<ManuallAllocationFromRcptProcedure>();
		try{	
		
 
		List<Object[]> appi = mar.getmanualallocationfrmdet(bankstmtflag, receiptnum);
		
		System.out.println(appi.size()+"-----size we nee to now");
		
               if (appi != null && !appi.isEmpty()) {
			
			
			     for(Object[] object:appi) {
			  
			    	 ManuallAllocationFromRcptProcedure marp = new ManuallAllocationFromRcptProcedure();
			    	 
			    	 marp.setRecepitno((double) object[0]);
			    	 marp.setPaypoint((int) object[1]);
			    	 marp.setPeriod((Date) object[2]);
			    	 marp.setAllocatedamount((BigInteger) object[3]);
			    	 marp.setGrossamount((double) object[4]);
			    	 marp.setRecepitamount((BigDecimal) object[5]);
			    	 marp.setUnallocatedamount((double) object[6]);
			    	 marp.setPostingstatus((String) object[7]);
			    	 marp.setHdrpostingstatus((String) object[8]);
			    	 
			    	 
			    	 manualalloc.add(marp);			    	 
			     }
			     
               }
		
		
		
		return manualalloc;
	   }catch(NullPointerException e){	    	 
//	    	 marp.setRecepitno(0);
//	    	 marp.setPaypoint(new BigDecimal(0.0));
//	    	 marp.setPeriod(null);
//	    	 marp.setAllocatedamount(new BigInteger("0"));
//	    	 marp.setGrossamount(new BigDecimal(0.0));
//	    	 marp.setRecepitamount(new BigDecimal(0.0));
//	    	 marp.setUnallocatedamount(new BigDecimal(0.0));
//	    	 marp.setPostingstatus(null);
//	    	 marp.setHdrpostingstatus(null);       
		return null;
	}
	
	
	}

}
