package com.sais.cashoffice.CashOfficeTest.paypointmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sais.cashoffice.CashOfficeTest.entities.TApplicRefValue;
import com.sais.cashoffice.CashOfficeTest.entities.TApplicRefValuePK;

public interface TApplicRefValueRepository extends JpaRepository<TApplicRefValue,TApplicRefValuePK> {

	//public List<TApplicRefValue>  findByIdDomainCode(String domaincode);
	
	@Query(value="select * from T_APPLIC_REF_VALUES where DOMAIN_CODE=?1 ",nativeQuery=true)
	public List<TApplicRefValue>  findfilednames(String domaincode);
}
