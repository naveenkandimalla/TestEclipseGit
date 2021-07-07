package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.repository.GroupMasterRepository;

@Service
public class GroupMasterServiceImpl implements GroupMasterService {
	
	@Autowired
	private GroupMasterRepository gmr;
	

	@Override
	public Object insertrecordtgroup(String groupname, String groupdesc, String createdby, Date creationdate) {
	
		return gmr.insertrecordtgroup(groupname, groupdesc, createdby, creationdate);
	}

	@Override
	public Object updaterecordtgroup(String groupname, String groupdesc, String modifiedby, Date modifieddate,
			double groupid) {
		
		return gmr.updaterecordtgroup(groupname, groupdesc, modifiedby, modifieddate, groupid);
	}

}
