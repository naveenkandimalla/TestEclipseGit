package com.sais.cashoffice.CashOfficeTest.master.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.entities.TAppActivity;
import com.sais.cashoffice.CashOfficeTest.entities.TApplication;
import com.sais.cashoffice.CashOfficeTest.master.model.AppActivitiesForm;
import com.sais.cashoffice.CashOfficeTest.master.model.AppSetUpForm;
import com.sais.cashoffice.CashOfficeTest.master.repository.ApplicationActivitiesRepository;
import com.sais.cashoffice.CashOfficeTest.master.repository.ApplicationSetUpRepository;
import com.sais.cashoffice.CashOfficeTest.transaction.model.QueryReceiptForm;
import com.sais.cashoffice.exception.ErrorDetails;
import com.sais.cashoffice.exception.Response;

@Service
public class ApplicationSetUpServiceImpl implements ApplicationSetUpService {

	@Autowired
	private ApplicationSetUpRepository appSetUpRepo;

	@Autowired
	private ApplicationActivitiesRepository appActivityRepo;

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<AppSetUpForm> getAllApplications() {
		List<AppSetUpForm> appFormList = new ArrayList<AppSetUpForm>();
		List<TApplication> appList = appSetUpRepo.findAll();
		for (TApplication tapp : appList) {
			AppSetUpForm appForm = new AppSetUpForm();
			appForm.setApplicationCode(tapp.getAppCode());
			appForm.setApplicationDesc(tapp.getAppDesc());
			appForm.setAppId(tapp.getAppId());
			appForm.setEnabled(tapp.getEnabled());
			appForm.setStartDate(tapp.getCreationDate());
			appForm.setEndDate(tapp.getCreationDate());
			appFormList.add(appForm);
		}
		return appFormList;
	}
	

	

	@Override
	public List<AppActivitiesForm> getActivitesByAppId(int appid) {
		List<AppActivitiesForm> appFormList = new ArrayList<AppActivitiesForm>();
		List<Object[]> appList = appActivityRepo.findByAppCode(appid);
		System.out.println(appList.size());
		
		if (appList != null && !appList.isEmpty()) {
			for (Object[] object : appList) {
				AppActivitiesForm appForm = new AppActivitiesForm();
				
				//char enable = (char) object[0];
				//String enablestatus=Character.toString(c);
				String enableApp=(String) object[0];
				char p= enableApp.charAt(0);
				appForm.setEnabled(p);
				appForm.setAppActivityId((int) object[1]);
				appForm.setAppId((int) object[2]);
				appForm.setAppActivityCode((String) object[3]);
				appForm.setAppActivityDesc((String) object[4]);
				appFormList.add(appForm);
			}
		}
		
		return appFormList;
		
	}

	@Override
	@Transactional
	public AppActivitiesForm createActivity(int appid,String appActivityCode,String appActivityDesc,char enabled,Date creationdate,String createdby) {
		AppActivitiesForm AppActivitiesForm = new AppActivitiesForm();
		
		
           StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pe_Create_ApplicationActivity");
//           IN   p_App_ID    int,
//           IN   p_App_Act_Code              	varchar(3),
//			 IN   p_App_Act_Desc              	varchar(60),
//			
//			 IN   p_Enabled                   	varchar(1),
//			 IN   p_Creation_Date             	DATETIME,
//			 IN   p_Created_By                	varchar(50),
//          
		
	      try {
		// Declare the parameters in the same order
	       query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
	       query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	       query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	       query.registerStoredProcedureParameter(4, Character.class, ParameterMode.IN);
	       query.registerStoredProcedureParameter(5, Date.class, ParameterMode.IN);
	       query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
	       
	       query.registerStoredProcedureParameter(7, Character.class, ParameterMode.OUT);
	       query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.OUT);
	       query.registerStoredProcedureParameter(9, Integer.class, ParameterMode.OUT);
	       query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);
	       query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);
	       query.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
	       query.registerStoredProcedureParameter(13, Integer.class, ParameterMode.OUT);
		
		
	    // Pass the parameter values
		   	query.setParameter(1, appid);
			query.setParameter(2, appActivityCode);
			query.setParameter(3, appActivityDesc);
			query.setParameter(4, enabled);
			query.setParameter(5, creationdate);
			query.setParameter(6, createdby);
			// Execute query
		    boolean excute = query.execute();
		    
		    System.out.println("does query excuted--->"+excute);
		  //  OUT  p_out_enabled              	varchar(1),
