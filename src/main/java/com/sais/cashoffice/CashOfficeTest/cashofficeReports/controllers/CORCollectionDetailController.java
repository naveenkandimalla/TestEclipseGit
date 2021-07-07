package com.sais.cashoffice.CashOfficeTest.cashofficeReports.controllers;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CORCollectionDetail;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository.CORCollectionDetailRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/cor_collection-detail")
public class CORCollectionDetailController {
	
	@Autowired
	CORCollectionDetailRepository colDetailRepos ;
	
	
	@GetMapping("/{branch_code}&{fromDate}&{toDate}")
	public List<CORCollectionDetail> getCash(
			@PathVariable("branch_code") String branch_code,
			@PathVariable("fromDate") String fromDate,
			@PathVariable("toDate") String toDate){
		
		System.out.println(fromDate);
		System.out.println(toDate);
		
		List<Object[]> result = colDetailRepos.getDetailCollection(branch_code, fromDate, toDate);
		List<CORCollectionDetail> ccd = new ArrayList<CORCollectionDetail>();
		for(Object[] object:result) {
			
			CORCollectionDetail cd = new CORCollectionDetail();
			cd.setCash_office_id((double)object[0]);
			cd.setBranch_code((String) object[1]);
			cd.setBranch_name((String) object[2]);
			cd.setReceipt_date((Date) object[3]);
			cd.setReceipt_no((double) object[4]);
			cd.setReceipt_amount((BigDecimal) object[5]);
			cd.setPay_method_id((double) object[6]);
			cd.setPay_method_code((String) object[7]);
			cd.setPay_method_desc((String) object[8]);
			cd.setApp_id((double) object[9]);
			cd.setApp_code((String) object[10]);
			cd.setApp_desc((String) object[11]);
			cd.setAllocated_amount((BigDecimal) object[12]);
			ccd.add(cd);
		}
		
		return ccd ;  
	}
	
	@GetMapping()
	public List<Object> getCodes(){
		
		return colDetailRepos.getBranchCodes() ;  
	}

}

