package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.AccountsInfo;


@Repository
public interface AccountInfoRepository extends JpaRepository<AccountsInfo,Double> {
	
	// fetch account details using bank code
		@Query(value="select * from VW_BANK_ACCOUNTS_INFO where parent_bank = ?1",nativeQuery=true)
	    List<AccountsInfo> findaccountdetails(String parentbankid);
}
