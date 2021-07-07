package com.sais.cashoffice.CashOfficeTest.paypointReports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.paypointReports.entities.CollectionBranch;
import com.sais.cashoffice.CashOfficeTest.paypointReports.repository.CollectionBranchRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/collection-branch")
public class CollectionBranchController {
	
	@Autowired
	CollectionBranchRepository colBranchRepos ;
	
	@GetMapping("/{branchCode}")
	public List<CollectionBranch> getCash(@PathVariable("branchCode") String branchCode ){
		
		return colBranchRepos.getBranchCollection(branchCode) ;  
	}
	
	@GetMapping()
	public List<Object> getCodes(){
		
		return colBranchRepos.getBranchCodes() ;  
	}
	
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

