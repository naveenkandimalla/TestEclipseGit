package com.sais.cashoffice.CashOfficeTest.transaction.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TCashTillActivity1;

@Repository
public interface TillActivityRepository  extends JpaRepository<TCashTillActivity1,Long> {

//	@Query(value = "SELECT " + 
//			"    ca.cashier_name, " + 
//			"    br.branch_name," + 
//			"    co.BRANCH_CODE," + 
//			"    co.cash_office_desc," + 
//			"    coac.status AS cash_office_status," + 
//			"    coac.receipt_date," + 
//			"    coca.cash_office_id," + 
//			"    ca.cashier_id," + 
//			"    ca.cashier_code," + 
//			"    coac.cash_off_activity_id," + 
//			"    cta.cashier_activity_id " + 
//			" FROM " + 
//			"    T_CASH_OFFICE_CASHIER coca," + 
//			"    T_CASH_OFF_ACTIVITY coac," + 
//			"    T_CASH_OFFICE co," + 
//			"    VW_BRANCH br," + 
//			"    T_CASH_TILL_ACTIVITY cta" + 
//			"        LEFT JOIN " + 
//			"    T_CASHIERS ca ON cta.CASHIER_ID = ca.CASHIER_ID " + 
//			" WHERE " + 
//			"    coca.CASHIER_ID = ca.CASHIER_ID " + 
//			"        AND (coca.END_DATE IS NULL " + 
//			"        OR coca.END_DATE >= SYSDATE()) " + 
//			"        AND coca.CASH_OFFICE_ID = co.CASH_OFFICE_ID " + 
//			"        AND co.CASH_OFFICE_ID = coac.CASH_OFFICE_ID " + 
//			"        AND coac.status = 'O' " + 
//			"        AND ca.login_id = ?1 " + 
//			" ORDER BY CASHIER_ACTIVITY_ID DESC " + 
//			" LIMIT 1;",nativeQuery=true)  
// this line is removed for fetching existing record    from T_CASH_OFF_ACTIVITY   and coac.CASH_OFFICE_ID =cta.CASH_OFFICE_ID " +   	"cta.cashier_activity_id " + 
	@Query(value=   "  SELECT coac.CASH_OFF_ACTIVITY_ID, " + 
			"                          coac.CASH_OFFICE_ID, " + 
			"                          coac.CASHIER_ID, " + 
			"                          coac.STATUS, " + 
			"                          coac.BRANCH_CODE, " + 
			"                          co.CASH_OFFICE_DESC, " + 
			"                          co.CASH_OFFICE_CODE, " + 
			"                          ca.CASHIER_NAME, " + 
			"                          br.Branch_Name, " + 
			"                          ca.cashier_code " + 
			"                     FROM T_CASH_OFF_ACTIVITY coac, " + 
			"							T_CASH_TILL_ACTIVITY cta, " + 
			"                          T_CASH_OFFICE co, " + 
			"                          T_CASHIERS ca, " + 
			"                          VW_BRANCH  br " + 
			"                    WHERE coac.CASH_OFFICE_ID = co.CASH_OFFICE_ID " + 
			"                      AND coac.CASHIER_ID     = ca.CASHIER_ID " + 
			"                     AND coac.BRANCH_CODE    = br.branch_code " + 
			"                      AND ca.LOGIN_ID         = ?1 order by CASH_OFF_ACTIVITY_ID desc limit 1;"
			,nativeQuery=true)
	public List<Object[]> getCashOffActivityAndCashierDetails(String LId); 
	
	
	@Query(value=   "  SELECT coac.CASH_OFF_ACTIVITY_ID, " + 
			"                          coac.CASH_OFFICE_ID, " + 
			"                          coac.CASHIER_ID, " + 
			"                          coac.STATUS, " + 
			"                          coac.BRANCH_CODE, " + 
			"                          co.CASH_OFFICE_DESC, " + 
			"                          co.CASH_OFFICE_CODE, " + 
			"                          ca.CASHIER_NAME, " + 
			"                          br.Branch_Name, " + 
			"                          ca.cashier_code, " + 
			"                          cta.cashier_activity_id " + 
			"                     FROM T_CASH_OFF_ACTIVITY coac, " + 
			"							T_CASH_TILL_ACTIVITY cta, " + 
			"                          T_CASH_OFFICE co, " + 
			"                          T_CASHIERS ca, " + 
			"                          VW_BRANCH  br " + 
			"                    WHERE coac.CASH_OFFICE_ID = co.CASH_OFFICE_ID " + 
			"                      and coac.CASH_OFFICE_ID =cta.CASH_OFFICE_ID "+
			"                      AND coac.CASHIER_ID     = ca.CASHIER_ID " + 
			"                     AND coac.BRANCH_CODE    = br.branch_code " + 
			"                      AND ca.LOGIN_ID         = ?1 order by CASH_OFF_ACTIVITY_ID desc limit 1;"
			,nativeQuery=true)
	public List<Object[]> getCashTillActivityAndCashOfficeActivityDetails(String LId); 


