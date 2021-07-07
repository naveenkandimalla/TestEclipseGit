package com.sais.cashoffice.CashOfficeTest.paypointtransaction.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.entities.TPaypointDrHdr;

@Repository
public interface TpaypointDrHdrRepository extends JpaRepository<TPaypointDrHdr, Long> {

	List<TPaypointDrHdr> findByPeriodAndFileStatus(Date period, String string);
     
	@Query(value="SELECT FILE_NAME FROM T_PAYPOINT_DR_HDR where PAYPOINT_ID=?1 and Date(PERIOD)=?2"
                   +"and Date(STRIKE_DATE_FROM) =?3 and  Date(STRIKE_DATE_TO)=?4",nativeQuery=true)
	public String getByPaypointIdAndPeriodAndStrikeDateFromAndStrikeDateTo(long paypointId, Date period, Date strikeDateFrom, Date StrikeDateTo);

	
	@Query(value="SELECT FILE_NAME FROM T_PAYPOINT_DR_HDR where PAYPOINT_ID=?1 and Date(PERIOD)=?2 ",nativeQuery=true)
     public String getByPaypointIdAndPeriod(long paypointId, Date period);
	
	
	@Query(value="call Generate_DebitFile_Eso_DR(?1,?2,?3)",nativeQuery=true)
	public List<Object[]> getpaypointtransdebitfilerecords(BigDecimal paypointid,Date paypointduedate,double pphdrid);
}
