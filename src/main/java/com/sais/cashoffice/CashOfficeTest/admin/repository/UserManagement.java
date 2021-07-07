package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;



@Repository  
public interface UserManagement extends JpaRepository<User,Double>{
	
	 @Query(value = "select * from USERS",nativeQuery=true)
	 List<User> findAll();
	
    @Query(value = "select * from USERS  Where FIRST_NAME=?1",nativeQuery=true)
    User findByFirstName(String userFirstName);
    
    @Query(value = "call updateUserTable(?1,?2,?3,?4,?5,?6,?7,?8)  ",nativeQuery=true)
    int update(String firstname,
    		String lastname,String Username,int enable,String modifiedby,Date modifieddate,double userid,String branchcode);
    
    @Query(value = "call insertnewrecordUSERS(?1,?2,?3,?4,?5,?6,?7,?8)  ",nativeQuery=true)
    int saverecorduser(String firstname,
    		String lastname,String Username,String password,Date creationdate,String createdby,int enable,String branchcode);
    
}
