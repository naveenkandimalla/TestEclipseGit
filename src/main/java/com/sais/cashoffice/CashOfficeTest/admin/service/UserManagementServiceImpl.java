package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.BranchCode;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;
import com.sais.cashoffice.CashOfficeTest.admin.repository.UserManagement;

import com.sais.cashoffice.CashOfficeTest.admin.repository.BranchNameRepository;

@Service
public class UserManagementServiceImpl implements UserManagementService  {
	
	@Autowired
	private UserManagement usermanagementRepo;
	
	@Autowired 
	private BranchNameRepository branchNameRepo;

	@Override
	public List<User> getallusers() {
		return usermanagementRepo.findAll();
	}




	@Override
	public User getUserDetailsByName(String name) {
		
		return usermanagementRepo.findByFirstName(name);
	}


	@Override
	public List<BranchCode> getallbranchnames() {
		// TODO Auto-generated method stub
		return branchNameRepo.findAll();
	}


	@Override
	public int update(String firstname,String lastname,String Username,int enable,String modifiedby,Date modifieddate,double userid,String branchcode) {
		
		return usermanagementRepo.update(firstname, lastname, Username, enable, modifiedby, modifieddate,userid,branchcode);
	}


	@Override
	public int saverecorduser(String firstname, String lastname, String Username, String password, Date creationdate,
			String createdby, int enable, String branchcode) {
		
		return usermanagementRepo.saverecorduser(firstname, lastname, Username, password, creationdate, createdby, enable, branchcode);
	}


	




	

}
