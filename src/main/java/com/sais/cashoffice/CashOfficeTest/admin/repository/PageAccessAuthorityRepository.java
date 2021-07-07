package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface PageAccessAuthorityRepository  extends JpaRepository<User,Long> {
	
	
	@Query(value="Select PAGEACCESS_ROLE_ID,AUTHORITY,COMMENTS,CREATED_BY,CREATION_DATE,ENABLED,MODIFIED_BY,MODIFIED_DATETIME,PAGEACCESS_ID from T_PAGEACCESS_AUTHORITIES",nativeQuery=true)
	public List<Object[]> getpageaccessAuthoritydetails();
	
	
	
	@Query(value="call insertrecordT_PAGEACCESS_AUTHORITIES(?1,?2,?3,?4,?5) ",nativeQuery=true)
	public Object insertrecordpageaccessauthority(String authority,char enable,
			                                        double pageaccessid,Date creationdate,
			                                        String createdby);
	
	
	@Query(value="call updateT_PAGEACCESS_AUTHORITIES(?1,?2,?3,?4,?5,?6) ",nativeQuery=true)
	public Object updaterecordT_PAGEACCESS_AUTHORITIES(double pageaccessid,String authority,
			                                        Date modifieddate,char enable,
			                                        String modifiedby,double pageaccessrole);
	
}

