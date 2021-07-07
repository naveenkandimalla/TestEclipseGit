package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model.ManualAllocationHdr;
import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface ManualAllocationHdrRepository extends JpaRepository<User,Double> {
	
	
	@Query(value="call insertrecordtoT_POL_MANUAL_HDR(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery=true)
	public int insertintomanualallochdr(double receiptno,BigDecimal totalallocatedamount,
			                           BigDecimal totalunallocatedamount,BigDecimal totalpoliciesamount,
			                           Date creationdate,String createdby,
			                           Date modifieddate,String modifiedby,
			                           String attribute,String bankstmtflag,String postingstatus);
	
	
	@Query(value="call deletemanualallocationrecord(?1,?2,?3,?4,?5,?6,?7)",nativeQuery=true)
	public Object deletemanualallocationtodetrecord(double manualhdrid,double manualtodelid,BigDecimal totalallocatedamount,
			                                    BigDecimal totalunallocatedamount,BigDecimal totalpoliciesamount,
			                                    String modifiedby,Date modifieddate);

	
	@Query(value="select (MANUAL_ALL_HDR_ID) from  T_POL_MANUAL_HDR where RECEIPT_NO=?1",nativeQuery=true)
	public Object getmanualhdrid(double receipt);
	
	
	@Query(value="select ALLOCATED_AMOUNT,UNALLOCATED_AMOUNT,PAYPOINT_ID,PERIOD,GROSS_AMOUNT,RECEIPT_AMOUNT,POSTING_STATUS from  T_POL_MANUAL_FROM_DTL where MANUAL_ALL_HDR_ID=?1",nativeQuery=true)
	public List<Object[]> fetchmanualhdrdetails(double receipt);
	
	@Query(value="call updateT_POL_MANUAL_HDR(?1,?2,?3,?4,?5,?6)",nativeQuery=true)
	public Object updatetpomanualhdr(double manualhdrid,BigDecimal totalallocatedamount,
            BigDecimal totalunallocatedamount,BigDecimal totalpoliciesamount,
            String modifiedby,Date modifieddate);
	
	@Transactional
	@Modifying()
	@Query(value="Update T_POL_MANUAL_HDR set POSTING_STATUS='P',POSTED_BY=?2,POSTING_DATETIME=?3 where MANUAL_ALL_HDR_ID=?1",nativeQuery=true)
	public int updatedpostingstatus(double manualhdrid,String postedby,Date posteddate);
	
}
