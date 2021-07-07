package com.sais.cashoffice.CashOfficeTest.admin.service;
import java.util.Date;
import java.util.List;

import com.sais.cashoffice.CashOfficeTest.admin.model.AssignRoleQueryModel;
import com.sais.cashoffice.CashOfficeTest.admin.model.Group_Authorities_Master;

public interface AssignRoleService {
	
	public   List<Group_Authorities_Master> getallGroupAuthorities();
	
	public Object insertrecordgroupauthority(String authority,String authoritydesc,Date creationdate,String createdby);
		
	public Object updaterecordgroupauthority(String authority,String authoritydesc,Date modified,String modifiedby,Date creationdate);
    
	 public List<AssignRoleQueryModel> fetchassignroledetails(String authority);
	 
	 public Object insertrecordgroupauyhorities(String authority,double groupid,char enabled,Date creationdate,String createdby);
	
	 
	 public Object updaterecordgroupauyhorities(char enabled,Date modifidationdate,String modifiedby,double groupid);
}
