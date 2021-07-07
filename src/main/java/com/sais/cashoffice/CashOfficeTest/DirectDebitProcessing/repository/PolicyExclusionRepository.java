package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository;

import java.math.BigDecimal;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TBankStmtHdr;


@Repository
public interface PolicyExclusionRepository  extends JpaRepository<TBankStmtHdr,Long> {
	
	
	@Query(value="call insertrecordT_BK_STMT_DET_EXCLUSIONS(?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery=true)
	public double insertrecordpe(double bankstmtid,Date period,String policycode,String payour,
			                      String policystatus,BigDecimal exceptedpermim,Date craetiondate,String createdby,
			                      BigDecimal allocatedamout);
	@Modifying
	@Transactional
	@Query(value="delete from T_BK_STMT_DET_EXCLUSIONS where BK_STMT_DET_EXCL_ID=?1",nativeQuery=true)
	public int deleterecordtbkdetexclusion(double bkdetstmtexclusionid);

}
