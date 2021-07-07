package com.sais.cashoffice.CashOfficeTest.paypointmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sais.cashoffice.CashOfficeTest.entities.TFileNamingFormat;

public interface FileNamingFormatRepository extends JpaRepository<TFileNamingFormat,Long>{

	TFileNamingFormat findByPaypointId(long ppId);
	
	@Query(value="select max(PP_FILE_NAME_FORMAT_ID) from T_FILE_NAMING_FORMAT",nativeQuery=true)
	double fetchmaxfilenamingid();

}
