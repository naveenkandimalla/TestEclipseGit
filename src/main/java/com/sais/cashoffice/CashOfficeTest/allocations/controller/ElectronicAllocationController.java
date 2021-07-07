package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.BankstmtDetails;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.CrAllocationDetails;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.EsoAllocationModel;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.PayPointCrFileFormates;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.ReceiptDetails;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Service.BankstmtDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Service.CrAllocationDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Service.EsoAllocationServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Service.PayPointCrFileFormatesServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Service.ReceiptDetailsServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class ElectronicAllocationController {
	
	
	@Autowired
	private PayPointCrFileFormatesServiceImpl pp;
	
	@Autowired
	private CrAllocationDetailsServiceImpl crd;
	
	
	@Autowired
	private ReceiptDetailsServiceImpl rds;
	
	
	@Autowired 
	private BankstmtDetailsServiceImpl bds;
	
	
	@Autowired
	private EsoAllocationServiceImpl eas;
	
	// used for fetching paypoint details
	 @GetMapping(path="/allocations/electronicallocations/paypoint")
	 public List<PayPointCrFileFormates> getpaypointdeatailscrf(){ 
		 
		 return pp.getpaypointdetails();
		 
	 }
	 
	 //by using this paypoint details if we  any  creditfile we will access it 
	 @GetMapping(path="/allocations/electronicallocations/creditfiles")
	 public List<CrAllocationDetails> getcerditfiledetails(@RequestParam BigDecimal paypointid){ 	 
		 return  crd.getcreditallocdetails(paypointid);
	 }
	
	//by using this paypoint details if we  any  receipt  we will access it  
	 @GetMapping(path="/allocations/electronicallocations/recepitdetails")
	 public List<ReceiptDetails> getrecepitdetails(@RequestParam BigDecimal paypointid){
		 return  rds.getreceiptdetails(paypointid);
	 }
	 
	 
	 
	 @GetMapping(path="/allocations/electronicallocations/bankstmtdetails")
	 public List<BankstmtDetails> getbankstmtdetails(@RequestParam BigDecimal paypointid){
		 
		 return bds.getbankstmtdetails(paypointid);
		 
	 }
	 
	 @PostMapping(value = "/allocations/electronicallocations/allocated",produces="application/json")
	 public ResponseEntity<?> esoallocation(@RequestBody EsoAllocationModel em,@RequestParam("updatedby") int userid){
		
		 java.sql.Date dt = null;
		
		Date initialdate = em.getPeriod();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(initialdate);
		//System.out.println(strDate);
		 
		Date converteddate = dt.valueOf(strDate);
		//System.out.println(converteddate);
		
		em.setPeriod(converteddate);
		 
		return eas.Getesoallocation(em, userid);
		 
	 }
     
}
