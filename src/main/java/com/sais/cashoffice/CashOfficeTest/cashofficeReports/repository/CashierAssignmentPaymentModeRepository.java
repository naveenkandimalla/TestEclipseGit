package com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CashierAssignPaymentMode;

@Repository
public interface CashierAssignmentPaymentModeRepository extends JpaRepository<CashierAssignPaymentMode,Long> {

	// Payment Method Repository with both fields filled
		@Query(nativeQuery = true, value = "select distinct pay_method_code,cash_office_code,pay_method_desc,pay_start_date,pay_end_date,cash_office_desc,branch_name from v_cashierassignment "
				+ " where branch_code=:branch_code AND cash_office_code=:cash_office_code"
				+ " group by pay_method_code,cash_office_code,pay_method_desc,pay_start_date,pay_end_date,cash_office_desc,branch_name order by cash_office_code")
		List<Object[]> getCa(@Param("branch_code") String branch_code, @Param("cash_office_code") String cash_office_code);

}
