package com.sais.cashoffice.CashOfficeTest.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.entities.TCashTillActivity1;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ActivityForm1;
import com.sais.cashoffice.CashOfficeTest.transaction.model.TillActivityForm;
import com.sais.cashoffice.CashOfficeTest.transaction.service.ActivityImplDe;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TillActivityController {


	@Autowired
	private ActivityImplDe tci;
	
	// which used for fetching records with status c it means cash till activity is closed
	@GetMapping(path = "/CheckTillDetails/{LId}", produces ="application/json")
	public List<ActivityForm1> getCheckTilldetails(@PathVariable String LId){
		String lid1 = LId.replace("\"", "");
		return tci.getCheckTillData(lid1);   

	}
	
	// below code is used for checking status of cash till activity status for login user
	@GetMapping(path = "/CheckTillStatus/{LId}", produces ="application/json")
	public List<TillActivityForm> getCheckTillstatus(@PathVariable String LId){
		String lid1 = LId.replace("\"", "");
		return tci.getCheckTillStatus(lid1);   

	}


	// were are fetching cashier and cash offf activity details
	@GetMapping(path = "/CashOffActivityAndCashierDetails/{LId}", produces ="application/json")
	public List<TillActivityForm> getCashOffActivityAndCashierDetails(@PathVariable String LId){	
		String lid1 = LId.replace("\"", "");
		return tci.getCashOfficeActivityAndCashierDetails(lid1) ;   

	}
	
	// were are fetching cashier and cash offf activity details
		@GetMapping(path = "/TillDetails/{LId}", produces ="application/json")
		public List<TillActivityForm> getCashTillActivitydetails(@PathVariable String LId){	
			String lid1 = LId.replace("\"", "");
			return tci.getCashActivityAndCashOfficeActivityAndCashierDetails(lid1) ;   

		}
	
	//used for saving new t_cash_till_activity record
	@PostMapping(path = "/Tillactivity", produces ="application/json")
	public TCashTillActivity1 openNewCashTillActivityDetails(@RequestBody TillActivityForm tcash,@RequestParam("loginId") String userName) throws Exception {
		return tci.openCashTillActivity(tcash,userName);
	}


	

}	



