package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.entities.TCashTillActivity1;
import com.sais.cashoffice.CashOfficeTest.transaction.model.ActivityForm1;
import com.sais.cashoffice.CashOfficeTest.transaction.model.TillActivityForm;
import com.sais.cashoffice.CashOfficeTest.transaction.repository.ActivityRepository;
import com.sais.cashoffice.CashOfficeTest.transaction.repository.TillActivityRepository;

@Service
public class ActivityImplDe implements ActivityServiceDe {

	@Autowired
	private TillActivityRepository cashtillRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private ActivityRepository activityRepository;

	

	ActivityForm1 appForm = new ActivityForm1();

	@Override
	public List<ActivityForm1> getTillDetails(String userID) throws Exception {
		try {
			List<ActivityForm1> appFormList1 = new ArrayList<ActivityForm1>();
			System.out.println(userID);
			List<Object[]> appList = activityRepository.findBytill(userID);
			System.out.println(appList);
			if (appList != null && !appList.isEmpty()) {
				for (Object[] object : appList) {
					ActivityForm1 form1 = new ActivityForm1();
					form1.setCashierActivityId((double) object[0]);
					form1.setCashOffActivityId((double) object[1]);
					form1.setTillActivityStatus((char) object[2]);
					form1.setCashierName((String) object[3]);
					form1.setCashierCode((String) object[4]);
					form1.setLoginId((String) object[5]);
					form1.setBranchCode((String) object[6]);
					appFormList1.add(form1);
				}
			} else {
				System.out.println("error");
				return null;
			}
			return appFormList1;
		} catch (Exception e) {
			System.out.println("unknown error");
			return null;
		}
	}

	@Override
	public List<TillActivityForm> getCashOfficeActivityAndCashierDetails(String LId) {

		List<TillActivityForm> formlist = new ArrayList<TillActivityForm>();
		List<Object[]> appList = cashtillRepo.getCashOffActivityAndCashierDetails(LId);

		System.out.println(appList);

		if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				TillActivityForm tcj = new TillActivityForm();
				tcj.setCashOffActivityId((double) object[0]);
				tcj.setCashOfficeId((double) object[1]);
				tcj.setCashierId((double) object[2]);
				tcj.setStatus((char) object[3]);
				tcj.setBranchCode((String) object[4]);
				tcj.setCashOfficeDesc((String) object[5]);
				tcj.setCashOfficeCode((String) object[6]);
				tcj.setCashierName((String) object[7]);
				tcj.setBranchName((String) object[8]);
				tcj.setCashierCode((String) object[9]);
				//tcj.setCashierActivityId((double) object[10]);
				LocalDate date =LocalDate.now();
				tcj.setReceiptDate(date);
				formlist.add(tcj);
			}
		} else {
			System.out.println("cash office activity is not opened");
			return null;
		}
		
		return formlist;
	}
	
	
	
	@Override
	public List<TillActivityForm> getCashActivityAndCashOfficeActivityAndCashierDetails(String LId) {

		List<TillActivityForm> formlist = new ArrayList<TillActivityForm>();
		List<Object[]> appList = cashtillRepo.getCashTillActivityAndCashOfficeActivityDetails(LId);

		System.out.println(appList.size());

		if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				TillActivityForm tcj = new TillActivityForm();
				tcj.setCashOffActivityId((double) object[0]);
				tcj.setCashOfficeId((double) object[1]);
				tcj.setCashierId((double) object[2]);
				tcj.setStatus((char) object[3]);
				tcj.setBranchCode((String) object[4]);
				tcj.setCashOfficeDesc((String) object[5]);
				tcj.setCashOfficeCode((String) object[6]);
				tcj.setCashierName((String) object[7]);
				tcj.setBranchName((String) object[8]);
				tcj.setCashierCode((String) object[9]);
				tcj.setCashierActivityId((double) object[10]);
				
				LocalDate date =LocalDate.now();
				tcj.setReceiptDate(date);
				formlist.add(tcj);
			}
		} else {
			System.out.println("till not opened");
			return null;
		}
		
		return formlist;
	}

	@Override
	public TCashTillActivity1 openCashTillActivity(@Valid TillActivityForm tcash,String username) {

		TCashTillActivity1 cashtillEntity = modelmapper.map(tcash, TCashTillActivity1.class);
		
		double cashieractivityid = cashtillRepo.details7();
		System.out.println(cashieractivityid);
		cashieractivityid = cashieractivityid + 1;
		System.out.println(cashieractivityid);
		
		
		cashtillEntity.setCashierActivityId(cashieractivityid);
		LocalDate date = LocalDate.now();
		cashtillEntity.setCashOffActivityId(tcash.getCashOffActivityId());
		cashtillEntity.setTillActivityDate(date);
		cashtillEntity.setCreatedBy(username);
		Date createddate = new Date();
		cashtillEntity.setCreationDate(createddate);
		cashtillEntity.setBranchCode(tcash.getBranchCode());
		cashtillEntity.setCASH_OFFICE_ID(tcash.getCashOfficeId());
		cashtillEntity.setCashierId(tcash.getCashierId());
		cashtillEntity.setTillActivityStatus(tcash.getStatus());
		cashtillRepo.save(cashtillEntity);
	//	cashtillRepo.getTillDetails(cashieractivityid);
		// this.getTillActivityDetails(String userID);
		return cashtillEntity;
	}

	@Override
	public List<ActivityForm1> getCheckTillData(String LId) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		List<ActivityForm1> formlist = new ArrayList<ActivityForm1>();
		List<Object[]> appList = cashtillRepo.findTillDate(LId, date);
		System.out.println(appList);
		if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				ActivityForm1 form1 = new ActivityForm1();
				form1.setCashierActivityId((double) object[0]);
				form1.setCashOffActivityId((double) object[1]);
				form1.setTillActivityStatus((char) object[2]);
				form1.setCashierName((String) object[3]);
				form1.setCashierCode((String) object[4]);
				form1.setLoginId((String) object[5]);
				form1.setBranchCode((String) object[6]);
				formlist.add(form1);
			}
		} else {
			System.out.println("till not closed for today");
			return null;
		}
		return formlist;
	}

	@Override
	public List<TillActivityForm> getCheckTillStatus(String LId) {

		List<TillActivityForm> formlist = new ArrayList<TillActivityForm>();
		List<Object[]> appList = cashtillRepo.findTillStatus(LId);
		System.out.println(appList);
		if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				TillActivityForm form1 = new TillActivityForm();
				form1.setCashierActivityId((double) object[0]);
				form1.setCashOffActivityId((double) object[1]);
				form1.setCashOfficeId((double) object[2]);
				form1.setBranchCode((String) object[3]);
				form1.setTillActivityStatus((char) object[4]);
				form1.setCashierId((double) object[5]);
				formlist.add(form1);
			}
		} else {
			System.out.println("till not closed for today");
			return null;
		}
		return formlist;

	}
}