//			 OUT  p_out_AppActID              	INT,
//         out p_out_App_ID                   int,
//			 out p_out_App_Act_Code              	varchar(3),
//			 out p_out_App_Act_Desc              	varchar(60),
//         out p_Out_Msg varchar(200),
        // out p_out_success int
		    
		 // Get output parameters
             char enab = (char)  query.getOutputParameterValue(7);
		     int applicationActivityId = (int) query.getOutputParameterValue(8);
		     int applicationId = (int) query.getOutputParameterValue(9);
		     String applicationActivityCode  = (String)  query.getOutputParameterValue(10);
		     String applicationActivityDesc  = (String)  query.getOutputParameterValue(11);
		     String outMsg = (String)  query.getOutputParameterValue(12);
		     int successid = (int) query.getOutputParameterValue(13);
		    
		     AppActivitiesForm.setEnabled(enab);
		     AppActivitiesForm.setAppActivityId(applicationActivityId);
		     AppActivitiesForm.setAppId(applicationId);
		     AppActivitiesForm.setAppActivityCode(applicationActivityCode);
		     AppActivitiesForm.setAppActivityDesc(applicationActivityDesc);
		     AppActivitiesForm.setResponseMsg(outMsg);
		     AppActivitiesForm.setResponseSuccess(successid);
		     AppActivitiesForm.setCreatedBy(createdby);
		    
		    
		    
	      }catch(Exception e) { 
	    	  e.printStackTrace();
	    	  AppActivitiesForm.setResponseMsg("Exception occured");
	    	  AppActivitiesForm.setResponseSuccess(0);
	    	  
	      }

	
		return AppActivitiesForm;		
		
			

	}

	// use for updating status 
	@Override
	public AppActivitiesForm updatetappactivity(int appactivityid,int applicationId,String activitycode, String appactdesc, char enable, Date modifieddate,
			String modifiedby) {
		
		
		AppActivitiesForm AppActivitiesForm = new AppActivitiesForm();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pe_Update_ApplicationActivity");
			
		 try {
				// Declare the parameters in the same order
			       query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
			       query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
			       query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			       query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			       query.registerStoredProcedureParameter(5, Character.class, ParameterMode.IN);
			       query.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
			       query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
			       query.registerStoredProcedureParameter(8, Character.class, ParameterMode.OUT);
			       query.registerStoredProcedureParameter(9, Integer.class, ParameterMode.OUT);
			       query.registerStoredProcedureParameter(10, Integer.class, ParameterMode.OUT);
			       query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);
			       query.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
			       query.registerStoredProcedureParameter(13, String.class, ParameterMode.OUT);
			       query.registerStoredProcedureParameter(14, Integer.class, ParameterMode.OUT);
				
				
			    // Pass the parameter values
				   	query.setParameter(1, appactivityid);
					query.setParameter(2, applicationId);
					query.setParameter(3, activitycode);
					query.setParameter(4, appactdesc);
					query.setParameter(5, enable);
					query.setParameter(6, modifieddate);
					query.setParameter(7, modifiedby);
					// Execute query
				    boolean excute = query.execute();
				    
				    System.out.println("does query excuted--->"+excute);
				    
				 // Get output parameters
		             char enabl = (char)  query.getOutputParameterValue(8);
				     int applicationActivityId = (int) query.getOutputParameterValue(9);
				     int appId = (int) query.getOutputParameterValue(10);
				     String applicationActivityCode  = (String)  query.getOutputParameterValue(11);
				     String applicationActivityDesc  = (String)  query.getOutputParameterValue(12);
				     String outMsg = (String)  query.getOutputParameterValue(13);
				     int successid = (int) query.getOutputParameterValue(14);
				    
				     AppActivitiesForm.setEnabled(enabl);
				     AppActivitiesForm.setAppActivityId(applicationActivityId);
				     AppActivitiesForm.setAppId(applicationId);
				     AppActivitiesForm.setAppActivityCode(applicationActivityCode);
				     AppActivitiesForm.setAppActivityDesc(applicationActivityDesc);
				     AppActivitiesForm.setResponseMsg(outMsg);
				     AppActivitiesForm.setResponseSuccess(successid);
				    
				    
				    
			      }catch(Exception e) { 
			    	  e.printStackTrace();
			    	  AppActivitiesForm.setResponseMsg("Exception occured");
			    	  AppActivitiesForm.setResponseSuccess(0);
			    	  
			      }

			
				return AppActivitiesForm;		
				

	}




	@Override
	public AppSetUpForm createApplication(String Code, String Desc, char Enabled, Date creationDate,
			String CreatedBy) {
		AppSetUpForm appFormList = new AppSetUpForm();
		
		try {
			// initally defining the procedure name
						StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pe_Create_Application");
						
						// Declare the parameters in the same order
					       query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(3, Character.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(4, Date.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(7, String.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(8, String.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(9, Character.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(11, Integer.class, ParameterMode.OUT);
					       
					       // Pass the parameter values
						   	query.setParameter(1, Code);
							query.setParameter(2, Desc);
							query.setParameter(3, Enabled);
							query.setParameter(4, new Date());
							query.setParameter(5, CreatedBy);
							// Execute query
						    boolean excute = query.execute();
						    
						    System.out.println("does query excuted--->"+excute);
						    
						 // Get output parameters
						     int applicationId = (int) query.getOutputParameterValue(6);
						     String applicationCode  = (String)  query.getOutputParameterValue(7);
						     String applicationDesc  = (String)  query.getOutputParameterValue(8);
						     char enabled = (char)  query.getOutputParameterValue(9);
						     String outMsg = (String)  query.getOutputParameterValue(10);
						     int successid = (int) query.getOutputParameterValue(11);
						     
						     appFormList.setAppId(applicationId);
						     appFormList.setApplicationCode(applicationCode);
						     appFormList.setApplicationDesc(applicationDesc);
						     appFormList.setEnabled(enabled);
						     appFormList.setResponseMsg(outMsg);
						     appFormList.setResponseSuccess(successid);
					return appFormList;       
		}catch(Exception e) {
			e.printStackTrace();
			appFormList.setResponseMsg("Exception occurds");
			appFormList.setResponseSuccess(0);
		}
		return appFormList;
			
	}




	@Override
	public AppSetUpForm updateApplication(int appId, String Code, String Desc, char Enabled, Date modifiedDate,
			String modifiedBy) {
AppSetUpForm appFormList = new AppSetUpForm();

		
		try {
			// initally defining the procedure name
						StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pe_Update_Application");
						
						// Declare the parameters in the same order
						   query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(4, Character.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(5, Date.class, ParameterMode.IN);
					       query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
					       
					       query.registerStoredProcedureParameter(7, Integer.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(8, String.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(9, String.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(10, Character.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);
					       query.registerStoredProcedureParameter(12, Integer.class, ParameterMode.OUT);
					       
					       // Pass the parameter values
					        query.setParameter(1, appId);
						   	query.setParameter(2, Code);
							query.setParameter(3, Desc);
							query.setParameter(4, Enabled);
							query.setParameter(5, new Date());
							query.setParameter(6, modifiedBy);
							// Execute query
						    boolean excute = query.execute();
						    
						    System.out.println("does query excuted--->"+excute);
						    
						 // Get output parameters
						     int applicationId = (int) query.getOutputParameterValue(7);
						     String applicationCode  = (String)  query.getOutputParameterValue(8);
						     String applicationDesc  = (String)  query.getOutputParameterValue(9);
						     char enabled = (char)  query.getOutputParameterValue(10);
						     String outMsg = (String)  query.getOutputParameterValue(11);
						     int successid = (int) query.getOutputParameterValue(12);
						     
						     appFormList.setAppId(applicationId);
						     appFormList.setApplicationCode(applicationCode);
						     appFormList.setApplicationDesc(applicationDesc);
						     appFormList.setEnabled(enabled);
						     appFormList.setResponseMsg(outMsg);
						     appFormList.setResponseSuccess(successid);
					return appFormList;       
		}catch(Exception e) {
			e.printStackTrace();
			appFormList.setResponseMsg("Exception occurds");
			appFormList.setResponseSuccess(0);
		}
		return appFormList;
	}

}
