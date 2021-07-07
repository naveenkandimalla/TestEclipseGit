package com.sais.cashoffice.CashOfficeTest.master.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TCashOffPymtMthd;

@Repository
public interface CashOffPymtMethodRepository extends JpaRepository<TCashOffPymtMthd,Long> {

	@Query(
			value="select * from T_CASH_OFF_PYMT_MTHD where cash_office_id=:coId",
			nativeQuery=true)
	List<TCashOffPymtMthd> findByCashOfficeId(@Param(value="coId") long cashOfficeId);
	
	@Query(
			value="select * from T_CASH_OFF_PYMT_MTHD where PAY_METHOD_ID=?1  AND cash_office_id=?2",
			nativeQuery=true)
	List<TCashOffPymtMthd> findByPymtMethodIdAndCashOfficeId(long PymtMethodId,long cashOfficeId);
	
	@Transactional
	@Modifying
    @Query(value="insert into T_CASH_OFF_PYMT_MTHD(CO_PYMT_MTHD_ID,CASH_OFFICE_ID,PAY_METHOD_ID,START_DATE,END_DATE,CREATION_DATE,CREATED_BY)values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery=true)
    public int insertrecordT_CASH_OFF_PYMT_MTHD(double CO_PYMT_MTHD_ID, double cashofficeid,double paymethodid,Date startdate,Date enddate,Date createddate,String createdby);

	@Transactional
	@Modifying
    @Query(value="update T_CASH_OFF_PYMT_MTHD set START_DATE=?1,END_DATE=?2,MODIFIED_DATETIME=?3,MODIFIED_BY=?4 where CO_PYMT_MTHD_ID=?5",nativeQuery=true)
    public int updateRecordT_CASH_OFF_PYMT_MTHD(Date startdate,Date enddate,Date modifiedDate,String modifiedby,long cashOffPyMtID);


}
