package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TBankStmtHdr;

@Repository
public interface ReversalRepository extends JpaRepository<TBankStmtHdr,Long>{
	
	  @Query(value=" SELECT   trev.BK_STMT_DET_REV_ID," 
		   		+ "trev.BK_TRANSACTION_TYPE    revTransactionType,"  
		   		+ "trev.PERIOD_FOR_REVERSALS," 
		   		+ "trev.POLICY_CODE,"  
		   		+ "trev.PAYOR,"  
		   		+ "trev.POLICY_STATUS_ID," 
		   		+ "trev.EXPECTED_PREMIUM," 
		   		+ "trev.ALLOCATED_AMOUNT,trev.BANK_STMT_ID"  
		   		+ " FROM T_BANK_STMT_HDR bks"  
		   		+ " LEFT JOIN(T_BK_STMT_DET_REVERSALS trev" 
		   		+ " INNER JOIN T_BK_TRANSACTION_TYPES trevtr"
		   		+ "    ON trev.BK_TRANSACTION_TYPE = trevtr.BK_TRANSACTION_CODE) ON bks.BANK_STMT_ID = trev.BANK_STMT_ID,"  
		   		+ "    T_APPLIC_REF_VALUES refVal, VW_BANK_ACCOUNTS_INFO vwbai"  
		   		+ "     WHERE bks.BANK_STMT_ID =?1" 
		   		+ "      AND bks.POSTING_STATUS = refVal.VALUE_CODE"  
		   		+ "      AND refVal.VALUE_CODE = bks.POSTING_STATUS"  
		   		+ "      AND vwbai.cash_account_id = bks.ACCOUNT_ID",nativeQuery=true)
		   List<Object[]> getalldetailsDetReversals(double sr);

	
		   @Query(value="call insertT_BK_STMT_DET_REVERSALS(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery=true)
		   int reversalrecordinsert(String createdby,double stmtid,String transcationtype,
				                        Date period,String policycode,String payor,
				                        String policystatus,BigDecimal exceptedamount,
				                        BigDecimal allocatedamount,Date creationdate);

		   
		   @Query(value="select max(BK_STMT_DET_REV_ID) from T_BK_STMT_DET_REVERSALS",nativeQuery=true)
		   double getmaxofdetreversals();
		   
		  
		   @Modifying
			@Transactional
		   @Query(value="delete from T_BK_STMT_DET_REVERSALS where BK_STMT_DET_REV_ID=?1 ",nativeQuery=true)
		   int deletereversalrecord(double reversalid);
}
