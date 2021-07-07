package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sais.cashoffice.CashOfficeTest.entities.TCashOffActivity1;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ActivityForm;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ActivityForm1;
import com.sais.cashoffice.CashOfficeTest.transaction.repository.ActivityRepository;

@Service
public class ActivityImpl implements Activity {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ModelMapper modelmapper;

	char c;
	ActivityForm forms = new ActivityForm();
	ActivityForm af = new ActivityForm();
	ActivityForm form = new ActivityForm();

	@Override
	public List<ActivityForm> getCheckActivity(String userID) {
		LocalDate date = LocalDate.now();
		List<ActivityForm> formlist = new ArrayList<ActivityForm>();
		System.out.println("date @@@@@@@@@@@@@@@@@@@@@ "+date);
		List<Object[]> appList = activityRepository.findCheckActivityDate(userID, date);
		if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				ActivityForm form1 = new ActivityForm();
				form1.setCashOffActivityId((double) object[0]);
				form1.setCashOfficeId((double) object[1]);
				form1.setCashierId((double) object[2]);
				form1.setBranchCode((String) object[3]);
				form1.setReceiptDate(date);
				form1.setStatus((char) object[5]);
				formlist.add(form1);
			}
		} else {
			return null;
		}

		return formlist;
	}

	@Override
	public List<ActivityForm> getAllActivityDetails(String userID) throws Exception {
		try {
			System.out.println(userID);
			List<ActivityForm> appFormList1 = new ArrayList<ActivityForm>();
			List<Object[]> appList = activityRepository.getAllActivityDetails(userID);

			if (appList != null && !appList.isEmpty()) {
				for (Object[] object : appList) {
					if(object[0].equals("no records found")) {
						System.out.println("no records were found in T_CASH_OFF_ACTIVITY WHERE STATUS ='O'");
						return null;
					}
					ActivityForm appForm = new ActivityForm();
					appForm.setCashOffActivityId((double) object[0]);
					appForm.setBranchCode((String) object[1]);
					LocalDate date = LocalDate.now();
					appForm.setReceiptDate(date);
					appForm.setCashOfficeCode((String) object[3]);
					appFormList1.add(appForm);

				}
			}else {
				return null;
			}

			return appFormList1;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("cash office closed.");
			return null;
		}

	}

	@Override
	public List<ActivityForm1> getTillActivityDetails(double userID,String userName) throws Exception {
		try {
			List<ActivityForm1> appFormList1 = new ArrayList<ActivityForm1>();
			//double cashierActivityId = activityRepository.getCashierActivityId();
		//	cashierActivityId = cashierActivityId + 1;
			List<Object[]> appList = activityRepository.getTillActivityDetails(userID);
			if (appList != null && !appList.isEmpty()) {
				for (Object[] object : appList) {
					if(object[0].equals("no records found")) {
						System.out.println("no records were found in T_CASH_OFF_ACTIVITY WHERE STATUS ='O'");
						return null;
					}
					ActivityForm1 appForm1 = new ActivityForm1();
					appForm1.setCashierCode((String) object[0]);
					appForm1.setCashierActivityId((double) object[1]);
					appForm1.setCashierId((double) object[2]);
					appForm1.setCashierName((String) object[3]);
					appForm1.setLoginId((String) object[4]);
					appForm1.setBranchCode((String) object[5]);
					appForm1.setCashOffActivityId((double) object[6]);
					appForm1.setTillActivityStatus((char) object[7]);
					
					appFormList1.add(appForm1);
				}
			} else {
				System.out.println("till activity not opened");
				return null;
			}
			return appFormList1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unknown error in the getTillActivityDetails() method");
			return null;
		}
	}

	@Override
	@Transactional
	public List<ActivityForm> getUserActivityDetails(String userID) {
		List<ActivityForm> appFormList5 = new ArrayList<ActivityForm>();
		System.out.println(userID);
		List<Object[]> appList = activityRepository.findByuserId(userID);
		 if (appList != null && !appList.isEmpty()) {

		for (Object[] object : appList) {
			ActivityForm appForm1 = new ActivityForm();
			
			appForm1.setCashierId((double) object[0]);
			appForm1.setCashierCode((String) object[1]);
			appForm1.setCashierName((String) object[2]);
			//appForm1.setCoCashierId((int) object[3]);
			appForm1.setCoCashierId((double) object[3]);
			appForm1.setCashOfficeId((double) object[4]);
			appForm1.setSeniorCashierYn((char) object[5]);
			appForm1.setCashOfficeCode((String) object[6]);
			appForm1.setCashOfficeDesc((String) object[7]);   
			//appForm1.setStatus((char) object[6]);
			c = appForm1.getSeniorCashierYn();
			appFormList5.add(appForm1);
			
		}
		 }else {
			 return null;
		 }
		if (c == '0') {
			System.out.println("The user not authorized to open cash Office ");
			return appFormList5;
		} else {

			List<Object[]> appList2 = activityRepository.getCashoffDetails(userID);
			ActivityForm appForm1 = new ActivityForm();
			if (appList2 != null && !appList2.isEmpty()) {
				for (Object[] object3 : appList2) {

					appForm1.setCashOfficeCode((String) object3[0]);
					appForm1.setCashOfficeId((double) object3[1]);
					appForm1.setBranchCode((String) object3[2]);
					appForm1.setCashierId((double) object3[3]);
					LocalDate date = LocalDate.now();
					appForm1.setReceiptDate(date);
					appForm1.setSeniorCashierYn(c);
					appFormList5.add(appForm1);
				}
				
			} else {
				System.out.println("the cash office is not assigned for this user");
			}
		}

		ActivityForm appForm1 = new ActivityForm();
		List<Object[]> appList4 = activityRepository.findByCashOfficeId(appForm1.getCashOfficeId());
		if (appList4 != null && !appList4.isEmpty()) {
			for (Object[] object1 : appList4) {

				appForm1.setCashOfficeId((double) object1[1]);
				appForm1.setBranchCode((String) object1[2]);
				String branch = appForm1.getBranchCode();
				appForm1.setBranchCode(branch);
				appForm1.setStatus((char) object1[4]);
				appForm1.setCashOffActivityId(appForm1.getCashOffActivityId());
				LocalDate date = LocalDate.now();
				appForm1.setReceiptDate(date);
			
				appFormList5.add(appForm1);

			}

		} else {

			List<Object[]> appList2 = activityRepository.getCashofficeCode(userID);
			if (appList2 != null && !appList2.isEmpty()) {
				for (Object[] object4 : appList2) {
					form.setBranchCode((String) object4[1]);
					form.setCashOfficeCode((String) object4[0]);
					LocalDate date = LocalDate.now();
					form.setReceiptDate(date);
					
					appFormList5.add(form);
				}
			}else {
				return null;
			}
		}
		return appFormList5;
	}

	@Override
	@Transactional
	public TCashOffActivity1 openActivity(@Valid ActivityForm activity) throws Exception {
		try {
			TCashOffActivity1 cashoffactivityEntity = modelmapper.map(activity, TCashOffActivity1.class);
			cashoffactivityEntity.setCashOfficeId(activityRepository.getCashOfficeId(activity.getCashOfficeCode()));
			cashoffactivityEntity.setCashierId(activity.getCashierId());
			// insert cash_off_ativity_id
			double cashOfficeActivityId= activityRepository.getCashOffActivityId();
			if(cashOfficeActivityId ==0) {
				cashOfficeActivityId=1;
			}
			cashoffactivityEntity.setCashOffActivityId(cashOfficeActivityId+1);
			LocalDate date = LocalDate.now();
			cashoffactivityEntity.setReceiptDate(date);
			char status = 'O';
			cashoffactivityEntity.setStatus(status);
			activityRepository.save(cashoffactivityEntity);
			
			
			return cashoffactivityEntity;

		} catch (Exception ex) {
			throw new Exception("There was an Error occured during saving cashier entity");
		}
	}

	@Override
	public TCashOffActivity1 closeActivity(String userID, @Valid ActivityForm activity) {

		TCashOffActivity1 cashoffactivityEntity = modelmapper.map(activity, TCashOffActivity1.class);
		LocalDate date = LocalDate.now();
		cashoffactivityEntity.setReceiptDate(date);
		activityRepository.closeactivity(activity.getCashOffActivityId());
		char c = activityRepository.saveActivityStatus(activity.getCashOffActivityId());
		cashoffactivityEntity.add(c);
		cashoffactivityEntity.setStatus((c));
		return cashoffactivityEntity;

	}

	@Override
	public TCashOffActivity1 authorizeTillCashiers(double cashierActivityId, @Valid ActivityForm1 activity,String userName) {

		TCashOffActivity1 cashoffactivityEntity = modelmapper.map(activity, TCashOffActivity1.class);
		LocalDate date = LocalDate.now();
		cashoffactivityEntity.setReceiptDate(date);
		activityRepository.updateTillStatus(cashierActivityId,userName);
		char c = activityRepository.getTillStatus(cashierActivityId);
		cashoffactivityEntity.add(c);
		cashoffactivityEntity.setStatus((c));
		return cashoffactivityEntity;
	}

}
