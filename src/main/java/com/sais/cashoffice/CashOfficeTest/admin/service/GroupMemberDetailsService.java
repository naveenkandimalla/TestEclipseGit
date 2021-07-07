package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.Date;

public interface GroupMemberDetailsService {
	
	public int insertrecordgroupmember(double groupid,
            String username,
            String enable,
            Date creationdate,
            String createdby);
	
	public int updaterecordgroupmember(
            double groupmemid,
            String enable,
             double groupid,
             Date modifieddate,
             String modifiedby);

}
