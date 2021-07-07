package com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Repository;

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
public interface ReallocationDetailsRepository extends JpaRepository<User,Double> {
	
	@Query(value=" call pe_get_bsav_reallocations_by_stmt_id(?1)",nativeQuery=true)
	List<Object[]> getreallocationdetails(double bankstmtid);
	
	// insert record into interface table
	@Query(value="call Insert_InterfaceTable_T_BK_STMT_TO_REALLOCATION_DE(?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery=true)
	int insertrecordinterfacetable(double bankstmtid,String applicationcode,String Transcationcode,String cashiername,
			                       Date creationdate,String createdby,char postingstatus,double bktoreallocid,BigDecimal amount);

	// used for updating posting status the record 
	@Query(value="call Update_T_BANK_STMT_REALLOCATION(?1,?2,?3,?4)",nativeQuery=true)
	int updatepostingstatusbkstmtrealloc(double bkstmtreallocid,char postingstatus,String postedby,Date posteddate );
}
