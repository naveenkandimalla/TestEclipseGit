package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;



@Repository
public interface TranscationTypeBKdesRespository extends JpaRepository<User,Double> {
	
	
	@Query(value="select BK_TRANSACTION_CODE,BK_TRANSACTION_DESC from T_BK_TRANSACTION_TYPES",nativeQuery=true)
	public List<Object[]>  gettranscationtypesbankcodedesc();

}
