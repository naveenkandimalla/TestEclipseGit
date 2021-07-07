package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface LoginAccessRepository extends JpaRepository<User,Long> {
	
	
	 @Query(value =" SELECT USER_ID, USERNAME, BRANCH_CODE, FIRST_NAME, LAST_NAME, " +
			  " (SELECT CASHIER_ID FROM T_CASHIERS WHERE LOGIN_ID=USERNAME) AS CASHIER_ID"+
			  " FROM USERS WHERE USERNAME=?1 AND PASSWORD=?2",nativeQuery=true)
public List<Object[]> userAuthenticate(String uName, String Pwd);

}
