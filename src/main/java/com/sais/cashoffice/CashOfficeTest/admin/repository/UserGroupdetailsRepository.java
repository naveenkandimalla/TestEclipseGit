package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface UserGroupdetailsRepository extends JpaRepository<User,Long> {
	
//	SELECT usr.USER_ID, usr.USERNAME, usr.FIRST_NAME, usr.LAST_NAME,
//	gm.GROUP_MEM_ID, gm.GROUP_ID, gm.ENABLED, g.GROUP_NAME, g.GROUP_DESC
//		FROM GROUP_MEMBERS gm LEFT JOIN USERS usr on gm.USERNAME = usr.USERNAME,
//			T_GROUPS g WHERE gm.GROUP_ID = g.ID AND gm.USERNAME = ?!
	
	@Query(value = "SELECT usr.USER_ID, usr.USERNAME, usr.FIRST_NAME, usr.LAST_NAME,"
			+ "gm.GROUP_MEM_ID, gm.GROUP_ID, gm.ENABLED, g.GROUP_NAME, g.GROUP_DESC"
			+" FROM GROUP_MEMBERS gm LEFT JOIN USERS usr on gm.USERNAME = usr.USERNAME,"
			+"T_GROUPS g WHERE gm.GROUP_ID = g.ID AND gm.USERNAME = ?1",nativeQuery=true)
     List<Object[]> getusergroupdetails(String username);
}
