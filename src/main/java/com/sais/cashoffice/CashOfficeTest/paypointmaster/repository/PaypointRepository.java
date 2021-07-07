package com.sais.cashoffice.CashOfficeTest.paypointmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sais.cashoffice.CashOfficeTest.entities.TPayPoint;

public interface PaypointRepository extends JpaRepository<TPayPoint,Long>
{
	TPayPoint findByPayPointId(long id);
	
	@Query(value="select PAY_POINT_NAME from T_PAY_POINT where PAY_POINT_ID=?1",nativeQuery=true)
	public String fetchpaypointname(double paypointid);
}
