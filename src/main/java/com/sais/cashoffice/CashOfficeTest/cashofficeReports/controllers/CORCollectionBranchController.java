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

import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CORCollectionBranch;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CashierAssignPaymentMode;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository.CORCollectionBranchRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/cor_collection-branch")
public class CORCollectionBranchController {
	
	@Autowired
	CORCollectionBranchRepository colBranchRepos ;
	
	//fetch the branch records
	@GetMapping()
	public List<Object> getCodes(){
		return colBranchRepos.getBranchCodes() ;  
	}
	
	@GetMapping("/{branchCode}")
	public List<CORCollectionBranch> getCash(@PathVariable("branchCode") String branchCode ){
		
		List<Object[]> result = colBranchRepos.getBranchCollection(branchCode);
		
		if(result==null) {
			return new ArrayList<CORCollectionBranch>();
		}else {
			List<CORCollectionBranch> cap = new ArrayList<CORCollectionBranch>();
			
			for(Object[] object:result) {
				CORCollectionBranch c = new CORCollectionBranch();
				c.setS_no((Integer) object[0]);
				c.setReceipt_no((Double) object[1]);
				c.setReceipt_date((Date) object[2]);
				c.setReceipt_amount((BigDecimal) object[3]);
				c.setCash_office_code((String) object[4]);
				c.setCash_office_desc((String) object[5]);
				c.setBranch_code((String) object[6]);
				c.setBranch_name((String) object[7]);
				cap.add(c);
			}
			
			return cap;
		}
		
	}
	
	// fetch cash office code according to given branch code
	@GetMapping("/cash-office-codes/{branchCode}")
	public List<Object> getCOCodes(@PathVariable("branchCode") String branchCode ){
		
		return colBranchRepos.getCashOfficeCodes(branchCode) ;  
	}
	
	@GetMapping("/cashier-codes/{branch_code}")
	public List<Object> getCCodes(@PathVariable("branch_code") String branch_code ){
		
		return colBranchRepos.getCashierCodes(branch_code);   
	}
	
	@GetMapping("/paypoints")
	public List<Object> getPaypoints(){ 
		
		return colBranchRepos.getPaypointIDs() ;  
	}

}

