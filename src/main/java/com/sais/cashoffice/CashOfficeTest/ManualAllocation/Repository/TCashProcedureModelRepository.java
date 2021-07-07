package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface TCashProcedureModelRepository extends JpaRepository<User,Double> {
	

	
	@Query(value="call insertnewrecordintoT_cash(?1,?2,?3,?4)",nativeQuery=true)
	public double insertrecordinotcash(
			String policycode,
			 BigDecimal feeamount,
			 double receiptno,
			 String loginidname,
			 BigDecimal payamount,
			 String purposeid,
			 BigDecimal partyid,
			 String insertedby,
			 String updatedby,
			 BigDecimal paybalance
			
			);
	
	   

}
