package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.BankDetailsModel;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetailsModel,Double> {
	
	@Query(value="SELECT * FROM VW_BANK",nativeQuery=true)
	List<BankDetailsModel> getbankdetails();

	
	
		
	


}
