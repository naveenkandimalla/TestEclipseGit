package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.IntCashOfficeModel;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.IntCashOfficeModelServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Model.MisAllocPolicyPartial;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Model.Misallocpartialfromdet;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Model.Misallocpartialhdr;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Model.Misallocpartialtodet;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Model.PnewmanualPcode;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Repository.MisAllocPolicyPartialRepository;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Repository.PnewmanualPcodeRepository;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Service.MisAllocPolicyPartialServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Service.MisallocpartialfromdetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Service.MisallocpartialhdrServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Service.MisallocpartialtodetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Service.PnewmanualPcodeServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class PartialMisallocationCorrectionController {
	
	// getting MisAllocPolicyPartial details
	
	@Autowired
	public MisAllocPolicyPartialServiceImpl mpps;
	
	// policycode new manual
	@Autowired
	public PnewmanualPcodeServiceImpl PcodeServiceImpl;
	
	
	// misalloccorrectionpartial hdr
	@Autowired
	public MisallocpartialhdrServiceImpl partialhdrServiceImpl;
	
	// misalloccorrectionpartial todet
	@Autowired
	public MisallocpartialtodetServiceImpl partialtodetServiceImpl;
	
	
	// misalloccorrectionpartial from det
	@Autowired
	public MisallocpartialfromdetServiceImpl partialfromdetServiceImpl;
	
	@Autowired
	public MisAllocPolicyPartialRepository mpr;
	
	@Autowired
	public PnewmanualPcodeRepository ppr;
	
	@Autowired
	private IntCashOfficeModelServiceImpl ico;
	
	
	// fetching all partial misallocation details 
	@GetMapping(path="/allocations/partialmisallocationdetails/policycode")
	public List<MisAllocPolicyPartial> fetchallmisallocpartialdetails(@RequestParam("policycode") String policycode,@RequestParam("period") String perioddetails) throws ParseException{
		java.sql.Date ds = null ;	
		Date date=ds.valueOf(perioddetails);//converting string into sql date  
	    return mpps.getmisallocpolicypartial(policycode, date);
	}
	
	

	// fetching partialmisallocationtodet details by using hdrid
	@GetMapping(path="/allocations/partialmisallocationdetails/todet")
	public List<Misallocpartialtodet> fetchtodetdetailsbyhrdid(@RequestParam("hdrid") double partialhdrid){
		return partialtodetServiceImpl.fetchalltodetmisalloc(partialhdrid);
     }
	
	
	//fetching newmanual policycode details
	@GetMapping(path="/allocations/partialmisallocationdetails/pnewpolicycode")
	public List<PnewmanualPcode> fetchallpnewmanualpolicydetails(@RequestParam("policycode") String policycode,@RequestParam("period") String perioddetails) throws Exception{
		PnewmanualPcode pp = new PnewmanualPcode();
		 java.sql.Date ds = null ;
		if(perioddetails==null || perioddetails.isEmpty() || perioddetails.equals("null")  ){
			return PcodeServiceImpl.getnewmanualpolicydetails1(policycode);	
		} else{
			 Date date=ds.valueOf(perioddetails);//converting string into sql date  	     
		     return PcodeServiceImpl.fetchalldetailsnewmanualpcode(policycode,date);	
		}	 
	
	}
	
	
	// insert particalmisallocationhdr 
	@PostMapping(path="/allocations/partialmisallocationdetails/inserthdr")
	public ResponseEntity<?> insertnewtohdr(@RequestBody Misallocpartialhdr hdr,
			                                @RequestParam("createdby") String createdby,
			                                @RequestParam("modifiedby") String modifiedby){
		
		System.out.println("we started inserting");
		
		hdr.setPostingStatus("U");
		Date Creationdate = new Date();
		Date Modifieddate = new Date();
		hdr.setCreationDate(Creationdate);
		hdr.setModifiedDatetime(Modifieddate);
		hdr.setCreatedBy(createdby);
		hdr.setModifiedBy(modifiedby);
//		System.out.println(hdr.getTotalReversalAmt());
//		System.out.println(hdr.getTotalAllocatedAmt());
//		System.out.print(hdr.getTransactionType());
		String transcationtype=hdr.getTransactionType();
		if(transcationtype.equals("reverse")){
			hdr.setTransactionType("R");
			hdr.setTotalAllocatedAmt(0);
		}else{
			hdr.setTransactionType("A");
		}
		
		double hdrid = partialhdrServiceImpl.insertnewrecordmisallpartialhdr(hdr.getTotalReversalAmt(), hdr.getTotalAllocatedAmt(),
				                                                             hdr.getTransactionType(),hdr.getPostingStatus(), 
				                                                             hdr.getCreationDate(),hdr.getCreatedBy(), 
				                                                             hdr.getModifiedDatetime(),hdr.getModifiedBy());
		//System.out.println("hdr id ---->"+hdrid);
		return ResponseEntity.ok().body(hdrid);
	}
	
	
	// updating t_pol_partialmisallocation hdr table record
	@PostMapping(path="/allocations/partialmisallocationdetails/updatehdr")
	public ResponseEntity<?> updaterecordhdr(@RequestBody Misallocpartialhdr hdr,
                                             @RequestParam("modifiedby") String modifiedby,
                                             @RequestParam("hdrid") double partialmisallochdrid){
		
		System.out.println(hdr.getTotalAllocatedAmt());
		System.out.println(hdr.getTransactionType());
		
		Date modifieddate = new Date();
		
		String transcationtype=hdr.getTransactionType();
		if(transcationtype.equals("reverse")){
			hdr.setTransactionType("R");
		}else{
			hdr.setTransactionType("A");
		}
		
		double hdrid = (double) partialhdrServiceImpl.updatepolpartialmisallocationhdr(partialmisallochdrid,hdr.getTransactionType(), hdr.getTotalAllocatedAmt(), modifiedby, modifieddate);
		return ResponseEntity.ok().body(hdrid);
	}
	
	
	//updating posting status of t_pol_partial_misallo_hdr
	
	 @GetMapping(path="/partialmisallocation/postingstatusofpartialmisallochdr")
	 public ResponseEntity<?> updatepostingstatushdr(@RequestParam("Partialmisallocationhdrid") double Partialmisallocationhdrid,
			                                      @RequestParam("postedby") String postedby){
		 
		  System.out.println(Partialmisallocationhdrid);
		  Date postingdate = new Date();
		  
		   int count = (int) partialhdrServiceImpl.updatepostingstatuspartialmisallochdr(postedby, postingdate, Partialmisallocationhdrid);
		  
		   return   ResponseEntity.ok().body(count);                                   
        }
	
	
	
	// insert  particalmisallocationfromdet 
	@PostMapping(path="/allocations/partialmisallocationdetails/inserfromdetr")
	public ResponseEntity<?> insertnewfromdet(@RequestBody Misallocpartialfromdet[] fdet,
			                                  @RequestParam("pmishdrid") double hdrid,
			                                  @RequestParam("createdby") String createdby,
				                               @RequestParam("modifiedby") String modifiedby){
		
		List<Double> hdrformdetid = new ArrayList<>();
		
		for(int i=0;i<fdet.length;i++){
			
			Date Creationdate = new Date();
			Date Modifieddate = new Date();
			fdet[i].setCreationDate(Creationdate);
			fdet[i].setModifiedDatetime(Modifieddate);
			fdet[i].setCreatedBy(createdby);
			fdet[i].setModifiedBy(modifiedby);
			fdet[i].setPostingStatus("U");
			//System.out.println(hdrid+"coming from front end ");
			//System.out.println(fdet[i].getPolicyId()+"this policy code ");
		    double hrdfromdet = partialfromdetServiceImpl.insertnewrecordmisallparitalfrmdet( hdrid,fdet[i].getPolicyId(),
					                                                                          fdet[i].getPolicyCode(),fdet[i].getPeriod(),
					                                                                          fdet[i].getPolicyStatus(),  fdet[i].getAmount(), 
					                                                                          fdet[i].getPartyId(),fdet[i].getPayorName(), 
					                                                                          fdet[i].getReceiptNo(),fdet[i].getListId(),
					                                                                          fdet[i].getPostingStatus(),fdet[i].getCollectionFlag(),
					                                                                          fdet[i].getCreationDate(), fdet[i].getCreatedBy(),
					                                                                          fdet[i].getModifiedDatetime(),fdet[i].getModifiedBy());
			
		    hdrformdetid.add(hrdfromdet);
			//System.out.println("misallocation partial from det---->"+hrdfromdet);
			
			
		}
		
		
		return ResponseEntity.ok().body(hdrformdetid);
	}
	
	
	
	// insert new recod todet
	@PostMapping(path="/allocations/partialmisallocationdetails/insertoetr")
	public ResponseEntity<?> insertnewtodet(@RequestBody Misallocpartialtodet[] tdet,
			                                @RequestParam("pmishdrid") double hdrid,
			                                @RequestParam("createdby") String createdby,
				                            @RequestParam("modifiedby") String modifiedby){
		
		System.out.println(hdrid);
		System.out.println(createdby);
		System.out.println(modifiedby);
		List<Double> hdrtodetid = new ArrayList<>();
		 
		for(int i=0;i<tdet.length;i++){
			
			Date Creationdate = new Date();
			Date Modifieddate = new Date();
			tdet[i].setCreationDate(Creationdate);
			tdet[i].setModifiedDatetime(Modifieddate);
			tdet[i].setCreatedBy(createdby);
			tdet[i].setModifiedBy(modifiedby);
			tdet[i].setArrears(new BigDecimal(0.0));
			tdet[i].setPostingStatus("U");
			
			System.out.println(hdrid+"coming from front end ");
			System.out.println(tdet[i].getPolicyCode()+"this policy code from to det  ");
			System.out.println(tdet[i].getPeriod()+"period  ");
			System.out.println(tdet[i].getPolicyStatus()+"policy status   ");
			System.out.println(tdet[i].getAmount()+"amount  ");
			System.out.println(tdet[i].getArrears()+"getArrears()  ");
			System.out.println(tdet[i].getPartyId()+"getPartyId()  ");
			System.out.println(tdet[i].getPolicyId()+"getPolicyId()  ");
			
			
		double hdrtodet = 	partialtodetServiceImpl.insertnewrecordtomisallocpartialtodet(hdrid , tdet[i].getPolicyCode(),
				                                                                          tdet[i].getPeriod(), tdet[i].getPolicyStatus(),
				                                                                          tdet[i].getAmount(), tdet[i].getArrears(),
				                                                                         tdet[i].getPayorName() ,tdet[i].getPostingStatus() ,
				                                                                          tdet[i].getPurpose(), tdet[i].getPartyId(),
				                                                                          tdet[i].getPolicyId() , tdet[i].getReceiptNumber(),
				                                                                         tdet[i].getCreationDate() ,tdet[i].getCreatedBy() ,
				                                                                         tdet[i].getModifiedDatetime(),tdet[i].getModifiedBy());
			
		
		      System.out.println("todet----->"+hdrtodet);
		
		      hdrtodetid.add(hdrtodet);
			
			
			
			
		}
		return ResponseEntity.ok().body(hdrtodetid);
		//return null;
		
	}
	
	
	

	
	
	
// delete record from T_POL_PARTIAL_MISALL_TO_DET
	@DeleteMapping(path="/allocations/partialmisallocationdetails/deletetodet")
	public int deletetodetrecord(@RequestParam("todetid") double todetid){
		
		System.out.println(todetid);
	 int count =   (int) partialtodetServiceImpl.deleterecordmisalloctodet(todetid);
		
		 System.out.println(count);
		 
		 return 1;
	}
	
	
	//posting the record into t_int_cash_office;
	 @PostMapping(path="/allocations/partialmisallocationintcash")
	 public ResponseEntity<?> postrecordintcashoffice(@RequestBody IntCashOfficeModel[] icm){
		 
		 List<Double> intcashlistid = new ArrayList<Double>();
		 
		 for(int i=0;i<icm.length;i++){
			 
			 System.out.println( icm[i].getReceiptno()+"-----begin");
			 System.out.println( icm[i].getPaymentfor());  // this valye will come from purpose
			 System.out.println( icm[i].getDueDate());
			 System.out.println( icm[i].getPartyid());
			 System.out.println( icm[i].getAllocatedamount());
			 System.out.println( icm[i].getPolicycode());
			 System.out.println( icm[i].getCreatedby());
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
	
	 
	 //updating the posting status
	 @GetMapping(path="/partialmisallocation/postingstatuspremium")
	 public ResponseEntity<?> updatepostingstatusPremium(@RequestParam("Partialmisallocationhdrid") double Partialmisallocationhdrid,
			                                      @RequestParam("postedby") String postedby){
		 
		  System.out.println(Partialmisallocationhdrid);
		  Date postingdate = new Date();
		  
		   int count = (int) partialhdrServiceImpl.updatepostingstatusPremium(postedby, postingdate, Partialmisallocationhdrid);
		  
		   return   ResponseEntity.ok().body(count);                                   
        }
	 
	 
	//updating the posting status
		 @GetMapping(path="/partialmisallocation/postingstatusReverse")
		 public ResponseEntity<?> updatepostingstatusReverse(@RequestParam("Partialmisallocationhdrid") double Partialmisallocationhdrid,
				                                      @RequestParam("postedby") String postedby){
			 
			  System.out.println(Partialmisallocationhdrid);
			  Date postingdate = new Date();
			  
			 
			  int count=	 (int) partialhdrServiceImpl.updatepostingstatusReverse(postedby, postingdate, Partialmisallocationhdrid);
			  return   ResponseEntity.ok().body(count);                                       
	        }
	
	
}
