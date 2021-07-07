package com.sais.cashoffice.CashOfficeTest.master.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sais.cashoffice.CashOfficeTest.entities.TApplication;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOffApp;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOffPymtMthd;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOffice;
import com.sais.cashoffice.CashOfficeTest.entities.TCompanyOrgan;
import com.sais.cashoffice.CashOfficeTest.entities.TPaymentMethod;
import com.sais.cashoffice.CashOfficeTest.master.model.AppActivitiesForm;
import com.sais.cashoffice.CashOfficeTest.master.model.AppSetUpForm;
import com.sais.cashoffice.CashOfficeTest.master.model.AssignApplicationForm;
import com.sais.cashoffice.CashOfficeTest.master.model.AssignPaymentMethodForm;
import com.sais.cashoffice.CashOfficeTest.master.model.CashOfficeDetForm;
import com.sais.cashoffice.CashOfficeTest.master.repository.ApplicationSetUpRepository;
import com.sais.cashoffice.CashOfficeTest.master.repository.PaymentMethodRepository;
import com.sais.cashoffice.CashOfficeTest.master.service.CashOfficeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CashOfficeController {
	
	@Autowired
	private CashOfficeService cashofficeService;
	
	
	@GetMapping(path="/getCashOfficeDetails",produces="application/json")
	public List<CashOfficeDetForm> fetchCashOfficeDetails(){
		return cashofficeService.getCashOfficeDetails();
	}
	
	@GetMapping(path="/getBranches",produces="application/json")
	public List<TCompanyOrgan> fetchAllBranches(){
		return cashofficeService.getBranchesDetails();
	}
	
	@Transactional
	@PostMapping(path="/createCashOffice",consumes = "application/json", produces = "application/json")
	public ResponseEntity<TCashOffice> saveCashoffice(@RequestBody CashOfficeDetForm coDetails,@RequestParam("createdby") String createdby) throws Exception {		
		TCashOffice id = cashofficeService.createCashOffice(coDetails,createdby);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		//return ResponseEntity.created(uri).build();
		return ResponseEntity.ok(id);
	}
	
	@GetMapping(path="/getAppsAssignedToCO",produces="application/json")
	public List<AssignApplicationForm> fetchAllApplicationsAssignedToCashOffice(@RequestParam("CoCode") String code){
		//System.out.println(code);
		return cashofficeService.fetchAllApplicationsAssignedToCashOffice(code);
	}
	@Transactional
	@PostMapping(path="/assignAppToCashOffice",produces="application/json")
	public ResponseEntity<TCashOffApp> assignAppToCashOffice(@RequestBody AssignApplicationForm assignForm,@RequestParam("createdby") String createdby)  throws Exception{
		TCashOffApp id = cashofficeService.assignAppToCashOffice(assignForm,createdby);
		return ResponseEntity.ok(id);
	}
	
	@GetMapping(path="/getPayMethodsAsgndToCO",produces="application/json")
	public List<AssignPaymentMethodForm> fetchAllAssignedPaymentMethodsToCO(@RequestParam("CoCode") String code){
		//System.out.println(code);
		return cashofficeService.fetchAllPaymentMethodsAsgndToCashOffice(code);
	}
	@Transactional
	@PostMapping(path="/asgnPaymentMethodToCO",produces="application/json")
	public ResponseEntity<TCashOffPymtMthd> asgnPaymentMethodToCO(@RequestBody AssignPaymentMethodForm assignForm,@RequestParam("createdby") String createdby) throws Exception{
		TCashOffPymtMthd id = cashofficeService.assignPymtMethodToCashOffice(assignForm,createdby);
		return ResponseEntity.ok(id);
	}
	


}
