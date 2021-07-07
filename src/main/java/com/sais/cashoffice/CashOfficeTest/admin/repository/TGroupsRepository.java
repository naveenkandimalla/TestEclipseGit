package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.TGroups;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface TGroupsRepository  extends JpaRepository<User,Long>{
	
	
	@Query(value="select ID,GROUP_NAME,GROUP_DESC,CREATION_DATE,CREATED_BY,MODIFIED_DATETIME,MODIFIED_BY from T_GROUPS",nativeQuery=true)
	List<Object[]> getallgroupsdetails();

}
