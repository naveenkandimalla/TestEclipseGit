package com.sais.cashoffice.CashOfficeTest.paypointReports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.paypointReports.entities.StatementAllocation;
import com.sais.cashoffice.CashOfficeTest.paypointReports.repository.StatementAllocationRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/paypoint-reports/statement-allocation")
public class StatementAllocationController {
	
	@Autowired
	StatementAllocationRepository saRepos ;
		
	@GetMapping("/{ppid}&{stmt_id}")
	public List<StatementAllocation> getSAs(@PathVariable("ppid") String ppid, 
			@PathVariable("stmt_id") String stmt_id){ 
		
		System.out.println(); // dbg. 
		System.out.println("::: PPID " + ppid + " Statement ID " + stmt_id) ; // dbg. 
		System.out.println(); // dbg. 
		
		return saRepos.getStatementAllocations(ppid, stmt_id) ;  
	}

}

