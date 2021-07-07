package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service.CreditFilesmisallocDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service.PpMisAllocDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service.RcptFromReallocDetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service.RcptReallocationHdrServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service.RcptToReallocDetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.Service.RecepitStmtDetailsServiceImp;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.CreditFilesmisallocDetails;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.PpMisAllocDetails;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.RcptFromReallocDet;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.RcptReallocationHdr;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.RcptToReallocDet;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.ReceiptDetailsModel;
import com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model.RecepitStmtDetails;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class PayPointMisallocationController {
	
	@Autowired
	private RecepitStmtDetailsServiceImp rsd;
	
	@Autowired
	private CreditFilesmisallocDetailsServiceImpl cds;
	
	@Autowired
	private RcptReallocationHdrServiceImpl rrh;
	
	@Autowired
	private RcptFromReallocDetServiceImpl rrd;
	
	@Autowired
	private RcptToReallocDetServiceImpl  rtr;
	
	@Autowired
	private PpMisAllocDetailsServiceImpl ppm;
	
	
	
	 // fetching details from T_RCPT_REALLOCATION,T_RCPT_FROM_REALLOCATION_DET,T_RCPT_TO_REALLOCATION_DET
	 
	  @GetMapping(path="/allocations/paypointmisallocations/reallocationdetails")
	  public  List<PpMisAllocDetails> getalltreceiptreallocationdetails(@RequestParam("reallochdrid") double reallochdrid ){
		
		  return ppm.getppmisallocationdetails(reallochdrid); 
	  }
	  
	
	// used to fetch the receipt details
	@GetMapping(path="/allocations/paypointmisallocations/receipt")
	public List<ReceiptDetailsModel> fetchreceiptorbankstmtdetails(@RequestParam double receiptnum){
		return rsd.getallreceiptdetails(receiptnum);
	}
	
	// used to fetch  bank statement details 
		@GetMapping(path="/allocations/paypointmisallocations/bkstmtdetails")
		public List<RecepitStmtDetails> fetchbankstmtdetails(@RequestParam double receiptnum){
			System.out.println(receiptnum);
			return rsd.getallstmtdetailsBankstmt(receiptnum);
		}
		
	
	// credit all the files  details from T_PAYPOINT_CR_HDR,T_PAYPOINT_CR_LINES 
	@GetMapping(path="/allocations/paypointmisallocations/creditfiledetails")
	public List<CreditFilesmisallocDetails> fetchcreditfilestopaypoint(){
		return cds.getallcreditfiledetails();
		
	}
	
	
	// saving the new record into T_RCPT_REALLOCATION
	@PostMapping(path="/allocations/paypointmisallocations/inserttoreceiptrealloc")
	public ResponseEntity<?> insertrecordtotrcptrealloc(@RequestBody RcptReallocationHdr rrhd,@RequestParam("createdby") String createdby){
		Date reallocdate = new Date();
		rrhd.setPostingStatus("P");
		rrhd.setPostedBy(createdby);
		Date posteddate = new Date();
		System.out.println(rrhd.getRcptAllocAmt());
		Date creationdate = new Date();
		rrhd.setCreatedBy(createdby);
		rrhd.setModifiedBy(createdby);
		
		double reallochdrid = rrh.insertrecordtoreallocationhdr(rrhd.getReceiptNo(), reallocdate,
				                                                 rrhd.getPostingStatus(), rrhd.getPostedBy(),
				                                                 posteddate, rrhd.getRcptAllocAmt() ,
				                                                 creationdate, rrhd.getCreatedBy(),
				                                                 creationdate, rrhd.getModifiedBy());
		
		return ResponseEntity.ok().body(reallochdrid);
		
	}
	
	
	// update the existing record from T_RCPT_REALLOCATION 
	@PutMapping(path="/allocations/paypointmisallocations/updatereceiptrealloc")
	public ResponseEntity<?> updaterecordtotrcptrealloc(@RequestBody RcptReallocationHdr rrhd,@RequestParam("reallochdrid") double reallochdrid,@RequestParam("modifiedby") String modifiedby){
	
		rrhd.setModifiedBy(modifiedby);
		Date modifiedtime = new Date();
		double reallochdridre = rrh.updatetreallochdr( rrhd.getReceiptNo(), rrhd.getRcptAllocAmt(),rrhd.getModifiedBy() , modifiedtime, reallochdrid);
		
		return ResponseEntity.ok().body(reallochdridre);
		
	}
	
	
	// insert new record into T_RCPT_FROM_REALLOCATION_DET 
    @PostMapping(path="/allocations/paypointmisallocations/inserttoreceiptreallofromdet")
    public ResponseEntity<?> inserttofromdetreallocation(@RequestBody RcptFromReallocDet rrf,@RequestParam double reallochdrid,@RequestParam("createdby") String createdby){
	  Date creationdate = new Date();
	  Date modifieddate = new Date();
	  rrf.setPostingStatus("U");
	  
	  double reallocfromddet = rrd.insertrecordrcptfromrealloc(reallochdrid, rrf.getApp_id(),rrf.getAppActivityId(), rrf.getReferenceNo(),
			                                                   rrf.getPeriod(), creationdate,
			                                                   createdby, null, 
			                                                      null,rrf.getPostingStatus());
	 return ResponseEntity.ok().body(reallocfromddet);
	 
  }
 
   // update existing record from T_RCPT_FROM_REALLOCATION_DET
   @PutMapping(path="/allocations/paypointmisallocations/updatetoreceiptreallofromdet")
   public ResponseEntity<?> updatefromdetreallocation(@RequestBody RcptFromReallocDet rrf,@RequestParam("reallocfromid") double reallocfromid,@RequestParam("modifiedby") String modifiedby){
	 Date modified = new Date();
	 rrf.setModifiedBy(modifiedby);
	 double reallofromid = rrd.updaterecordrcptfromrealloc(rrf.getReferenceNo(),rrf.getPeriod() ,rrf.getModifiedBy() ,modified,reallocfromid);
	 return ResponseEntity.ok().body(reallofromid); 
   }
	
	 
  // insert new record into T_RCPT_TO_REALLOCATION_DET table
   @PostMapping(path="/allocations/paypointmisallocations/inserttoreceiptreallotodet")
   public ResponseEntity<?> inserttotodetreallocation(@RequestBody RcptToReallocDet rrt,@RequestParam double reallochdrid,@RequestParam("createdby") String createdby){
	 Date creationdate = new Date();
	 Date modifieddate = new Date();
	 
	 rrt.setPostingStatus("U");
	 double realloctoid = rtr.insertrecordrcpttoreallocdet(reallochdrid, rrt.getApp_id(), rrt.getAppActivityId(),
	                                                       rrt.getReferenceNo(), rrt.getPeriod(), rrt.getCrFileName(),
			                                               rrt.getTotCrAmt(), rrt.getCrHdrId(), 
			                                               creationdate,createdby, 
		                                                   null, null,rrt.getPostingStatus());
	 return ResponseEntity.ok().body(realloctoid);
   }
 
 
   // update  existing record from T_RCPT_TO_REALLOCATION_DET 
   @PutMapping(path="/allocations/paypointmisallocations/updatetoreceiptreallotodet")
   public ResponseEntity<?> updatetodetreallocation(@RequestBody RcptToReallocDet rrt,@RequestParam("realloctoid") double realloctoid,@RequestParam("modifiedby") String modifiedby){
	 Date modifieddate = new Date();
	 
	 double Toreallocid = rtr.updaterecordrcpttoreallocdet( rrt.getReferenceNo(),  rrt.getPeriod(), 
			                                        rrt.getCrFileName(),  rrt.getTotCrAmt(),rrt.getCrHdrId() ,
			                                        modifiedby ,modifieddate ,realloctoid );
	 return ResponseEntity.ok().body(Toreallocid);
 }

 
}
