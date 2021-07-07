package com.sais.cashoffice.CashOfficeTest.transaction.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TPaymentTpp;

@Repository
public interface PaymentReceiptRepoTpp extends JpaRepository<TPaymentTpp, Long> {
	
	@Query(value = "call PE_RCPT_ALLOCATION_THITO_PP(?1,?2,?3,?4,?5,?6,?7)",nativeQuery=true)
	double insertTppDetails(double p_rcpt_all_id,double P_App_Activity_id,Date p_Period,
		int	p_Pay_point_id,double p_gross_amt,double p_All_Amt,String createdby);	


}
