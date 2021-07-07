package com.sais.cashoffice.CashOfficeTest.paypointmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TPpTemplate;

@Repository
public interface PaypointTemplateRepository extends JpaRepository<TPpTemplate, Long> {

	TPpTemplate findByPaypointId(long ppId);
	
	
	@Query(value="Select CONSTANT,PERIOD,STRIKE_DATE,FILE_EXTENSION from T_FILE_NAMING_FORMAT ",nativeQuery=true)
	public List<Object[]> fetchTfileNamingfromattebypptemplateid(double pptemplateid);
     

}
