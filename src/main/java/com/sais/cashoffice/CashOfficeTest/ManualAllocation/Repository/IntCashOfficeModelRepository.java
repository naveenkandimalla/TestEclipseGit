package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface IntCashOfficeModelRepository extends JpaRepository<User,Double> {
	
	
	
	@Query(value="call insertnewrecordtoT_int_cash_office(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10) ",nativeQuery=true)
	public double insertrecordintotintcashoffice(double receiptnumber,
			                                      String paymentfor,
			                                      Date duedate,
			                                      BigDecimal partyid,
			                                      BigDecimal allocatedamount,
			                                      int currency,
			                                      char status,
			                                      Date creationdate,
			                                      String createdby,
			                                      String policycode);

	
	// updating t_pol_manual_todet posting status and posting date
	
	
	
}
