package com.sais.cashoffice.CashOfficeTest.PartialMisallocationsCorrection.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface MisallocpartialhdrRepository extends JpaRepository<User,Integer>{
	
	
	
	
	 @Query(value="call pe_Partial_Misallocation_Hdr(?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery=true)
		int insertnewrecordmisallpartialhdr(double totalrevamount,double totalamount,
				                             String transcationtype,String postingstatus,Date creationdate,
				                             String createdby,Date modifieddate,String modifiedby);
	 
	 
	 @Query(value="call UpdateT_POL_PARTIAL_MISALLOC_HDR(?1,?2,?3,?4,?5)",nativeQuery=true)
	 Object updatepolpartialmisallocationhdr(double hdrid,String transcationtype,double allocatedamount,String modifiedby,Date modifieddate);
	 
	 @Query(value="call UpdatePostingStatusT_POL_PARTIAL_MISALLOC_HDR(?1,?2,?3)",nativeQuery=true)
	 Object updatepostingstatuspartialmisallochdr(String postedby,Date postingdate,double hdrid);
	 
	 
	 
	 @Query(value="call upatepostingstatuspartialmisallocationPremium(?1,?2,?3)",nativeQuery=true)
	 Object updatepostingstatusPremium(String postedby,Date postingdate,double hdrid);

	 @Query(value="call upatepostingstatuspartialmisallocationReverse(?1,?2,?3)",nativeQuery=true)
	 Object updatepostingstatusReverse(String postedby,Date postingdate,double hdrid);
}