	@Query(value=
			"select max(cash_off_activity_id) from T_CASH_TILL_ACTIVITY ",nativeQuery=true)
	public int details6();

	@Query(value=
			"select max(cashier_activity_id) from T_CASH_TILL_ACTIVITY ",nativeQuery=true)
	public double details7();

	@Query(value=
			"select cash_office_id from T_CASH_OFFICE where CASH_OFFICE_CODE=?1 ",nativeQuery=true)
	public double getCASH_OFFICE_ID(@Param(value = "Cashofficecode")String Cashofficecode);


	@Query(value=
			"select  TILL_ACTIVITY_STATUS from T_CASH_TILL_ACTIVITY  where CASH_OFF_ACTIVITY_ID=?1 ",nativeQuery=true)
	public char getStatus(@Param(value = "CASH_OFF_ACTIVITY_ID")double cashOffActivityId);


	@Query(value="call sp_get_till_details(?1)",nativeQuery = true)
	public List<Object[]> getTillDetails(@Param(value = "CASHIER_ACTIVITY_ID")double cashierActivityId);

	@Query(value="select  CTA.CASHIER_ACTIVITY_ID,"
			+ " CTA.CASH_OFF_ACTIVITY_ID, "+
			"  CTA.TILL_ACTIVITY_STATUS,"
			+ " CA.CASHIER_NAME,CASHIER_CODE ,"
			+ " CA.LOGIN_ID, "
			+ " CTA.BRANCH_CODE "
			+ "  from T_CASH_TILL_ACTIVITY CTA LEFT  JOIN  T_CASHIERS CA "
			+ "  ON  CTA.CASHIER_ID = CA.CASHIER_ID "
			+ "  WHERE CA.LOGIN_ID =?1 AND CTA.TILL_ACTIVITY_DATE =?2  and CTA.TILL_ACTIVITY_STATUS='C' "
			+ " ORDER BY CTA.CASHIER_ACTIVITY_ID DESC LIMIT 1 ",nativeQuery = true)
	public List<Object[]> findTillDate(String lId,LocalDate date);


	@Query(value= " SELECT  CTA.CASHIER_ACTIVITY_ID,CTA.CASH_OFF_ACTIVITY_ID,CTA.CASH_OFFICE_ID," + 
			" CTA.BRANCH_CODE,CTA.TILL_ACTIVITY_STATUS,CA.CASHIER_ID  "
			+ "  FROM T_CASH_TILL_ACTIVITY CTA LEFT JOIN T_CASHIERS CA ON " + 
			"  CTA.CASHIER_ID=CA.CASHIER_ID  where CA.LOGIN_ID=?1 " + 
			"  order by  CTA.CASHIER_ACTIVITY_ID desc limit 1; ",nativeQuery = true)
	public List<Object[]> findTillStatus(String LId);


}
