package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Model.BankStmtPosting;
import com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Model.BankStmtPostingInterfaceModel;
import com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Service.BankStmtPostingInterfaceServiceImpl;
import com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Service.BankStmtPostingServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class BankStatementRecordPostingController {
	
	@Autowired
	private BankStmtPostingServiceImpl bps;
	
	@Autowired
	private BankStmtPostingInterfaceServiceImpl bpsi;
	
	@GetMapping(path="/allocations/bankstmtposting")
	public List<BankStmtPosting> fetchbankpostingdetails(@RequestParam("bankstmtid") double bankstmtid ){
		
		
		return bps.getbankstmtpostdetails(bankstmtid);
		
		
	}
	
	
	@PostMapping(path="/allocations/bankstmtposting/postingrecord")
	public ResponseEntity<?> insertrecordinterfacetable(@RequestBody BankStmtPostingInterfaceModel bi,@RequestParam("username") String username){
		
		System.out.println(username);
		
		double cashieruserid = bpsi.fetchcashierid(username);
		
		Date creationdate = new Date();
		
		String message = (String) bpsi.insertrecorbkstmtpostinginferace(bi.getBankstmtid(), bi.getTranscationcode(), cashieruserid, creationdate, bi.getCreatedby(), bi.getPostingstatus());
		System.out.println(message);
		
		return ResponseEntity.ok().body(1);
		
	}

}
