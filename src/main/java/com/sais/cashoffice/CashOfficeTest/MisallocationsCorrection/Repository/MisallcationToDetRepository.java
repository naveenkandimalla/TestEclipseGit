package com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.MisallcationToDet;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface MisallcationToDetRepository extends JpaRepository<User,Integer> {

	
	@Query(value="call pe_Get_To_Misallcation_Det(?1)",nativeQuery=true)
	List<Object[]> getallMisallcationToDet(double misallocatedid);
	
	
	
	
	 // inserting the record into T_POL_MISALL_TO_DET
	@Query(value="call pe_Pol_Misalloc_To_Det(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15)",nativeQuery=true)
	double misalltoderecord(double misallid,
			                 String policycode,
			                 Date period,
			                 String policystatus,
			                 BigDecimal amount,
			              String payourname,
			              String postingstatus,
			              String purpose,
			              double partyid,
			              double policyid,
			              String receiptno,
			              Date creationdate
			              ,String createdby,
			              Date modifieddate
			              ,String modifiedby);
	
	
	
	
	
	
	
	
}
  

 

  