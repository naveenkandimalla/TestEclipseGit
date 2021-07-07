package com.sais.cashoffice.CashOfficeTest.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface PasswordResetRepository extends JpaRepository<User,Long> {

	@Query(value ="select * from USERS where USERNAME=?1",nativeQuery = true)
	User findByUsername(String username);
	
	
	// updating password
	
	@Query(value ="call updateUSER(?1,?2,?3)",nativeQuery = true)
	public Object updatepassword(String username,String password,double userid);
	
}
