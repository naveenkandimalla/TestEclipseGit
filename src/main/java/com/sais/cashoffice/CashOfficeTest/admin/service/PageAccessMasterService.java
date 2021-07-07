package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessMaster;

public interface PageAccessMasterService {
	
	List<PageAccessMaster> getpageaccessMasterdetails();
	
	public Object insertrecordpageaccessmaster(String screencode,String screendesc,
            String url,double mouldid, Date creationdate,String createdby,char enabled);

	public Object updaterecordpageaccessmaster(double pageaccessid,String screencode,String screendesc,
            String url,double mouldid, Date modifiteddate,String modifiedby,char status);


}
