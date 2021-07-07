package com.sais.cashoffice.CashOfficeTest.master.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sais.cashoffice.CashOfficeTest.entities.TAppActivity;
import com.sais.cashoffice.CashOfficeTest.entities.TPaymentMethod;
import com.sais.cashoffice.CashOfficeTest.master.model.AppActivitiesForm;
import com.sais.cashoffice.CashOfficeTest.master.model.AppSetUpForm;
import com.sais.cashoffice.CashOfficeTest.master.repository.ApplicationSetUpRepository;
import com.sais.cashoffice.CashOfficeTest.master.service.ApplicationSetUpService;
import com.sais.cashoffice.CashOfficeTest.transaction.model.QueryReceiptForm;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApplicationController {

	@Autowired
	private ApplicationSetUpService appSetUpService;
	
	@Autowired
	private ApplicationSetUpRepository appSetUpRepo;
	
	@GetMapping(path = "/appSetUpDetails", produces = "application/json")
	public List<AppSetUpForm> getApplications() {
		return appSetUpService.getAllApplications();
	}

	// this is for request type /getActivities/ACL --recommended rest usage
	@GetMapping(path = "/getActivities", produces = "application/json")
	public List<AppActivitiesForm> getActivitesByAppId(@RequestParam("appid") int appid) {
		//System.out.println("APP CODE: "+code);
		return appSetUpService.getActivitesByAppId(appid);
	}


	@PostMapping(path = "/saveActivity", consumes = "application/json", produces = "application/json")
	public List<AppActivitiesForm> saveActivity(@RequestBody AppActivitiesForm[] appActivity,@RequestParam("appid") int appid,@RequestParam("createdby") String createdby) {		
		System.out.println(appActivity.length);
		System.out.println(appid);
		System.out.println(createdby);

		List<AppActivitiesForm> appFormList = new ArrayList<>();
		
		for(int i=0;i<appActivity.length;i++){
			System.out.println(appActivity[i].getEnabled());
			char enablestatus = appActivity[i].getEnabled();
			AppActivitiesForm appActivites = appSetUpService.createActivity(appid, appActivity[i].getAppActivityCode(),
					appActivity[i].getAppActivityDesc(), appActivity[i].getEnabled(), new Date(), createdby);
			appFormList.add(appActivites);
		}
		
		return appFormList;
	}
	
	// used for saving new record into t_application table
	@PostMapping(path="/saveApplication",consumes = "application/json", produces = "application/json")
	public AppSetUpForm saveApplication(@RequestBody AppSetUpForm appDtls,@RequestParam("createdby") String createdby) {	
		System.out.println(appDtls.getAppId());
		System.out.println(appDtls.getApplicationCode());
		System.out.println(appDtls.getApplicationDesc());
		System.out.println(appDtls.getEnabled());
		System.out.println(createdby);
		Date creationDate = new Date();
		
		if(appDtls.getAppId() != 0) {
			
			return appSetUpService.updateApplication(appDtls.getAppId(), appDtls.getApplicationCode(), appDtls.getApplicationDesc(), appDtls.getEnabled(), new Date(), createdby);
			
		}
			
		 return appSetUpService.createApplication(appDtls.getApplicationCode(),
				 appDtls.getApplicationDesc(),
				 appDtls.getEnabled(),
				 creationDate,createdby);
	}
	
	@PostMapping(path="/updateappactivity",consumes = "application/json")
	public List<AppActivitiesForm> updateAppActivity(@RequestBody AppActivitiesForm[] appActivity,@RequestParam("appid") int appid,@RequestParam("modifiedby") String modifiedby){
		Date modifieddate = new Date();
		List<AppActivitiesForm> appFormList = new ArrayList<>();
		for(int i=0;i<appActivity.length;i++){
			System.out.println(appActivity[i].getEnabled());
			char enablestatus = appActivity[i].getEnabled();
			AppActivitiesForm appActivites = appSetUpService.updatetappactivity(appActivity[i].getAppActivityId(),appid,appActivity[i].getAppActivityCode(),appActivity[i].getAppActivityDesc(),
					             enablestatus, modifieddate, modifiedby);
			appFormList.add(appActivites);
		}
		
		return appFormList;
		
	}

}
