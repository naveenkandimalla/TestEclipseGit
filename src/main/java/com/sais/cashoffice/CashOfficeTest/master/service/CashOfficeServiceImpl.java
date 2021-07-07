package com.sais.cashoffice.CashOfficeTest.master.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sais.cashoffice.CashOfficeTest.entities.TApplication;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOffApp;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOffPymtMthd;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOffice;
import com.sais.cashoffice.CashOfficeTest.entities.TCompanyOrgan;
import com.sais.cashoffice.CashOfficeTest.entities.TPaymentMethod;
import com.sais.cashoffice.CashOfficeTest.master.model.AssignApplicationForm;
import com.sais.cashoffice.CashOfficeTest.master.model.AssignPaymentMethodForm;
import com.sais.cashoffice.CashOfficeTest.master.model.CashOfficeDetForm;
import com.sais.cashoffice.CashOfficeTest.master.repository.ApplicationSetUpRepository;
import com.sais.cashoffice.CashOfficeTest.master.repository.CashOffPymtMethodRepository;
import com.sais.cashoffice.CashOfficeTest.master.repository.CashOfficeAppRepository;
import com.sais.cashoffice.CashOfficeTest.master.repository.CashOfficeSetUpRepository;
import com.sais.cashoffice.CashOfficeTest.master.repository.CompanyOrganRepository;
import com.sais.cashoffice.CashOfficeTest.master.repository.PaymentMethodRepository;
import com.sais.cashoffice.exception.DuplicateDataException;

@Service
public class CashOfficeServiceImpl implements CashOfficeService {

	@Autowired
	private CashOfficeSetUpRepository cashOfficeSetUpRepo;

	@Autowired
	private CompanyOrganRepository coRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private CashOfficeAppRepository coAppRepo;

	@Autowired
	private ApplicationSetUpRepository appSetUpRepo;

	@Autowired
	private PaymentMethodRepository paymentMethodRepo;

	@Autowired
	private CashOffPymtMethodRepository cashOffPymtRepo;

