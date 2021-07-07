package com.sais.cashoffice.CashOfficeTest.transaction.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.transaction.model.CustomResponseBody;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PaymentReceipt;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PolicyForm;
import com.sais.cashoffice.CashOfficeTest.transaction.repository.PaymentReceiptRepository;

@Service
public class PaymentReceiptImpl implements PaymentReceiptService{

	@Autowired
	private PaymentReceiptRepository PaymentReceiptRepository;
	
	@Autowired
	private EntityManager entityManager;

	
	public List<PaymentReceipt> getRcptDtls(double Id){		
		List<PaymentReceipt> appFormList1 = new ArrayList<PaymentReceipt>();
	     List<Object[]> appList = PaymentReceiptRepository.getRcptDtls(Id);
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PaymentReceipt appForm = new PaymentReceipt();
				appForm.setcashierActId((double) object[0]);
				appForm.setcashOffActId((double) object[1]);
				appForm.setcashOffId((double) object[2]); 
				appForm.setcashierId((double) object[3]);
				appForm.setcashierName((String) object[4]);
				appForm.setcashOffCode((String) object[5]);
				
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}
	
	
	public List<PaymentReceipt> getApplicationDtls(double Id){		
		List<PaymentReceipt> appFormList1 = new ArrayList<PaymentReceipt>();
	     List<Object[]> appList = PaymentReceiptRepository.getApplicationDtls(Id);
	     System.out.println(appList.size()+"-----appList");
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PaymentReceipt appForm = new PaymentReceipt();
				appForm.setappCode((String) object[0]);
				appForm.setappId((double) object[1]);
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}
	
	public List<PaymentReceipt> getAppApplication(){		
		List<PaymentReceipt> appFormList1 = new ArrayList<PaymentReceipt>();
	     List<Object[]> appList = PaymentReceiptRepository.getAppApplications();
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PaymentReceipt appForm = new PaymentReceipt();
				appForm.setappActId((int) object[0]); 
				appForm.setappActCode((String) object[1]);
				appForm.setappActDesc((String) object[2]);	
				appForm.setappId((int) object[3]);
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}

	
	public List<PaymentReceipt> getBankDtls(){		
		List<PaymentReceipt> appFormList1 = new ArrayList<PaymentReceipt>();
	     List<Object[]> appList = PaymentReceiptRepository.getBankDtls();
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PaymentReceipt appForm = new PaymentReceipt();
				appForm.setbankCode((String) object[0]);
				appForm.setbankName((String) object[1]);			
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}
	
	public List<PaymentReceipt> getBankBranchDtls(String bankId){		
		List<PaymentReceipt> appFormList1 = new ArrayList<PaymentReceipt>();
	     List<Object[]> appList = PaymentReceiptRepository.getBankBranchDtls(bankId);
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PaymentReceipt appForm = new PaymentReceipt();
				appForm.setbranchCode((String) object[0]);
				appForm.setbranchName((String) object[1]);			
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}
	
	public List<PaymentReceipt> getPayModeDtls(int Id){		
		List<PaymentReceipt> appFormList1 = new ArrayList<PaymentReceipt>();
	     List<Object[]> appList = PaymentReceiptRepository.PayModeDtls(Id);
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PaymentReceipt appForm = new PaymentReceipt();
				appForm.setpayMtdId((double) object[0]);
				appForm.setmodeName((String) object[1]);				
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}
		
	public List<PolicyForm> getPolicyDtls(String Id){		
		List<PolicyForm> appFormList1 = new ArrayList<PolicyForm>();
	     List<Object[]> appList = PaymentReceiptRepository.getRcptArrearDtls(Id);
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PolicyForm appForm = new PolicyForm();
				appForm.setPOLICY_CODE((String) object[0].toString());
				appForm.setDUE_DATE((String) object[1]);
				appForm.setPAYOR((String) object[2]);
				appForm.setARREARS((double) object[3]);
				appForm.setEXPECTED_PREMIUM((double) object[4]);
				appForm.setSTATUS((String) object[5]);
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}
	
	
	
