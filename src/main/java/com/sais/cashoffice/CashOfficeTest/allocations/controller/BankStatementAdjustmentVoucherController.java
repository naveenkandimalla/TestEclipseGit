package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Model.Bankdetails;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Model.ReallocationDetails;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Model.ReferenceNumberDetails;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Model.Unspecifieddetails;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Repository.ReferenceNumberDetailsRepository;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Service.BankdetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Service.BkStmtToRealloctionDetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Service.ReallocationDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Service.ReferenceNumberDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Service.UnspecifieddetailsServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class BankStatementAdjustmentVoucherController {
	
	@Autowired 
	private BankdetailsServiceImpl bds;
	
	@Autowired
	private UnspecifieddetailsServiceImpl uds;
	
	@Autowired
	private ReallocationDetailsServiceImpl rds;
	
	@Autowired
	private BkStmtToRealloctionDetServiceImpl brd;
	
   @Autowired
   private ReferenceNumberDetailsServiceImpl rnds;
   

	
	// fetching bank stmt details 
	@GetMapping(path="/allocations/bankstmtadjustmentvoucher/bankstmtdetails")
	public List<Bankdetails> fetchbankstmtdetails(@RequestParam("bankstmtid") double bankstmtid){
		
		return bds.getbankstmtdetails(bankstmtid);
	}
	
	
    // fetching unspecified details for respective bank stmt id
	@GetMapping(path="/allocations/bankstmtadjustmentvoucher/unspecifieddetails")
	 public List<Unspecifieddetails> fetchunspecifieddetails(@RequestParam("bankstmtid") double bankstmtid){
		 
		 return uds.getunspecifieddetails(bankstmtid);
		 
	 }
	
	
	// fetching the reallocation details 
	@GetMapping(path="/allocations/bankstmtadjustmentvoucher/reallocation")
	 public List<ReallocationDetails> fetchreallocationdetails(@RequestParam("bankstmtid") double bankstmtid){
		 
		 return rds.getreallocationdetails(bankstmtid);
		 
	 }
	
	
	// inserting a record into T_BK_STMT_TO_REALLOCATION_DET
	
	@PostMapping(path="/allocations/bankstmtadjustmentvoucher/insertreallocationtodetrecord")
	public ResponseEntity<?> insertrecordtoreallocationdet(@RequestBody ReallocationDetails[] rd,@RequestParam("createdby") String createdby){
		
		List<Double> realloc = new ArrayList<Double>();
	    Date creationdate = new Date();
	    
	    for(int i=0;i<rd.length;i++){
	    	
	    	double reallocationdetid= brd.insertnewrecrealloc(rd[i].getBkstmtreallocid(), rd[i].getAppCode(), rd[i].getAppActivityCode(), rd[i].getReferenceNo(), 
                    rd[i].getReferenceStatus(), rd[i].getToreallocateperiod(), rd[i].getPayor(),
                        rd[i].getTransactionCode(), rd[i].getAmount(),creationdate, createdby,rd[i].getToreallocpostingStatus());

               System.out.println(reallocationdetid);
               
               realloc.add(reallocationdetid);
	    	
	    }
	
	
	    return ResponseEntity.ok().body(realloc);
		
	}
	
	
	// inserting record into interface table 
	@PostMapping(path="/allocations/bankstmtadjustmentvoucher/insertinterfacetablereallocationtodetrecord")
	public ResponseEntity<?> insertrecordinterfacetable(@RequestBody ReallocationDetails[] rd,@RequestParam("createdby") String createdby,
			                                            @RequestParam("bankstmtid") double bankstmtid ){
		
		List<Integer> realloc = new ArrayList<Integer>();
		 Date creationdate = new Date();
		 
		 for(int i=0;i<rd.length;i++){
			
			 int interfacepostingid = rds.insertrecordinterfacetable(bankstmtid, rd[i].getAppCode(),
					                                                 rd[i].getTransactionCode(), createdby, 
					                                                 creationdate, createdby, 
					                                                 'P', rd[i].getBkStmtToReallDetId(),rd[i].getAmount());
			 System.out.println("bk to realloc id --->"+rd[i].getBkStmtToReallDetId());
			   realloc.add(interfacepostingid);
		 }
		
		
		
		return ResponseEntity.ok().body(realloc);
	}
	
	
	// delete record 
	
	@GetMapping(path="/allocations/bankstmtadjustmentvoucher/deleterecordtbkreallocation")
	public ResponseEntity<?> deleterecordbkstmttorealloc(@RequestParam("reallocidtodet") double reallocidtodet){
		
		System.out.println(reallocidtodet);
		
      int message =	(int) brd.deleterecordrealloc(reallocidtodet);
		
	System.out.println("after deleting----->"+message);
		
		return ResponseEntity.ok().body(message);
		
	}
	
	
	// get reference number details
	@GetMapping(path="/allocations/bankstmtadjustmentvoucher/referencedetails")
	public List<ReferenceNumberDetails> fetchrefrencedetails(@RequestParam("referencenumber") String referencenumber,@RequestParam("applicationcode") String applicationcode){
		
		 System.out.println(referencenumber);
		 System.out.println(applicationcode);
		
		
		 
		 return rnds.referencenumberdetails(applicationcode, referencenumber);
	}
	
	// update posting status of t_bank_stmt_realloc
	@GetMapping(path="/allocations/bankstmtadjustmentvoucher/updatepostingstatus")
	public ResponseEntity<?> updatepostingstatustbkstmtrealloc(@RequestParam("bkstmtreallocid") double bkstmtreallocid,
			                                                   @RequestParam("postedby") String postedby){
		
		char postingstatus = 'P';
		Date posteddate = new Date();
		
		int status = rds.updatepostingstatusbkstmtrealloc(bkstmtreallocid, postingstatus, postedby, posteddate);
		
		return  ResponseEntity.ok().body(status);
	}

	
	
}
