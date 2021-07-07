package com.sais.cashoffice.CashOfficeTest.SpringSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.SpringSecurity.Model.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Integer> {
	
   @Query(value="SELECT * FROM USERS where USERNAME=?1",nativeQuery=true)	
   Optional<User> finduserName(String username);
   
   @Query(value="Select USER_ID from USERS where USERNAME=?1",nativeQuery=true)
   double finduserid(String username);
   
   @Query(value="select ga.AUTHORITY from "
			+ "GROUP_MEMBERS gm,GROUP_AUTHORITIES ga,USERS u where gm.USERNAME=u.USERNAME "
			+ "and gm.GROUP_ID= ga.GROUP_ID and gm.ENABLED=1 and ga.ENABLED=1 and u.USERNAME=?1",nativeQuery=true)
	List<String> fetchRolesForLoginUser(String username);
}
