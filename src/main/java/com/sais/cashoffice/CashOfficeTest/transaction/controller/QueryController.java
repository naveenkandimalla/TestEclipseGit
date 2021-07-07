package com.sais.cashoffice.CashOfficeTest.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.transaction.model.QueryReceiptForm;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ReceiptAllocationDetailsVo;
import com.sais.cashoffice.CashOfficeTest.transaction.service.QueryServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QueryController {

	@Autowired
	private	QueryServiceImpl queryReceiptServiceImpl;

	// used for fetching all receipt details for login cashier 
	@GetMapping(path = "/QRDetails")
	public List<QueryReceiptForm> getQuery(@RequestParam("userName") String userName) {		
		return queryReceiptServiceImpl.getReceipt(userName);
	}
	
	// used fot fecthing cashier details
	@GetMapping(path = "/QRCashiers")
	public List<QueryReceiptForm> getQRCashiers() {
		
		return queryReceiptServiceImpl.getCashierDetails();
	}
	
	// used for fetching specific receipt details by passing receipt no
	@GetMapping(path = "/QR_rcptDtlsWithID",produces="application/json")
	public List<QueryReceiptForm> getRcptAllocationDtls(@RequestParam("rcptno") double No) {
		System.out.println("Calling ALlocation Service and No:"+ No);
		return queryReceiptServiceImpl.getRcptDtlsWithID(No);
	}
	
	
	//used for fetching complete alloction details along with its activites  for receipt
	@GetMapping(path = "/ReceiptAlloDetails",produces="application/json")
	public List<ReceiptAllocationDetailsVo> getReceiptAllocationActivityDetails(@RequestParam("rcptno") double ReceiptNo) {
		
		return queryReceiptServiceImpl.fetchReceiptAllocationDetails(ReceiptNo);
	}
	
//	@GetMapping(path = "/QR_rcptList/{wcond}")
//	public List<QueryReceiptForm> getRcptDtls(@PathVariable (value = "wcond") String cond1) {
//		System.out.println("Calling Controller Service and Cond:"+ cond1);
//		return queryReceiptServiceImpl.getRcptDetails(cond1);
//	}
		
	@GetMapping(path = "/QRCashiersWithID",produces="application/json")
	public List<QueryReceiptForm> getRcptDtlsWithID(@RequestParam("rcptno") double No) {
		System.out.println("Calling QRCashiersWithID Service and No:"+ No);
		return queryReceiptServiceImpl.getRcptDetailsWithID(No);
	}
	
	
	
	
}
