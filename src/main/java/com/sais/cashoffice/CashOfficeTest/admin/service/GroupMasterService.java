package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.Date;

public interface GroupMasterService {
	
	public Object insertrecordtgroup(String groupname,
            String groupdesc,
            String createdby,
            Date creationdate);
	
	public Object updaterecordtgroup(String groupname,
            String groupdesc,
            String modifiedby,
            Date modifieddate,
            double groupid);

}
