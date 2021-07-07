package com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CORCollectionSummary;

public interface CORCollectionSummaryRepository extends JpaRepository<CORCollectionSummary, Long> {
		
	@Query(
			value = "SELECT row_number() OVER ()  AS 'id', " + 
					"						co.branch_code," + 
					"						br.branch_name," + 
					"						COUNT(re.receipt_no) receipt_count," + 
					"						re.pay_method_id " + 
					"					    , pm.pay_method_code " + 
					"					    , pm.pay_method_desc" + 
					"					    , ra.app_id " + 
					"					    , ap.app_code " + 
					"					    , ap.app_desc " + 
					"					    , SUM(ra.allocated_amount) allocated_amount" + 
					"					    , re.receipt_date " + 
					"                        FROM T_RECEIPT re " + 
					"					         , T_PAYMENT_METHODS pm " + 
					"					          , T_RCPT_ALLOCATION ra  " + 
					"					          , T_APPLICATION ap " + 
					"					           , T_CASH_OFFICE co " + 
					"					            , vw_branch br " + 
					"					             WHERE re.pay_method_id = pm.pay_method_id " + 
					"					               AND re.rcpt_trn_id = ra.rcpt_trn_id " + 
					"					               AND ra.app_id = ap.app_id  " + 
					"					               AND re.cash_office_id = co.cash_office_id " + 
					"					               AND co.branch_code = br.branch_code " + 
					"			                       AND re.receipt_date BETWEEN DATE(:fromDate) AND DATE(:toDate) " + 
					"					               AND co.branch_code =:branch_code "+
					"                                   group by co.branch_code," + 
					"						                     br.branch_name," + 
					"                                             re.receipt_no," + 
					"						                     re.pay_method_id " + 
					"					                        , pm.pay_method_code " + 
					"					                        , pm.pay_method_desc " + 
					"					                        , ra.app_id " + 
					"					                        , ap.app_code " + 
					"					                        , ap.app_desc " + 
					"					                        , ra.allocated_amount" + 
					"					                         , re.receipt_date ",
					nativeQuery = true )
	public List<Object[]> getSummaryCollection(@Param("branch_code") String branch_code, 
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	// move this to a abstract parent class
	@Query(value = "SELECT distinct branch_code FROM vw_branch ORDER BY branch_code", nativeQuery = true )
	public List<Object> getBranchCodes() ;
	
}