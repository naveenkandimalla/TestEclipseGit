package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

public interface PageAccessMasterRepository   extends JpaRepository<User,Long> {
	

    
	@Query(value="Select PAGEACCESS_ID,COMMENTS,CREATED_BY,CREATION_DATE,MODIFIED_BY,MODIFIED_DATETIME,SCREEN_CODE,SCREEN_DESC,URL,MODULE_ID,ENABLED from T_PAGEACCESS_MASTER",nativeQuery=true)
	public List<Object[]> getpageaccessMasterdetails();
	

	
	@Query(value="call insertrecordT_PAGEACCESS_MASTER(?1,?2,?3,?4,?5,?6,?7) ",nativeQuery=true)
	public Object insertrecordpageaccessmaster(String screencode,String screendesc,
			                                   String url,double mouldid, Date creationdate,String createdby,char enabled);
	
	
	@Query(value="call updaterecordT_PAGEACCESS_MASTER(?1,?2,?3,?4,?5,?6,?7,?8) ",nativeQuery=true)
	public Object updaterecordpageaccessmaster(double pageaccessid,String screencode,String screendesc,
			                                   String url,double mouldid, Date modifiteddate,String modifiedby,char status);

}
