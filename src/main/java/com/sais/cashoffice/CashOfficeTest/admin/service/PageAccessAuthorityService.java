package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessAuthority;

public interface PageAccessAuthorityService {
	
	List<PageAccessAuthority> getpageaccessAuthoritydetails();

	public Object insertrecordpageaccessauthority(String authority,char enable,
            double pageaccessid,Date creationdate,
            String createdby);

	public Object updaterecordT_PAGEACCESS_AUTHORITIES(double pageaccessid,String authority,
            Date modifieddate,char enable,
            String modifiedby,double pageaccessrole);

}
