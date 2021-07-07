package com.sais.cashoffice.CashOfficeTest.master.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TApplication;
import com.sais.cashoffice.CashOfficeTest.entities.TPaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<TPaymentMethod, Long> {

	public TPaymentMethod findByPayMethodId(long id);

	public TPaymentMethod findByPayMethodCode(String pymtMethodCode);
	
	@Query(
			value="select max(CO_PYMT_MTHD_ID) from T_CASH_OFF_PYMT_MTHD ",
			nativeQuery=true)
	public double findMaxCashOffPymtMthdId();	
	
	@Query(value=" SELECT PAY_METHOD_ID,PAY_METHOD_CODE, PAY_METHOD_DESC, ENABLED FROM T_PAYMENT_METHODS "  ,nativeQuery=true)
	public List<Object[]> getPayMtdDtls();
}
