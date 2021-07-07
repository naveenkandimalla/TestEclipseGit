package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.AccountsInfo;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.BankAcoountDetails;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.BankDetailsModel;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Dde_model;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetExclusions;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetReversals;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.DetUnspecified;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Det_Sundry;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.PolicyExclusionModel;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Tbank_join;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Tbankstmthdr;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.TranscationTypeBKModel;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.Vw_PayPoints;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.AccountInfoRepository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.BranchModelRepository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.PolicyExclusionRepository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.TBankStmtHdrRepository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.BankAcoountDetailsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.BankDetailsService;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.Dde_service_impl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.DetExclusionsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.DetReversalsServiceImpl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.DetUnspecifiedServiceImpl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.Det_Sundry_Serviceimpl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.TBankHrdServiceimpl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.TranscationTypeBKServiceImpl;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service.paypointserviceimpl;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.AssignDbtFileTmpt;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class DirectDebitProcessingController {

  
		@Autowired
		private TBankHrdServiceimpl tbankhrd;
		
		@Autowired
		private DetExclusionsServiceImpl tbkexculsion;
		
		@Autowired
		private DetReversalsServiceImpl tbreversal;
		
		@Autowired
		private Det_Sundry_Serviceimpl sundry;
		
		@Autowired
		private DetUnspecifiedServiceImpl unspec;
		
		@Autowired
		private paypointserviceimpl  paypoint;
		
		@Autowired
		private TBankStmtHdrRepository tr;
		
		
		@Autowired
		private Dde_service_impl ddeservice;
		
		@Autowired
		private BankDetailsService bankservice;
		
		@Autowired
		private BankAcoountDetailsServiceImpl accountservice;
		
		
		@Autowired
		private AccountInfoRepository air;
		
		@Autowired
		private BranchModelRepository bmr;
		
		@Autowired
		private PolicyExclusionRepository per;
		
		@Autowired
		private TranscationTypeBKServiceImpl ttbk;
		
		// fetching paypoint details 
		@GetMapping(path="/allocations/paypoint")
		public List<Vw_PayPoints> fetchallpaypoints(){
			return paypoint.fetchalldetailsofpaypoint();
		}
		
		//fetching bank and account details details
		@GetMapping(path="/allocations/accountinfodetails")
		public List<AccountsInfo> fetchaccountinfobyparentid(@RequestParam("parentbankid") String parentbankid){
			
			return air.findaccountdetails(parentbankid);
		}
		
		// use to fetch assign branch for user
		@GetMapping(path="/allocation/branchname/branchcode")
		public String fetchbranchname(@RequestParam("username") String username){
			String user =bmr.ftechbranchname(username);
			return user;
			
		}
		
		// fetching bank statement details
       @GetMapping(path="/allocations/stmt", produces = "application/json")
		 public List<Tbank_join> fetchallgroupusers(@RequestParam("Bankstmt") double code){ 
		  System.out.println("printing bt stmt details");
			 return tbankhrd.getdatafrommultipletables(code);
			 
		 }
		
		
		//post to t_bank_stmt_hdr to generate bank stmt id 
		@PostMapping(path="/allocations/tbankstmthdr/savehdrrecod")
	     public ResponseEntity<?> inseringdetailstostmthdr(@RequestBody Tbankstmthdr tbi) throws JsonParseException, JsonMappingException, IOException{
    	     Tbankstmthdr tb = new Tbankstmthdr();
	    	 tb.setPostingstatus("U");
	    	 
	    	 double stmthdrid = ddeservice.insertintobankstmthdr(tbi.getPaymentmode(),tbi.getBankname(),tbi.getAccountnumber() ,
	    			                                            tbi.getCreationdate(),tbi.getModifiedate(),tbi.getBankstmtnumber(),
	    			                                            tb.getPostingstatus(),tbi.getDatefrom() ,tbi.getDateto() ,
	    			                                            tbi.getCreatedby() ,tbi.getOpeningbalance(), 
	    			                                           tbi.getClosingbalance() ,tbi.getBranch() ,
	    			                                           tbi.getReversalperiod() ,tbi.getCreatedby());
	    	 
	    	 return ResponseEntity.ok().body(stmthdrid);
	     }
	     
		
		
		// updating t_bank_stmt_hdr table data
		@PostMapping(path="/allocations/tbankstmthdr/updatedhdrrecod")
		 public ResponseEntity<?> inseringdetailstostmthdr(@RequestBody Tbankstmthdr tbi,@RequestParam("bankstmtid") double bankstmtid){
			
			 Tbankstmthdr tb = new Tbankstmthdr();
	    	 tb.setPostingstatus("U");
	    	 Date modifieddate = new Date();
	    	 
	    	 double stmtid =  ddeservice.updatebankstmthdr(tbi.getPaymentmode(),tbi.getBankname(),tbi.getAccountnumber(),
	    			                                          modifieddate, tbi.getBankstmtnumber(),tb.getPostingstatus()
	    			                                         ,tbi.getDatefrom() ,tbi.getDateto() , 
	    			                                         tbi.getCreatedby(), 
	    			                                         tbi.getOpeningbalance(),  tbi.getClosingbalance() ,
	    			                                         tbi.getBranch() , tbi.getReversalperiod(), tbi.getCreatedby(),
	    			                                         bankstmtid);
	    	 return ResponseEntity.ok().body(stmtid);	 
		}
		
		 
        @GetMapping(path="/allocations/stmt/ddedetails", produces = "application/json")
		 public List<Dde_model> fetchalldde(@RequestParam("Bankstmt") double code){
			 return ddeservice.getalldee(code); 
		 }
		 
		// fetch exclusions details
        @GetMapping(path="/allocations/stmt/exclusions", produces = "application/json")
		 public List<DetExclusions> fetchstmtdetexclusions(@RequestParam("Bankstmtexclusions") double exclusions){ 
			 return tbkexculsion.getdetailsexclusions(exclusions); 
		 } 
        
	    // fetch reversal details
        @GetMapping(path="/allocations/stmt/DetReversals") 
		 public List<DetReversals> fetchstmtDetReversals(@RequestParam("BankstmtexclusionsDetReversals") double DetReversals){ 
			 return tbreversal.fetchDetReversals(DetReversals); 
		 } 
	
       // fetch sundry details
       @GetMapping(path="/allocations/stmt/sundry") 
	   public List<Det_Sundry> fetchstmtDetSundy(@RequestParam("Bankstmtexclusionssundry1") double sundry1){
		 return sundry.fetchallDet_Sundry(sundry1); 
		} 
		 
	// fetch unspecified details 
     @GetMapping(path="/allocations/stmt/unspecified") 
     public List<DetUnspecified> fetchstmtDetunspecified(@RequestParam("Bankstmtexclusionsunspecified") double unsp){
			
      return unspec.fetchallDetUnspecified(unsp);
    	 
	  } 
     
     
     
     // fetching the bank details 
     @GetMapping(path="/allocations/stmt/bankdetails") 
     public List<BankDetailsModel> fetchbankdetails(){
    	 
    	 return bankservice.getbankdetails();
     }
     
     // fetch the account details 
     @GetMapping(path="/allocations/stmt/accountdetails")
     public List<BankAcoountDetails> fetchaccountdetails(){
    	 
    	 return accountservice.getallbankaccountdetails();
     }
     
     
    // inserting the new record into T_BK_STMT_DET_DDE 
     @PostMapping(path="/allocations/dde",consumes = "application/json", produces = "application/json")
     public ResponseEntity<?>  postingddedetails(@RequestBody Tbank_join[] v ){
    	
      List<Double> ddeid  = new ArrayList<>();
      
      for(int i=0;i<v.length;i++){
    	
    	  int bankstmtid = ((int) v[i].getBank_stmt_id());
      	  Date date = new Date();
 
          double ddeidnum = tr.insertingdde(bankstmtid, v[i].getBk_transaction_type(), v[i].getPeriod(), 
      			            v[i].getPaypoint_id(), v[i].getStrike_date(), v[i].getGross_amount(),
    			            v[i].getAllocated_amount(),date,v[i].getCreatedby());
  

         ddeid.add(ddeidnum);
    	  
      }
    	 return ResponseEntity.ok().body(ddeid);
     }
     
     
     // deleteing the record of dde 
    @DeleteMapping(path="/allocations/dde/deletedde")
     public ResponseEntity<?> deleteRecordDde(@RequestParam("ddeid") double ddeid){
    	
    	 int dderecord = tr.DeleteDdeByAmount(ddeid);
    	 return ResponseEntity.ok().body(dderecord);
     }
    
     // inserting the new record into T_BK_STMT_DET_EXCLUSIONS 
     @PostMapping(path="/allocations/policyexclusion",consumes = "application/json", produces = "application/json")
     public ResponseEntity<?>  insertingpolicyexclusiondetails(@RequestBody PolicyExclusionModel[] v ){
    	 
    	 List<Double> peid  = new ArrayList<>();
    	 
    	 for(int i=0;i<v.length;i++){
    		 
    		 System.out.println(v[i].getPeriod());
    		 int bankstmtid = ((int) v[i].getBankstmtid());
    		 Date date = new Date();
    		 double policyexculsionid = per.insertrecordpe(bankstmtid, v[i].getPeriod(), v[i].getPolicycode(),
    				                          v[i].getPayour(), v[i].getPolicystatus(), v[i].getExceptedamount(),
    				                          date , v[i].getCreatedby(), v[i].getAllocatedpremium());
    		 
    		 peid.add(policyexculsionid);
    		 
    	 } 
    	 return ResponseEntity.ok().body(peid);
     }

     
     // delete policy exclusion record
     @GetMapping(path="/allocations/policyexclusiondelete")
     public ResponseEntity<?> deleterecordpolicyexclusion(@RequestParam("bkstmtpeid") double peid){
    	 
    	int success = tbkexculsion.deleterecordtbkdetexclusion(peid);
    	 return  ResponseEntity.ok().body(success);
     }
     
     
     // inserting the new record into T_BK_STMT_DET_REVERSALS 
     @PostMapping(path="/allocations/reversalposting/posting",consumes = "application/json", produces = "application/json")
     public ResponseEntity<?>  postingreversaldetails (@RequestBody DetReversals[] v ){
    	 
    	 DetReversals DRE = new DetReversals();
    	 Date date = new Date();
    	 List<Double> reversalid  = new ArrayList<>();
    	 
    	 for(int i=0;i<v.length;i++){
    		 
    		 int bankstmtid = ((int) v[i].getBk_stmt_id());
    		 double insertedrvrecord =	 tbreversal.reversalrecordinsert(v[i].getCreatedby(),bankstmtid,
                                                                    v[i].getbK_TRANSACTION_TYPE(), v[i].getpERIOD_FOR_REVERSALS(), 
                                                                    v[i].getpOLICY_CODE(), v[i].getpAYOR(),
                                                                    v[i].getPolicystatusname(), v[i].geteXPECTED_PREMIUM(),
                                                                    v[i].getaLLOCATED_AMOUNT() ,date );
              reversalid.add(insertedrvrecord); 
    	 }
 
    	 return ResponseEntity.ok().body(reversalid);
     }
     
     
     // delete reversal record
     @DeleteMapping(path="/allocations/dde/deletereversal")
     public ResponseEntity<?> deleteRecordrevrsal(@RequestParam("reversalid")   double reversalid ){

    	int reversalrecorddeleted = tbreversal.deletereversalrecord(reversalid);	
    	return ResponseEntity.ok().body(reversalrecorddeleted);
    	 
     }
    
     
     // calling transcation type description table 
     @GetMapping(path="/allocations/transcationtypesBKDesc")
     public List<TranscationTypeBKModel> grtallbktrantype(){
  
    	 return ttbk.fetchbanktranscationtypes();
     }
     
     
     // inserting the new record into T_BK_STMT_DET_SUNDRY 
     @PostMapping(path="/allocations/sundry/post",consumes = "application/json", produces = "application/json")
     public ResponseEntity<?>  postingsundrydetails (@RequestBody Det_Sundry[] v ){
         
    	 Date date = new Date();
    	 List<Double> sundryid  = new ArrayList<>();
    	 for(int i=0;i<v.length;i++){
    		 int bankstmtid = ((int) v[i].getBk_stmt_id()); 
    	 double sundryinsertvalue = sundry.sundrydateinsert(v[i].getCreatedby(), v[i].getBk_stmt_id(),
    			                                        v[i].getbK_TRANSACTION_TYPE(), v[i].getpERIOD(),
    			                                        v[i].getaLLOCATED_AMOUNT(), date);
    	 
    	 sundryid.add(sundryinsertvalue);
    	 }
    	 return ResponseEntity.ok().body(sundryid);
     }
     
     // delete a sundry record
     @DeleteMapping(path="/allocations/dde/deletesundry")
     public ResponseEntity<?> deleteRecordsundry(@RequestParam("sundryid")   double surdryid){ 
      	int sundryrecorddeleted = sundry.sundrydeletearecord(surdryid);  
      	System.out.println("record is sucessfull deleted---if result is 0 not deleted---->"+sundryrecorddeleted);		
      	return ResponseEntity.ok().body(sundryrecorddeleted); 
       }
     
     
     
   // inserting the new record into T_BK_STMT_DET_UNSPECIFIED
     @PostMapping(path="/allocations/unspecified/post",consumes = "application/json", produces = "application/json")
     public ResponseEntity<?>  postingunspecifieddetails (@RequestBody DetUnspecified[] v ){
    	 
      Date date = new Date();
      List<Double> unspecifiedid  = new ArrayList<>();
      
      for(int i=0;i<v.length;i++){
    	 
    	  double unspecifiedinsert = unspec.unspecifiedrecordinsert(v[i].getCreatedby(), v[i].getBk_stmt_id(),
    			                                                  v[i].getpERIOD(), v[i].getaLLOCATED_AMOUNT(),
    			                                                  date,v[i].getbK_TRANSACTION_TYPE());
      	
  	      unspecifiedid.add(unspecifiedinsert);  
      }   
      return ResponseEntity.ok().body(unspecifiedid);
     }
     
     //delete the unspecified record 
     @DeleteMapping(path="/allocations/dde/deleteunspecified")
     public ResponseEntity<?> deleteRecordunspecified(@RequestParam("bK_STMT_DET_UNSP_ID")   double bK_STMT_DET_UNSP_ID){
       	 
      int unspecifiedrecorddeleted = unspec.unspecifiedrecorddeleted(bK_STMT_DET_UNSP_ID);		
      return ResponseEntity.ok().body(unspecifiedrecorddeleted);
     }
      
	
}
