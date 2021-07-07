package com.sais.cashoffice.CashOfficeTest.master.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TCashOffApp;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOfficeCashier;

@Repository
public interface CashOfficeAppRepository extends JpaRepository<TCashOffApp, Long>{
	
	@Query(
			value="select * from T_CASH_OFF_APP where cash_office_id=:coId",
			nativeQuery=true)
	List<TCashOffApp> findByCashOfficeId(@Param(value = "coId")long cashOfficeId);
	
	
	@Query(
			value="select max(CASH_OFFICE_ID) from T_CASH_OFFICE ",
			nativeQuery=true)
	public long findMaxCashOfficeId();	
	
	
	@Query(
			value="select max(CO_APP_ID) from T_CASH_OFF_APP ",
			nativeQuery=true)
	public double findMaxCashOfficeAppId();	
	
	@Query(value=" SELECT CASH_OFFICE_CODE, CASH_OFFICE_DESC, BRANCH_CODE, COMPANY_NAME, CASH_OFFICE_ID  FROM T_CASH_OFFICE " + 
	     	 	 " LEFT OUTER JOIN T_COMPANY_ORGAN ON BRANCH_CODE=ORGAN_CODE ORDER BY CASH_OFFICE_CODE"  ,nativeQuery=true)
	public List<Object[]> getCashOfficeDtls();	
	
	@Query(value="select * from T_CASH_OFF_APP WHERE APP_ID=?1 and cash_office_id=?2",nativeQuery=true)
	public List<TCashOffApp> findByAppIdAndCashOfficeId(long appId,long cashOfficeId);
	
	@Transactional
	@Modifying
	@Query(value="insert into T_CASH_OFF_APP(CO_APP_ID,CASH_OFFICE_ID,APP_ID,START_DATE,END_DATE,CREATION_DATE,CREATED_BY)values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery=true)
    public int insertrecordT_CASH_OFF_APP(double coAppID,double cashofficeid,double appid,Date startdate,Date enddate,Date creationdate,String createdby);
	
	@Transactional
	@Modifying
	@Query(value="update T_CASH_OFF_APP  set START_DATE=?1,END_DATE=?2,MODIFIED_DATETIME=?3,MODIFIED_BY=?4 where CO_APP_ID=?5",nativeQuery=true)
    public int updaterecordT_CASH_OFF_APP(Date startdate,Date enddate,Date modifiedDate,String modifiedby,long CO_APP_ID);
}
