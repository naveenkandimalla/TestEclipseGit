package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationFromdet;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationHdr;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository.ManualAllocationHdrRepository;

@Service
public class ManualAllocationHdrServiceImpl implements ManualAllocationHdrService {
	
	@Autowired
	private ManualAllocationHdrRepository mar;
	

	@Override
	public int insertintomanualallochdr(double receiptno, BigDecimal totalallocatedamount,
			BigDecimal totalunallocatedamount, BigDecimal totalpoliciesamount, Date creationdate, String createdby,
			Date modifieddate, String modifiedby, String attribute, String bankstmtflag,String postingstatus) {
		
		return mar.insertintomanualallochdr(receiptno, totalallocatedamount, totalunallocatedamount,
				                              totalpoliciesamount, creationdate, createdby, modifieddate,
				                              modifiedby, attribute, bankstmtflag,postingstatus);
	}


	@Override
	public Object deletemanualallocationtodetrecord(double manualhdrid, double manualtodelid,
			BigDecimal totalallocatedamount, BigDecimal totalunallocatedamount, BigDecimal totalpoliciesamount,
			String modifiedby, Date modifieddate) {
	
		return mar.deletemanualallocationtodetrecord(manualhdrid, manualtodelid, totalallocatedamount,
				                                      totalunallocatedamount, totalpoliciesamount,
				                                       modifiedby, modifieddate);
	}


	@Override
	public Object getmanualhdrid(double receipt) {
		
		return mar.getmanualhdrid(receipt);
	}


	@Override
	public Object updatetpomanualhdr(double manualhdrid, BigDecimal totalallocatedamount,
			BigDecimal totalunallocatedamount, BigDecimal totalpoliciesamount, String modifiedby, Date modifieddate) {
		
		return mar.updatetpomanualhdr(manualhdrid, totalallocatedamount, totalunallocatedamount, totalpoliciesamount, modifiedby, modifieddate);
	}


	@Override
	public List<ManualAllocationFromdet> fetchmanualhdrdetails(double receipt) {
		
		List<ManualAllocationFromdet> mhdr = new ArrayList<ManualAllocationFromdet>();
		List<Object[]> appi = mar.fetchmanualhdrdetails(receipt);
		
		
		if(appi !=null && !appi.isEmpty()){
			
			for(Object[] ob:appi){
				ManualAllocationFromdet hr = new ManualAllocationFromdet();
				hr.setAllocatedAmount((BigDecimal) ob[0]);
				hr.setUnallocatedAmount((BigDecimal) ob[1]);
				hr.setPaypointId((BigDecimal) ob[2]);
				hr.setPeriod((Date) ob[3]);
				hr.setGrossAmount((BigDecimal) ob[4]);
				hr.setReceiptAmount((BigDecimal) ob[5]);
				hr.setPostingStatus((String) ob[6]);
				
				mhdr.add(hr);
			}
		}
		
		return mhdr;
	}




}
