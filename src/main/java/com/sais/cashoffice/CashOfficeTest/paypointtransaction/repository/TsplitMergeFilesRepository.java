package com.sais.cashoffice.CashOfficeTest.paypointtransaction.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sais.cashoffice.CashOfficeTest.entities.TSplitMergeFile;

public interface TsplitMergeFilesRepository extends JpaRepository<TSplitMergeFile, Long> {

	TSplitMergeFile findByFilename(String fileName);	
    
	
	@Query(value="SELECT * FROM T_SPLIT_MERGE_FILES where Date(PERIOD)=?1 and PAYPOINT_ID=?2 and SPLIT=?3 ",nativeQuery=true)
	List<TSplitMergeFile> getByPeriodAndPaypointIdAndSplit(Date period, Long paypointId, String Split);

	
	@Query(value="SELECT * FROM T_SPLIT_MERGE_FILES where Date(PERIOD)=?1 and PAYPOINT_ID=?2 and MERGED=?3 ",nativeQuery=true)
	List<TSplitMergeFile> getByPeriodAndPaypointIdAndMerged(Date period, Long paypointId, String merge);

}
