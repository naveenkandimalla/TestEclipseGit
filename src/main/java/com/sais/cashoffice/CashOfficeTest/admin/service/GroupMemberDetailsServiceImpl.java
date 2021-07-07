package com.sais.cashoffice.CashOfficeTest.admin.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.repository.GroupMemberDetailsRepository;

@Service
public class GroupMemberDetailsServiceImpl implements GroupMemberDetailsService {
	
	@Autowired
	private GroupMemberDetailsRepository gdr;


	@Override
	public int updaterecordgroupmember(double groupmemid, String enable, double groupid, Date modifieddate,
			String modifiedby) {
		
		return gdr.updaterecordgroupmember(groupmemid, enable, groupid, modifieddate, modifiedby);
	}

	@Override
	public int insertrecordgroupmember(double groupid, String username, String enable, Date creationdate,
			String createdby) {
		
		return gdr.insertrecordgroupmember(groupid, username, enable, creationdate, createdby);
	}

}
