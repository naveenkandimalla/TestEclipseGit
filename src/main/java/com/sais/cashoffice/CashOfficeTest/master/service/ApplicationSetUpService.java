package com.sais.cashoffice.CashOfficeTest.master.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sais.cashoffice.CashOfficeTest.entities.TAppActivity;
import com.sais.cashoffice.CashOfficeTest.master.model.AppActivitiesForm;
import com.sais.cashoffice.CashOfficeTest.master.model.AppSetUpForm;

public interface ApplicationSetUpService {
	
	public List<AppSetUpForm> getAllApplications();

	public List<AppActivitiesForm> getActivitesByAppId(int appid);


	public AppActivitiesForm createActivity(int appid,String appActivityCode,String appActivityDesc,char enabled,Date creationdate,String createdby);
	
	public AppSetUpForm createApplication(String Code, String Desc, char Enabled,Date creationDate, String CreatedBy);
	
	public AppSetUpForm updateApplication(int appId,String Code, String Desc, char Enabled,Date modifiedDate, String modifiedBy);
	
	public AppActivitiesForm updatetappactivity(int appactivityid,int appid,String activitycode,String appactdesc,char enable,Date modifieddate,String modifiedby );

}

