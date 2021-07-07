package com.sais.cashoffice.CashOfficeTest.paypointReports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sais.cashoffice.CashOfficeTest.paypointReports.entities.StatementAllocation;

public interface StatementAllocationRepository extends JpaRepository<StatementAllocation, Long> {
		
	@Query(value="call prd_bank_statement_allocation(:ppid, :bnk_stmt_id)", nativeQuery=true )
	public List<StatementAllocation> getStatementAllocations(@Param("ppid") String ppid, @Param("bnk_stmt_id") String bnk_stmt_id ) ;
	
}
