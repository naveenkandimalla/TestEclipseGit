package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;

@Repository
public interface PageAccessQueryRepository extends JpaRepository<User,Long> {
	
	
	@Query(value="SELECT  TPA.PAGEACCESS_ROLE_ID,"
                            + "TPA.ENABLED,"
                            + "TPA.AUTHORITY,"
                            + "GAM.GROUPAUTHORITYDESC"
                      + " FROM T_PAGEACCESS_AUTHORITIES TPA, GROUP_AUTHORITIES_MASTER GAM"
                      + " WHERE TPA.AUTHORITY = GAM.AUTHORITY AND TPA.PAGEACCESS_ID = ?1",nativeQuery=true)
	public List<Object[]> fetchrolebypageaccessid(double pageaccessid);
	
	

}
