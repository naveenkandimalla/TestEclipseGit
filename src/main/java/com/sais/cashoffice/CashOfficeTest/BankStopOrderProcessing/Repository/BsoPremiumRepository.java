package com.sais.cashoffice.CashOfficeTest.BankStopOrderProcessing.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface BsoPremiumRepository extends JpaRepository<User,Double> {
	
	
	// used for fetching  bso premium details
	@Query(value="call p_get_bso_premium(?1)",nativeQuery=true)
	List<Object[]> getbsopremiumdetails(double bankstmthdrid);
	
	
	
	@Query(value="call pe_insert_to_bsopremium(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery=true)
	int insertintobsopremium(double bankstmthdrid,
			                 String transcationtype,
			                 Date period,
			                 String policycode,
			                 String policystatus,
			                 String payor,
			                 BigDecimal exceptedpremium,
			                 BigDecimal allocatedamount,
			                 Date creationtime,
			                 Date modifiedtime);
	
	// deleting the record from bso premium
	@Modifying
	@Transactional
	@Query(value="delete from T_BK_STMT_BSO_PREMIUM where BK_STMT_DET_BSO_ID=?1",nativeQuery=true)
	int deletebsopremiumrecord(double bsoid);

}
