package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.AssignRoleQueryModel;
import com.sais.cashoffice.CashOfficeTest.admin.model.GroupAuthorityModel;
import com.sais.cashoffice.CashOfficeTest.admin.model.Group_Authorities_Master;
import com.sais.cashoffice.CashOfficeTest.admin.repository.AssignRoleRepository;

@Service
public class AssignRoleServiceImple implements AssignRoleService {
	
	@Autowired
	private AssignRoleRepository ar;
	
	@Override
	public   List<Group_Authorities_Master> getallGroupAuthorities(){
		
	return	ar.findAll();
		
		
	}

	@Override
	public Object insertrecordgroupauthority(String authority, String authoritydesc, Date creationdate,
			String createdby) {
		
		return ar.insertrecordgroupauthority(authority, authoritydesc, creationdate, createdby);
	}

	@Override
	public Object updaterecordgroupauthority(String authority, String authoritydesc, Date modified, String modifiedby,
			Date creationdate) {

		return ar.updaterecordgroupauthority(authority, authoritydesc, modified, modifiedby, creationdate);
	}


	@Override
	public Object insertrecordgroupauyhorities(String authority, double groupid, char enabled, Date creationdate,
			String createdby) {
	
		return ar.insertrecordgroupauyhorities(authority, groupid, enabled, creationdate, createdby);
	}

	@Override
	public Object updaterecordgroupauyhorities(char enabled, Date modifidationdate, String modifiedby, double groupid) {
		
		return ar.updaterecordgroupauyhorities(enabled, modifidationdate, modifiedby, groupid);
	}

	@Override
	public List<AssignRoleQueryModel> fetchassignroledetails(String authority) {
		
		return null;
		 
		
	}

	
	
	
	

}
