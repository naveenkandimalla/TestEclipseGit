package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.IntCashOfficeModel;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationFromdet;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationHdr;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationToDet;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationToDtlProcedure;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManuallAllocationFromRcptProcedure;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository.ManualAllocationHdrRepository;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.IntCashOfficeModelServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.ManualAllocationFromdetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.ManualAllocationHdrServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.ManualAllocationToDetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.ManualAllocationToDtlProcedureServiceImpl;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.ManuallAllocationFromRcptProcedureServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class ManualAllocationController {
	
	@Autowired
	private ManuallAllocationFromRcptProcedureServiceImpl mar;
	
	@Autowired
	private ManualAllocationToDtlProcedureServiceImpl mad;
	
	
	@Autowired
	private ManualAllocationHdrServiceImpl mah;
	
	
	@Autowired
	private ManualAllocationFromdetServiceImpl mrf;
	
	
	@Autowired
	private ManualAllocationToDetServiceImpl matodet;
	
	@Autowired
	private IntCashOfficeModelServiceImpl ico;
	
	@Autowired
	private ManualAllocationHdrRepository marr;
	
	
	// fetching the receipt/bk statment details  from t_receipt
	@GetMapping(path="/allocations/manualallocation/receiptdetailsflag")
	public List<ManuallAllocationFromRcptProcedure> fetchreceiptdetailsfromdtl(@RequestParam("bankstmtflag") String bankstmtflag,
			                                                            @RequestParam("receiptnum") double receiptnum){
		return mar.getmanualallocationfrmdet(bankstmtflag, receiptnum);
	}
	
	// fetching the receipt/bk statment details from t_pol_manual_hdr
	@GetMapping(path="/allocations/manualallocation/receiptdetailsflagtodtl")
	public List<ManualAllocationToDtlProcedure>  fetchreceiptdetailstodl(@RequestParam("bankstmtflag") String bankstmtflag,
			                                                            @RequestParam("receiptnum") double receiptnum){ 
		return mad.getmanualallocattodtl(bankstmtflag, receiptnum);
	}
	
	// initially checking the wheather search is alreaded there in t_pol_maual_hdr or not 
	@GetMapping(path="/allocations/manualallocation/tpolmanualhdrid")
	public Object getmanualallocationhdriddetails(@RequestParam("receipt") double receipt){
		return mah.getmanualhdrid(receipt);
	}

	// manual hdr result
	@GetMapping(path="/allocations/manualallocation/manualhdrdetails")
	public  List<ManualAllocationFromdet> getmanualallocationhdrdetails(@RequestParam("manualhdrid") double manualhdrid){	
		return mah.fetchmanualhdrdetails(manualhdrid);	
	}
	
	// saving the record into t_po_manual table
	@PostMapping(path="/allocations/manualallocation/inserttpolmanualhdr")
	public ResponseEntity<?> insertrecordtpomanualhdr(@RequestBody ManualAllocationHdr ma){
		
	 Date creationdate = new Date();
	 Date modifieddate = new Date();
	 ma.setPostingStatus("U");
		
		
	double manualhadrid = mah.insertintomanualallochdr(ma.getReceiptNo(), ma.getTotalAllocatedAmt(),
			                                           ma.getTotalUnallocatedAmt(), ma.getTotalPoliciesAmount(), 
			                                           creationdate, ma.getCreatedBy(), null,
			                                           null, ma.getAttribute1(), ma.getBankStmtFlag(),ma.getPostingStatus());
	
	return ResponseEntity.ok().body(manualhadrid);
	
	}
	
    // update tpolmanual hdr table 
	@GetMapping(path="/allocations/manualallocation/updatetpolmanualallochdr")
	public Object updatetpomanualhdr(@RequestParam("manualhdrid") double manualhdrid
                                    ,@RequestParam("totalallocatedamount") BigDecimal totalallocatedamount,
                                     @RequestParam("totalunallocatedamount") BigDecimal totalunallocatedamount,
                                     @RequestParam("totalpoliciesamount") BigDecimal totalpoliciesamount,
                                      @RequestParam("modifiedby") String modifiedby){
		
		Date modifieddate = new Date();
		String message = (String) mah.updatetpomanualhdr(manualhdrid, totalallocatedamount, totalunallocatedamount, totalpoliciesamount, modifiedby, modifieddate);
		return null;
		
	}
	
	// insert the new record into t_pol_manual_frm_det
	@PostMapping(path="/allocations/manualallocation/inserttpolmanualfromdet")
	public ResponseEntity<?> insertrecordtpomanualfromdet(@RequestBody ManualAllocationFromdet maf,@RequestParam double manualhdrid,@RequestParam("createdby") String createdby ){

     Date creationdate = new Date();
     maf.setCreatedBy(createdby);
     maf.setPostingStatus("U");
	
    double manualfromid = mrf.insertintomanalallocfromdet(manualhdrid, maf.getPaypointId(), maf.getPeriod(),
				                                               maf.getAllocatedAmount(), maf.getUnallocatedAmount(), maf.getGrossAmount(),
				                                               maf.getReceiptAmount(), maf.getPostingStatus(), creationdate,
				                                               maf.getCreatedBy(), maf.getModifiedDatetime(), maf.getModifiedBy());
		
	return ResponseEntity.ok().body(manualfromid);
	}
	
	
	// insert new record into tpolmanualtodet
	@PostMapping(path="/allocations/manualallocation/inserttpolmanualtodet")
	public ResponseEntity<?> insertrecordtpomanualtodet(@RequestBody ManualAllocationToDet[] mtd,@RequestParam("manualhdrid") double manualhdrid,@RequestParam("stmtflag") String stmtflag,@RequestParam("createdby") String createdby ){
		
		System.out.println(createdby);
		
		List<Double> maualtodetidarray = new ArrayList<Double>();
		for(int i=0;i<mtd.length;i++){
			Date creationdate = new Date();
			mtd[i].setCreatedBy(createdby);
			mtd[i].setPostingStatus("U");

			double manualtodet = matodet.insertintomanualalloctodet(manualhdrid, mtd[i].getPolicyCode(), mtd[i].getPolicyId(), 
                    mtd[i].getPeriod(), mtd[i].getPartyId(), mtd[i].getPayorName(), mtd[i].getPurposeId(),
                    mtd[i].getPurposeName(), mtd[i].getExpectedAmount(), mtd[i].getAllocatedAmount(),
                     mtd[i].getPostingStatus(), creationdate, mtd[i].getCreatedBy(),
                   mtd[i].getModifiedDatetime(), mtd[i].getModifiedBy());
			
			maualtodetidarray.add(manualtodet);
		}

		return ResponseEntity.ok().body(maualtodetidarray);
	}
	
	
	// deleting the record from T_Pol_maual_todtl and also updating the allocated and unallocated amount in the t_pol_maual_hdr
	 @GetMapping(path="/allocations/manualallocation/deletetodtl")
	 public  ResponseEntity<?> deleterecordmanualtodet(@RequestParam("manualhdrid") double manualhdrid,
			                                           @RequestParam("manualToDtlId") double manualToDtlId
			                                           ,@RequestParam("totalallocatedamount") BigDecimal totalallocatedamount,
			                                           @RequestParam("totalunallocatedamount") BigDecimal totalunallocatedamount,
			                                           @RequestParam("totalpoliciesamount") BigDecimal totalpoliciesamount,
			                                           @RequestParam("modifiedby") String modifiedby){
		 
		
		Date modifieddate = new Date(); 
		Object message = mah.deletemanualallocationtodetrecord(manualhdrid, manualToDtlId, totalallocatedamount, totalunallocatedamount, totalpoliciesamount, modifiedby, modifieddate);
		System.out.println(message); 
		return null;
	 }
	 
	
	 
	 // inserting the new records into t_int_cash_office when we are posting the existing records
	 @PostMapping(path="/allocations/maualallocationpostingintcashoffice")
	 public ResponseEntity<?> postrecordintcashoffice(@RequestBody IntCashOfficeModel[] icm){
		 
		 List<Double> intcashlistid = new ArrayList<Double>();
		 
		 for(int i=0;i<icm.length;i++){
			 icm[i].setCurrency(33);
			 icm[i].setStatus('p');
			 Date creationdate = new Date(); 
			 double intcashofficeid = ico.insertrecordintotintcashoffice(icm[i].getReceiptno(),
					                                                     icm[i].getPaymentfor(),
					                                                      icm[i].getDueDate(),
					                                                      icm[i].getPartyid(),
					                                                      icm[i].getAllocatedamount(),
					                                                       icm[i].getCurrency(),
					                                                       icm[i].getStatus(),
					                                                        creationdate,
					                                                       icm[i].getCreatedby(), 
					                                                       icm[i].getPolicycode());
			 intcashlistid.add(intcashofficeid);
		 }
		 return ResponseEntity.ok().body(intcashlistid);
	 }
	 
	 
	 //updating posting status of table  t_pol_manual_to_det from 'U' to 'P' 
	 @PostMapping(path="/allocations/upatepostingstatustodtl")
	 public ResponseEntity<?> updatepostingsttaustodtl( @RequestBody IntCashOfficeModel[] cf){
		 
		 List<Double> tmanualtodtlid = new ArrayList<Double>(); 
		 for(int i=0;i<cf.length;i++){
			 
			 char postingstatus='P';
			 Date postingdate = new Date();
			 String postedby =cf[i].getCreatedby();
			 double maualtodtl= cf[i].getMaualtodtlid();
			 
		double todtlid = 	 matodet.updatepostingstatusmanualtodet(postingstatus, postingdate, postedby, maualtodtl);
		tmanualtodtlid.add(todtlid);	 
		 }
		 return ResponseEntity.ok().body(tmanualtodtlid);
	 }
	
	 // updating posting status of t_pol_maual_hdr from 'U' to 'P'
	 @GetMapping(path="/allocations/manualallocation/updatepostingstatusmanualhdr")
	 public ResponseEntity<?> updatetpolmaualhdrpostingstatus(@RequestParam("manualhdrid") double manualhdrid,@RequestParam("postedby") String postedby){
		 
		 System.out.println(manualhdrid);
		 Date posteddate = new Date();
		 int statusupdated = marr.updatedpostingstatus(manualhdrid,postedby,posteddate);
		 System.out.println(statusupdated);
		 return null;
	 }
}
