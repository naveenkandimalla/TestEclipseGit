package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.BranchModel;

@Repository
public interface BranchModelRepository extends  JpaRepository<BranchModel,Double> {

	@Query(value="select branch_name from VW_BRANCH where branch_code in(select BRANCH_CODE from USERS where USERNAME=?1)",nativeQuery=true)
	public String ftechbranchname(String username)
	;
}
