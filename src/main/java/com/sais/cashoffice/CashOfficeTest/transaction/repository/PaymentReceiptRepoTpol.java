package com.sais.cashoffice.CashOfficeTest.transaction.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TPaymentTpol;

@Repository
public interface PaymentReceiptRepoTpol extends JpaRepository<TPaymentTpol, Long> {
	
	@Query(value = "call PE_RCPT_ALLOCATION_THITO_POL(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery=true)
	double insertTpolDetails(double p_rcpt_all_id,double P_App_Activity_id,
			                 Date p_Period,String p_Policy_code,String p_Policy_Status,
	                          String p_Payor,BigDecimal p_Arrears_Amount,
	                          BigDecimal p_Expected_Amt,
	                          BigDecimal p_All_Amt,String createdby,LocalDate createdDate);	

}
