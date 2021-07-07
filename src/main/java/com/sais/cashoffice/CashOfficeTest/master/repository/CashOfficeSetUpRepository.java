package com.sais.cashoffice.CashOfficeTest.master.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sais.cashoffice.CashOfficeTest.entities.TCashOffice;
import com.sais.cashoffice.CashOfficeTest.master.model.CashOfficeDetForm;

@Repository
public interface CashOfficeSetUpRepository extends JpaRepository<TCashOffice, Long>{

	TCashOffice findByCashOfficeCode(String cashOfficeCode);

	TCashOffice findByCashOfficeId(long cashofficeId);

	TCashOffice findByCashOfficeCodeAndBranchCode(String cashOfficeCode, String branchCode);
	
	
	@Query(value =" select max(cash_office_id) from T_CASH_OFFICE",nativeQuery=true)
	public double cashOfficeId();
    
	@Transactional
	@Modifying
	@Query(value="update T_CASH_OFFICE set CASH_OFFICE_CODE=?1,CASH_OFFICE_DESC=?2,BRANCH_CODE=?3,MODIFIED_DATETIME=?4,MODIFIED_BY=?5 where CASH_OFFICE_ID=?6",nativeQuery=true)
	public int updatetcashoffice(String code,String desc,String branchcode,Date modifieddate,String modifiedby, double cashofficeid);


}
