package com.sais.cashoffice.CashOfficeTest.master.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TAppActivity;
import com.sais.cashoffice.CashOfficeTest.master.model.AppActivitiesForm;

@Repository
public interface ApplicationActivitiesRepository extends JpaRepository<TAppActivity, Long> {

	@Query(value = "select taa.enabled,taa.APP_ACTIVITY_ID,taa.APP_ID,taa.APP_ACTIVITY_CODE,taa.APP_ACTIVITY_DESC "
			+ "FROM cash_office.T_APP_ACTIVITY taa,cash_office.T_APPLICATION ta "
			+ " where ta.app_id=taa.app_id and ta.APP_ID=:appId ",nativeQuery=true)
	public List<Object[]> findByAppCode(@Param(value = "appId") int appId);
	
	
	@Query(value="call pe_Update_ApplicationActivity(?1,?2,?3,?4,?5,?6)",nativeQuery=true)
	public List<Object[]> updatetappactivity(int appactivityid,String activitycode,String appactdesc,char enable,Date modifieddate,String modifiedby);

}
 