	@Override
	public List<CashOfficeDetForm> getCashOfficeDetails() {
		List<CashOfficeDetForm> appFormList1 = new ArrayList<CashOfficeDetForm>();
		List<Object[]> appList = coAppRepo.getCashOfficeDtls();
		if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				CashOfficeDetForm appForm = new CashOfficeDetForm();
				appForm.setCashOfficeCode((String) object[0]);
				appForm.setCashOfficeDesc((String) object[1]);
				appForm.setBranchCode((String) object[2]);
				appForm.setBranchName((String) object[3]);
				appForm.setCashOfficeId((double) object[4]);
				appFormList1.add(appForm);
			}
		}
		return appFormList1;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TCompanyOrgan> getBranchesDetails() {
		return coRepo.findAll();
	}


	@Override
	@Transactional
	public TCashOffice createCashOffice(CashOfficeDetForm coDetails,String createdby) {

		TCashOffice coEntity = modelmapper.map(coDetails, TCashOffice.class);
		String s = coRepo.getCode(coDetails.getBranchCode());
		long cashOfficeid = coAppRepo.findMaxCashOfficeId();
		if(cashOfficeid==0) {
			cashOfficeid=1;
		}
		System.out.println(cashOfficeid);
		coEntity.setBranchCode(s);
		coEntity.setCashOfficeId(cashOfficeid+1);

		TCashOffice appList= cashOfficeSetUpRepo.findByCashOfficeId((long) (coDetails.getCashOfficeId()));
		try {
			if (appList == null) {	
				coEntity.setCashOfficeCode(coDetails.getCashOfficeCode());
				coEntity.setCashOfficeDesc(coDetails.getCashOfficeDesc());
				Date creationdate = new Date();
				coEntity.setCreatedBy(createdby);
				coEntity.setCreationDate(creationdate);
				return cashOfficeSetUpRepo.save(coEntity);
			} else {
				Date modifieddate = new Date();
				coEntity.setModifiedBy(createdby);
				coEntity.setModifiedDatetime(modifieddate);
				cashOfficeSetUpRepo.updatetcashoffice(coDetails.getCashOfficeCode(), coDetails.getCashOfficeDesc(),
						s, modifieddate, createdby, coDetails.getCashOfficeId());
				return cashOfficeSetUpRepo.findByCashOfficeId((long) (coDetails.getCashOfficeId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 

	}

	@Override
	public List<AssignApplicationForm> fetchAllApplicationsAssignedToCashOffice(String code) {
		TCashOffice tc = cashOfficeSetUpRepo.findByCashOfficeCode(code);
		List<TCashOffApp> apps = coAppRepo.findByCashOfficeId(tc.getCashOfficeId());
		List<AssignApplicationForm> assignList = new ArrayList<AssignApplicationForm>();
		for (TCashOffApp tco : apps) {
			AssignApplicationForm aa = new AssignApplicationForm();
			aa.setCashOfficeAppId(tco.getCoAppId());
			aa.setAppId(tco.getTApplication().getAppId());
			aa.setCashOfficeCode(tco.getTCashOffice().getCashOfficeCode());
			aa.setApplicationCode(tco.getTApplication().getAppCode());
			aa.setApplicationDesc(tco.getTApplication().getAppDesc());
			aa.setStartDate(tco.getStartDate());
			aa.setEndDate(tco.getEndDate());
			assignList.add(aa);
		}

		return assignList;
	}



	@Override
	@Transactional
		public TCashOffApp assignAppToCashOffice(AssignApplicationForm details,String createdby) throws Exception {
		
		System.out.println(details.getCashOfficeAppId());
		System.out.println(details.getAppId());
			TCashOffApp coaEntity = modelmapper.map(details, TCashOffApp.class);
			
			TApplication appid = appSetUpRepo.findByAppCode(details.getApplicationCode());
			  
			     long  applicationappid = appid.getAppId();
			     int    A_id = (int) applicationappid;
			TCashOffice tco = cashOfficeSetUpRepo.findByCashOfficeCode(details.getCashOfficeCode());
			         
			 double cashofficeid = tco.getCashOfficeId();
			 double cashOfficeAppId=coAppRepo.findMaxCashOfficeAppId();
			 
			 if(cashOfficeAppId ==0) {
				 cashOfficeAppId=1;
			 }
			
			coaEntity.setTCashOffice(tco);
			 System.out.println(details.getAppId());
			 System.out.println(tco.getCashOfficeId());
			List<TCashOffApp> appi =  coAppRepo.findByAppIdAndCashOfficeId(applicationappid, tco.getCashOfficeId());
			
			try {
				if (appi.size() >0){
					Date modifiedDate = new Date();
					int success = coAppRepo.updaterecordT_CASH_OFF_APP(details.getStartDate(), details.getEndDate(), modifiedDate, createdby, details.getCashOfficeAppId());
					System.out.println(success);
					TCashOffApp cashofficeappsaved = new TCashOffApp();
					cashofficeappsaved.setModifiedBy(createdby);
					return cashofficeappsaved;
					
					//throw new DuplicateDataException("This Application code is already assigned to given CashOffice");
	
				} else {
					Date creationdate = new Date();
					coaEntity.setCreatedBy(createdby);
					coaEntity.setCreationDate(creationdate);
					
					int success = coAppRepo.insertrecordT_CASH_OFF_APP(cashOfficeAppId+1,cashofficeid,A_id,
							                                           details.getStartDate(), details.getEndDate(),
							                                           creationdate, createdby);
					
					
					TCashOffApp cashofficeappsaved = new TCashOffApp();
					
					cashofficeappsaved.setCoAppId(applicationappid);
					
					return cashofficeappsaved;
				}
	
			} catch (Exception e) {
	
				return null;
			}
			
		}

	@Override
	public List<AssignPaymentMethodForm> fetchAllPaymentMethodsAsgndToCashOffice(String code) {
		TCashOffice tc = cashOfficeSetUpRepo.findByCashOfficeCode(code);
		List<TCashOffPymtMthd> apps = cashOffPymtRepo.findByCashOfficeId(tc.getCashOfficeId());
		List<AssignPaymentMethodForm> assignList = new ArrayList<AssignPaymentMethodForm>();
		for (TCashOffPymtMthd tco : apps) {
			AssignPaymentMethodForm aa = new AssignPaymentMethodForm();
			aa.setCashOfficiePaymentId(tco.getCoPymtMthdId());
			aa.setPayMethodId(tco.getTPaymentMethod().getPayMethodId());
			aa.setCashOfficeCode(tco.getTCashOffice().getCashOfficeCode());
			aa.setPymtMethodCode(tco.getTPaymentMethod().getPayMethodCode());
			aa.setPymtMethodDesc(tco.getTPaymentMethod().getPayMethodDesc());
			aa.setStartDate(tco.getStartDate());
			aa.setEndDate(tco.getEndDate());
			assignList.add(aa);
		}
		return assignList;
	}

	@Override
	@Transactional
	public TCashOffPymtMthd assignPymtMethodToCashOffice(AssignPaymentMethodForm assignForm,String createdby) throws Exception {

		System.out.println(assignForm.getCashOfficiePaymentId());
		System.out.println(assignForm.getPayMethodId());
		
		if(assignForm.getCashOfficiePaymentId()==0) {
			System.out.println("we are working on new record");
		}
		
		
		TCashOffPymtMthd copEntity = modelmapper.map(assignForm, TCashOffPymtMthd.class);
		TPaymentMethod paymentmode = paymentMethodRepo.findByPayMethodCode(assignForm.getPymtMethodCode());
		
		long paymentmodeiddetail = paymentmode.getPayMethodId();
		TCashOffice tco = cashOfficeSetUpRepo.findByCashOfficeCode(assignForm.getCashOfficeCode());
		long cashofficeid=tco.getCashOfficeId();
		
		double CashOffPymtMthdId=paymentMethodRepo.findMaxCashOffPymtMthdId();
		System.out.println(0==0.0);
		if(CashOffPymtMthdId==0) {
			CashOffPymtMthdId=1;
		}

		List<TCashOffPymtMthd> appi =	cashOffPymtRepo.findByPymtMethodIdAndCashOfficeId(paymentmodeiddetail,cashofficeid);
		
		

		try {
			if (appi.size()>0) {
				Date Modifieddate = new Date();
				int success = cashOffPymtRepo.updateRecordT_CASH_OFF_PYMT_MTHD(assignForm.getStartDate(),  assignForm.getEndDate(), Modifieddate, createdby,  assignForm.getCashOfficiePaymentId());
				System.out.println(success);
				TCashOffPymtMthd cp = new TCashOffPymtMthd();
				cp.setModifiedBy(createdby);			
				return cp;
				//throw new DuplicateDataException("This payment method code is already assigned to given CashOffice");

			} else {
				Date createddate = new Date();
				int success = cashOffPymtRepo.insertrecordT_CASH_OFF_PYMT_MTHD(CashOffPymtMthdId+1,cashofficeid, paymentmodeiddetail, 
						assignForm.getStartDate(), assignForm.getEndDate(), 
						createddate, createdby);
				System.out.println(success);

				TCashOffPymtMthd cp = new TCashOffPymtMthd();
				cp.setCreatedBy(createdby);				
				return cp;
			}

		} catch (Exception e) {

			return null;
		}

	}

	

}
