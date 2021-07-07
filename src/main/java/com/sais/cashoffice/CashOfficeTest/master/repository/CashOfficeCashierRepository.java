package com.sais.cashoffice.CashOfficeTest.master.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sais.cashoffice.CashOfficeTest.entities.TCashOffice;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOfficeCashier;

@Repository
@Transactional
public interface CashOfficeCashierRepository extends JpaRepository<TCashOfficeCashier, Long> {

	@Query(value = "select * from T_CASH_OFFICE_CASHIER where CASH_OFFICE_ID=:coId ", nativeQuery = true)
	public List<TCashOfficeCashier> findByCashOfficeId(@Param(value = "coId") long cashOfficeId);

	public List<TCashOfficeCashier> findByCashier_CashierIdAndCashOffice_CashOfficeId(long cashierId,long cashOfficeId);
	
	
	@Query(value = "select max(CO_CASHIER_ID) from T_CASH_OFFICE_CASHIER", nativeQuery = true)
	public long findMaxCashOfficeCashierId();
	

	@Transactional
	@Modifying()
	@Query(value = "update T_CASH_OFFICE_CASHIER set END_DATE =?1,SENIOR_CASHIER_YN=?2,MODIFIED_DATETIME=?3,MODIFIED_BY=?4 where CO_CASHIER_ID=?5", nativeQuery = true)
	public int updateEnddate(Date enddate,String seniorCashier,Date modifieddate,String modifiedby, int coCashierId );
}
