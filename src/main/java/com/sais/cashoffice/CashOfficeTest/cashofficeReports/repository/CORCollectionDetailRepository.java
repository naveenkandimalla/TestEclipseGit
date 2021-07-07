package com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.sais.cash.entities.CashierAssignment;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CORCollectionDetail;

public interface CORCollectionDetailRepository extends JpaRepository<CORCollectionDetail, Long> {
		
	@Query(value = 
			"SELECT * FROM vw_coldetail WHERE branch_code = :branch_code AND receipt_date BETWEEN DATE(:fromDate) AND DATE(:toDate) order by REceipt_date", 
			nativeQuery = true )
	public List<Object[]> getDetailCollection(@Param("branch_code") String branch_code, 
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value = "SELECT distinct branch_code FROM vw_branch ORDER BY branch_code", nativeQuery = true )
	public List<Object> getBranchCodes() ;
	
}