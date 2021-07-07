package com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.MisallcationToDet;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Repository.MisallcationToDetRepository;


@Service
public class MisallcationToDetServiceImpl implements MisallcationToDetService {
	
	
	
	@Autowired
	public MisallcationToDetRepository mistodet;
	
	
	
	

	@Override
	public List<MisallcationToDet> fetchallmisalltodet(double misallocatedid) {
		
		List<MisallcationToDet> MisallcationToDetmodel = new ArrayList<MisallcationToDet>();
		
		List<Object[]>  appi = mistodet.getallMisallcationToDet(misallocatedid);
		
		if (appi != null & !appi.isEmpty()) {
			
			
			for(Object[] object:appi) {
				
				
				
				MisallcationToDet mistodet = new MisallcationToDet();
				
				mistodet.setPolMisallToId((double) object[0]);
				mistodet.setMisallocationId((double) object[1]);
			    mistodet.setPolicyCode((String) object[2]);
			    mistodet.setPeriod((Date) object[3]);
			mistodet.setPolicystatus((String) object[4]);
			mistodet.setAmount((BigDecimal) object[5]);
		mistodet.setPartyid((double) object[6]);
		mistodet.setPartyname((String) object[7]);
			mistodet.setArrears((BigDecimal) object[8]);
				mistodet.setPartyid((double) object[9]);
			mistodet.setPurpose((String) object[10]);
			mistodet.setRecepitNumber((String) object[11]);
			
				
				MisallcationToDetmodel.add(mistodet);
				
				
			}
			
			
			
		}
			
		
		
		
		return MisallcationToDetmodel;
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public double misalltoderecord(double misallid,
			                       String policycode, 
			                       Date period,
			                       String policystatus,
			                       BigDecimal amount,
			                 
			                        String payourname,
			                        String postingstatus,
			                        String purpose,
			                        double partyid,
			                        double policyid,
			                        String receiptno,
			                        Date creationdate, 
			                        String createdby,
			                        Date modifieddate,     
			                        String modifiedby) {


		return mistodet.misalltoderecord(misallid,
				                         policycode,
				                         period,
				                         policystatus,
				                         amount,
				                 
				                         payourname,
				                         postingstatus, 
				                         purpose,
				                         partyid,
				                         policyid,
				                         receiptno,
				                         creationdate,
				                         createdby
				                         , modifieddate,
				                         modifiedby);
		
		
	}

	
//	@Override
//	public double misalltoderecord(double misallid, String policycode, Date period, String policystatus, BigDecimal amount,
//			BigDecimal arrears, String payourname, String postingstatus, String purpose, double partyid,
//			double policyid, String receiptno, Date creationdate, String createdby, Date modifieddate,
//			String modifiedby) {
//
//
//		return mistodet.misalltoderecord(misallid,
//				                         policycode,
//				                         period,
//				                         policystatus,
//				                         amount,
//				                         arrears,
//				                         payourname,
//				                         postingstatus, 
//				                         purpose,
//				                         partyid,
//				                         policyid,
//				                         receiptno,
//				                         creationdate,
//				                         createdby
//				                         , modifieddate,
//				                         modifiedby);
//		
//		
//	}


}
