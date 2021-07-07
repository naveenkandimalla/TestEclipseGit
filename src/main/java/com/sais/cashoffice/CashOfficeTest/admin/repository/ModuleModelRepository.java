package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface ModuleModelRepository extends JpaRepository<User,Long>{
	
	
	@Query(value="Select MODULE_ID,MODULE_CODE,MODULE_DESC,CREATION_DATE,CREATED_BY,MODIFIED_DATETIME,MODIFIED_BY,COMMENTS from T_MODULES ",nativeQuery=true)
	public List<Object[]> getModuledetails();

}
