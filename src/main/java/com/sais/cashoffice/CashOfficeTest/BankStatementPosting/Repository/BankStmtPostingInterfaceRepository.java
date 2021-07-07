package com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface BankStmtPostingInterfaceRepository extends JpaRepository<User,Double> {

	
	@Query(value="call postingrecordbankstmtposting(?1,?2,?3,?4,?5,?6) ",nativeQuery=true)
	public Object insertrecorbkstmtpostinginferace(double BankStmtId, 
			                                          String transcationcode,
			                                          double Cashierid,
			                                          Date creationdate,
			                                          String createdby,
			                                          char postingstatus); 
	
	@Query(value="select CASHIER_ID from T_CASHIERS where LOGIN_ID=?1 ",nativeQuery=true)
	public double fetchcashierid(String loginname);

}
