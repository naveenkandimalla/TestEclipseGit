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

import com.sais.cashoffice.CashOfficeTest.entities.TCashOffActivity1;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ActivityForm;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ActivityForm1;
import com.sais.cashoffice.CashOfficeTest.transaction.service.ActivityImpl;
import com.sais.cashoffice.CashOfficeTest.transaction.service.ActivityImplDe;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CashOfficeActivityController {

	@Autowired
	private ActivityImpl activityImpl;

	@Autowired
	private ActivityImplDe tillactivityImpl;

	@GetMapping(path = "/Checkactivity/{userID}")
	public List<ActivityForm> getCheckActivity(@PathVariable(value = "userID") String userID) throws Exception {
		String ID = userID.replace("\"", "");
		System.out.println("user name===>"+ID);
		return activityImpl.getCheckActivity(ID);
	}

	@GetMapping(path = "/getActivitydetails/{userID}")
	public List<ActivityForm> getAllActivitydetails(@PathVariable(value = "userID") String userID) throws Exception {
		String str = userID.replace("\"", "");
		System.out.println("user name===>"+str);
		return activityImpl.getAllActivityDetails(str);
	}
	
	
	@GetMapping(path = "/userActivityDetails/{userID}")
	public List<ActivityForm> getUserCashOffDetails(@PathVariable(value = "userID") String userID) {
		String s = userID.replace("\"", "");
		System.out.println("user name===>"+s);
		List<ActivityForm> list = activityImpl.getUserActivityDetails(s);
		return list;
	}

	@GetMapping(path = "/tillActivitydetails")
	public List<ActivityForm1> getTillActivity(@RequestParam("caId") String coaid,@RequestParam("user") String userName) throws Exception {
		double cashOfficeActId= Double.parseDouble(coaid);
		System.out.println("cashOfficeActivity id "+cashOfficeActId);
		System.out.println("userName id "+userName);
	//	List<ActivityForm1> list1 = activityImpl.getTillActivityDetails(st);
	//	List<ActivityForm1> list = tillactivityImpl.getTillDetails(st);
	//	System.out.println(list);
//		System.out.println(list1);
//		if (list1 == null) {
//			return list;
//
//		} else if(list == null) {
//			return null;
//		}else {
//			
//			list.addAll(list1);
//		}

		//return list1;
		return activityImpl.getTillActivityDetails(cashOfficeActId,userName);
	}


	

	@PostMapping(path = "/getActivityId")
	public TCashOffActivity1 getActivityId(@RequestBody ActivityForm activity,@RequestParam("user") String userName) throws Exception {

		return activityImpl.openActivity(activity);
	}

	@PostMapping(path = "/closeCashOffice/{userID}")
	public TCashOffActivity1 getCloseActivity(@PathVariable(value = "userID") String userID,
			@RequestBody ActivityForm activity) throws Exception {

		return activityImpl.closeActivity(userID, activity);
	}

	@PostMapping(path = "/authorizeTillCashier")
	public TCashOffActivity1 authorizeTillCashier(@RequestParam("cashierActivityId") double cashierActivityId,@RequestParam("loginId") String userName,
			@RequestBody ActivityForm1 activity) throws Exception {

		System.out.println(cashierActivityId);
		System.out.println(userName);
		return activityImpl.authorizeTillCashiers(cashierActivityId, activity,userName);
	}

}
