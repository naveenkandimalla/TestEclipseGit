package com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.MisallocationsCorrection.Model.MisallocationHdr;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface MisallocationHdrRepository extends JpaRepository<User,Integer>{

   
	// use for inserting the record into misallocation hdr 
	
	@Query(value="call pe_Pol_Misallocation_Hdr(?1,?2,?3, ?4, ?5,?6,?7)",nativeQuery=true)
	int misallochdrnewrecord(BigDecimal totalreversalamount,BigDecimal totalamount,String postingstatus,Date creationdate,String createdby,Date modificationdate,String modifiedby);
	

	
	@Query(value="call updateT_POL_MISALLOCATION_HDR(?1,?2,?3, ?4, ?5)",nativeQuery=true)
	double misallochdrupdaterecord(double misallocahdrid
			                       ,BigDecimal totalreversalamount,
			                       BigDecimal totalamount,
			                       Date modificationdate,
			                       String modifiedby);
	


	 @Query(value="call updatePostingStatusMisallocation(?1,?2,?3)",nativeQuery=true)
     Object misallocationpostingstatus(double misallocationhdrid,String postedby,Date postingDate);	
	
	
}
