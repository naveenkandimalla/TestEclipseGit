package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface AllocationPostingProcedureModelRepository extends JpaRepository<User,Double> {
	
	

	
	@Query(value="call allocationposting(?1,?2,?3,?4)",nativeQuery=true)
	public Object allocatedamountforposting(BigDecimal policyid, Date duetime,double feeid,
				                             double listid
			                                 );
	

}
