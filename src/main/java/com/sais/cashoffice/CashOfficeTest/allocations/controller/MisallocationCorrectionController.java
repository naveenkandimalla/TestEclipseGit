package com.sais.cashoffice.CashOfficeTest.allocations.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.IntCashOfficeModel;
import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Service.IntCashOfficeModelServiceImpl;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.MisallcationFromPol;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.MisallcationToDet;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.MisallocationHdr;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.PolicyInfo;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.VwMisallocatedPolicy;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Repository.PolicyInfoRepository;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Repository.VwMisallocatedPolicyRepository;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Service.MisallcationFromDetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Service.MisallcationToDetServiceImpl;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Service.MisallocationHdrServiceImpl;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Service.PolicyInfoServiceImpl;
import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Service.VwMisallocatedPolicyServiceImpl;
import com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Model.Misallocpartialtodet;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.AssignDbtFileTmpt;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class MisallocationCorrectionController {
	
	// calling all service implementations
	
	@Autowired
	public VwMisallocatedPolicyServiceImpl vwaps;
	
	
	@Autowired
	public PolicyInfoServiceImpl policyinfoservice;
	
	
	@Autowired
	public MisallocationHdrServiceImpl MisallocatHdrServiceImpl;
	
	
	@Autowired
	public MisallcationToDetServiceImpl MisallcaToDetServiceImpl;
	
	@Autowired
	public MisallcationFromDetServiceImpl MisallcaFromDetServiceImpl;
	
	
	@Autowired
	private IntCashOfficeModelServiceImpl ico;
	
	
	// repository 
	
	@Autowired
	public VwMisallocatedPolicyRepository vwpr;
	
	@Autowired
	public PolicyInfoRepository policyinfor;
	
	
	

	// code used for fetching the VwMisallocatedPolicydetails
	
	@GetMapping(path="/allocations/misallocationcorrection/misallocpolicy")
	public List<VwMisallocatedPolicy> fetchallVwMisallocatedPolicy(@RequestParam("policycode") String policycode){
		
		
		return vwaps.fetchallvwallocatedpolicy(policycode);
		
		//return vwpr.getvwallocatedpolicy(policycode);
		
	}
	
	
	
	@GetMapping(path="/allocations/misallocationcorrection/policyinfo")
	public List<PolicyInfo> fetchallpolicyinfodetails(@RequestParam("policycode") String policycode){
		
		return policyinfoservice.fetchallpolicyinfodetails(policycode);
		
		//return policyinfor.getallpolicyinfodetails(policycode);
		}
	
	
	
	
	@GetMapping(path="/allocations/misallocationcorrection/misallocationdettoget")
	public List<MisallcationToDet> fetchdetailsfrommisallocationtodet(@RequestParam("misallocationhdrid") double misallocationhdrid ){
		
		return MisallcaToDetServiceImpl.fetchallmisalltodet(misallocationhdrid);
		
		
	}
	
	
	// use to save a record in misallocationhdr table	
	@PostMapping(path="/allocations/misallocationcorrection/misallocationhdrrecordinsert")
	public ResponseEntity<?> insertnewrecordmisallochdr(@RequestBody MisallocationHdr mhr){
		System.out.println(mhr.getTotalReversalAmt());
		
		  Date creationdate = new Date();
		   Date modifieddate = new Date();	
		
		double misallhdrid = MisallocatHdrServiceImpl.misallochdrnewrecord(mhr.getTotalReversalAmt(), mhr.getTotalAllocatedAmt(), mhr.getPostingStatus(),
				                                                          creationdate, mhr.getCreatedBy(), modifieddate,mhr.getModifiedBy());
		
		
		return ResponseEntity.ok().body(misallhdrid);
		
	}
	
	//update record in misallocationhdr table @RequestParam("misallocidhdr") double hdrid,
	@PostMapping(path="/allocations/misallocationcorrection/misallocationhdrrecordupdate")
	public ResponseEntity<?> updaterecordmisallochdr(@RequestBody MisallocationHdr mhr,@RequestParam("misallocidhdr") double hdrid){
		System.out.println("starting hdr update--------");
		
		System.out.println(mhr.getTotalReversalAmt());
		System.out.println(hdrid);
		
		   Date modifieddate = new Date();	
		
	  double misallhdrid = MisallocatHdrServiceImpl.misallochdrupdaterecord(hdrid, mhr.getTotalReversalAmt(),
				                                                       mhr.getTotalAllocatedAmt(),
				                                                        modifieddate,mhr.getModifiedBy());
		return ResponseEntity.ok().body(misallhdrid);
		   
		   
		
	}
	
	
	
	// used to save a record in misallocationfromdet table
		@PostMapping(path="/allocations/misallocationcorrection/misallocationfromdetinsertnewrecord")
		public ResponseEntity<?> insertnewrecordintomisallfromdet(@RequestParam("misallocidhdr") double hdrid,
				                                                  @RequestParam("createdby") String createdby,
				                                                  @RequestParam("modifiedby") String modifiedby,
				                                                  @RequestBody MisallcationFromPol[] misallfrm ){
			
	          List<Double> misallocfromdetid = new ArrayList<>(); 
			System.out.println("size---->"+misallfrm.length);
			
			  for(int i=0;i<misallfrm.length;i++){
				   Date creationdate = new Date();
				   Date modifieddate = new Date();
				   misallfrm[i].setPostingstatus("U");
				   
				  double misallocatedfrmdet = MisallcaFromDetServiceImpl.misallocationfrmdetinsertrecord(hdrid, misallfrm[i].getPolicyid(),misallfrm[i].getPolicyCode(),
						                                                                                  misallfrm[i].getPeriod(), misallfrm[i].getPolicystatus(), misallfrm[i].getAmount(),misallfrm[i].getPartyid(),
						                                                                                   misallfrm[i].getPartyname(), misallfrm[i].getRecepitNumber(), misallfrm[i].getId(), 
						                                                                                   misallfrm[i].getPostingstatus(), misallfrm[i].getCollectionflag(),
						                                                                                   creationdate, createdby, 
						                                                                                   modifieddate,modifiedby);
				  System.out.println( "resulted from det------->"+misallocatedfrmdet);
				  misallocfromdetid.add(misallocatedfrmdet);
				  
				  
			  }
			   
			
			   
			
			return ResponseEntity.ok().body(misallocfromdetid);
			 // return null;
			   

			
		}
	
	
	
	// insert record into misallocation to det table
	@PostMapping(path="/allocations/misallocationcorrection/misallocationtodetinsertnewrecord")
	public ResponseEntity<?> insertarecordintomisallocationtodet(@RequestParam("misallocidhdr") double hdrid,
			                                                     @RequestParam("createdby") String createdby,
				                                                  @RequestParam("modifiedby") String modifiedby,
				                                                  @RequestParam("policycode") String policycode,
				                                                  @RequestParam("formValue") String form,
				                                                  @RequestParam("misallocationfromdet") String misallocation
				                                                ) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		PolicyInfo[] policydetails = mapper.readValue(form, PolicyInfo[].class);
		System.out.println("policy info mapper is done");
		ObjectMapper mapper1 = new ObjectMapper();
		System.out.println("after vmmisallocation begin");
		VwMisallocatedPolicy[] misalloc = mapper.readValue(misallocation, VwMisallocatedPolicy[].class);
	    System.out.println("after vmmisallocation  started--");
				
		List<Double> misalloctodetid = new ArrayList<>(); 
		
		for(int i=0;i<misalloc.length;i++){
			Date creationdate = new Date();
		    Date modifieddate = new Date();
		   String postingstatus="U";
		    
		    String policystaus = policydetails[0].getStatusName();
		    String policysatusid="";
		    if(policystaus=="Inforce"){
		    	policysatusid="1";
		    }
		    
		    if(policystaus=="Waiting for Validate"){
		    	policysatusid="0";
		    }
		    if(policystaus=="Lapsed"){
		    	policysatusid="2";
		    }
		    if(policystaus=="Terminated"){
		    	policysatusid="3";
		    }
		    
		    System.out.println("ready for the action");
		    
		    double misallocationtodetrecord = MisallcaToDetServiceImpl.misalltoderecord(hdrid,
		    		                                                                    policydetails[0].getPolicycode(),
		    		                                                                     misalloc[0].getPeriod(),
		    		                                                                     policysatusid,
		    		                                                                     misalloc[0].getAmount(),
		    		                                                                     policydetails[0].getPartyName(),
		    		                                                                     postingstatus ,
		    		                                                                     policydetails[0].getPurpose(),
		    		                                                                     policydetails[0].getPartyid().doubleValue(),
		    		                                                                     policydetails[0].getPolicyId().doubleValue(),
		    		                                                                     Double.toString(misalloc[i].getRecepitNumber())  , 
		    		                                                                     creationdate, 
		    		                                                                     createdby,
		    		                                                                     modifieddate,
		    		                                                                     modifiedby);

       

            misalloctodetid.add(misallocationtodetrecord);
		}
		
				
		
		return ResponseEntity.ok().body(misalloctodetid);
	  
	}
	
	
	
	
	// posting record into int cash office
	 @PostMapping(path="/allocations/misallocationintcashoffice")
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
	 @GetMapping(path="/misallocation/postingstatus")
	 public ResponseEntity<?> updatepostingstatus(@RequestParam("misallocationhdrid") double misallocationhdrid,
			                                      @RequestParam("postedby") String postedby
			                                      ){
		 
		 Date postingDate = new Date();

		 int completedstatus = (int) MisallocatHdrServiceImpl.misallocationpostingstatus(misallocationhdrid, postedby, postingDate);
		 
		 return ResponseEntity.ok().body(completedstatus);
		 
		 
	 }
	

}
