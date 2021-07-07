package com.sais.cashoffice.CashOfficeTest.paypointmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sais.cashoffice.CashOfficeTest.entities.TPpAttribute;

public interface PaypointAttrbutesRepository extends JpaRepository<TPpAttribute,Integer>{
	
	
	@Query(value="select tp.PAYPOINT_ID,t.PAY_POINT_NAME,tp.PP_TEMPLATE_CODE,tpa.ATTR_COM_DESC,tf.CONSTANT,"
			    + "tf.PERIOD,tf.STRIKE_DATE,tf.FILE_EXTENSION,tpa.PP_ATTRIBUTE_ID,tp.PENSION_ONLY_YN,tp.OTHER_PREM_ONLY_YN from T_PP_TEMPLATE tp,T_PAY_POINT t,"
			    + "T_PP_ATTRIBUTES tpa,T_FILE_NAMING_FORMAT tf where tp.PAYPOINT_ID=t.PAY_POINT_ID and tpa.PP_ATTRIBUTE_ID=tp.PP_ATTRIBUTE_ID and tp.PP_TEMPLATE_ID=tf.PP_TEMPLATE_ID order by tp.PAYPOINT_ID ",nativeQuery=true)
	public List<Object[]> ftechtemplatedetails();

}