	public List<PaymentReceipt> getRcptPostDtls(String usrId){		
		List<PaymentReceipt> appFormList1 = new ArrayList<PaymentReceipt>();
	     List<Object[]> appList = PaymentReceiptRepository.getRcptPostDtls(usrId);
	     if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				PaymentReceipt appForm = new PaymentReceipt();
				//System.out.println("UnAllocated Amount	:", appForm.setrcptNo((double) object[0]));
				appForm.setrcptNo((double) object[0]);
				appForm.setrcptDate((Date) object[1]);	
				appForm.setrcptAmount((String) object[2].toString());
				appForm.setpostStatus((String) object[3].toString());	
				appFormList1.add(appForm);				
			}	
		}		
		return appFormList1;
	}
	
	
	public void updateRcptPostStatus(double Id){		
		PaymentReceiptRepository.updateRcptPostStatus(Id);		
	}


	@Override
	public List<PolicyForm> getPolicyDtls(int Id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public  List<CustomResponseBody> InsertRcptDtls(String Amt, String From, double Pay_Id, double Coff_Id, double Cashier_Id,
			String Create_By, double App_Id, double All_amt, double Un_All_Amt) {
		
         List<CustomResponseBody> crb = new ArrayList<>();
         StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pe_Create_Receipt");
         try {
        	 System.out.println(BigDecimal.valueOf(Long.parseLong(Amt)));
           query.registerStoredProcedureParameter(1, BigDecimal.class, ParameterMode.IN);
  	       query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
  	       query.registerStoredProcedureParameter(3, double.class, ParameterMode.IN);
  	       query.registerStoredProcedureParameter(4, double.class, ParameterMode.IN);
  	       query.registerStoredProcedureParameter(5, double.class, ParameterMode.IN);
  	       query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
  	       query.registerStoredProcedureParameter(7, double.class, ParameterMode.IN);
  		   query.registerStoredProcedureParameter(8, BigDecimal.class, ParameterMode.IN);
  		   query.registerStoredProcedureParameter(9, BigDecimal.class, ParameterMode.IN);
  		   
  		query.registerStoredProcedureParameter(10, double.class, ParameterMode.OUT);
	       query.registerStoredProcedureParameter(11, double.class, ParameterMode.OUT);
	      query.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
	       
	       // Pass the parameter values
		   	query.setParameter(1,BigDecimal.valueOf(5000.2));
			query.setParameter(2, From);
			query.setParameter(3, Pay_Id);
			query.setParameter(4, Coff_Id);
			query.setParameter(5, Cashier_Id);
			query.setParameter(6, Create_By);
			query.setParameter(7, App_Id);
			query.setParameter(8, BigDecimal.valueOf(All_amt));
			query.setParameter(9, BigDecimal.valueOf(Un_All_Amt));
			
			// Execute query
		    boolean excute = query.execute();
		    
		    double recepitNo  = (double)  query.getOutputParameterValue(10);
		     double recptTransAllcId = (double) query.getOutputParameterValue(11);
		    String msg = (String) query.getOutputParameterValue(12);
		    
		    System.out.println(recepitNo);
		    System.out.println(recptTransAllcId);
		 double rcptallocId =   PaymentReceiptRepository.InsertRcptAllocationDtls(recptTransAllcId, Create_By, App_Id,  BigDecimal.valueOf(All_amt), BigDecimal.valueOf(Un_All_Amt));
		 System.out.println(rcptallocId);
		    CustomResponseBody cb = new CustomResponseBody();
		    cb.setMessage("Record is created");
		    cb.setRecepitNo(recepitNo);
		    cb.setRecepitAllocId(rcptallocId);;
		    cb.setStatus("200");
		    crb.add(cb);
		    
		    
         }catch(Exception e) {
        	 e.printStackTrace();
        	 CustomResponseBody cb = new CustomResponseBody();
        	 cb.setMessage("exception occured");
 		    cb.setRecepitNo(0.0);
 		    cb.setStatus("500");
 		    crb.add(cb);
 		    
 		    return crb;
         }
         
      
			return crb;
	}
	
}
