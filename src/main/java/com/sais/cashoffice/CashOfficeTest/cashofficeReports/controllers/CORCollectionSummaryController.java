package com.sais.cashoffice.CashOfficeTest.cashofficeReports.controllers;

import java.math.BigDecimal;
import java.math.BigInteger;
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
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CORCollectionSummary;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository.CORCollectionSummaryRepository;

@CrossOrigin(origins = {"http://localhost:4200", "*"} , allowedHeaders = "*")
@RestController
@RequestMapping("/api/cor_collection-summary")
public class CORCollectionSummaryController {
	
	@Autowired
	CORCollectionSummaryRepository colSummaryRepos ;
	
	@GetMapping("/{branch_code}&{fromDate}&{toDate}")
	public List<CORCollectionSummary> getCash(
			@PathVariable("branch_code") String branch_code,
			@PathVariable("fromDate") String fromDate,
			@PathVariable("toDate") String toDate){
		System.out.println(fromDate);
		System.out.println(toDate);
		
		List<Object[]> result = colSummaryRepos.getSummaryCollection(branch_code, fromDate, toDate);
		List<CORCollectionSummary> ccd = new ArrayList<CORCollectionSummary>();
		for(Object[] object:result) {
			
			CORCollectionSummary cd = new CORCollectionSummary();
			cd.setId((Integer) object[0]);
			cd.setBranch_code((String) object[1]);
			cd.setBranch_name((String) object[2]);
			cd.setReceipt_count((BigInteger) object[3]);
			cd.setPay_method_id((double) object[4]);
			cd.setPay_method_code((String) object[5]);
			cd.setPay_method_desc((String) object[6]);
			cd.setApp_id((double) object[7]);
			cd.setApp_code((String) object[8]);
			cd.setApp_desc((String) object[9]);
			cd.setAllocated_amount((BigDecimal) object[10]);
			cd.setReceipt_date((Date) object[11]);
			ccd.add(cd);
		}
		
		return ccd ;  
	}
	
	@GetMapping()
	public List<Object> getCodes(){
		
		return colSummaryRepos.getBranchCodes() ;  
	}

}

