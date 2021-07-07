package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.Group_Authorities_Master;


@Repository
public interface AssignRoleRepository extends JpaRepository<Group_Authorities_Master,Long> {
    
	
	
	List<Group_Authorities_Master> findAll();
	
	@Query(value="call insertrecordGROUP_AUTHORITIES_MASTER(?1,?2,?3,?4)",nativeQuery=true)
	public Object insertrecordgroupauthority(String authority,String authoritydesc,Date creationdate,String createdby);
	
	@Query(value="call updateGROUP_AUTHORITIES_MASTER(?1,?2,?3,?4,?5)",nativeQuery=true)
	public Object updaterecordgroupauthority(String authority,String authoritydesc,Date modified,String modifiedby,Date creationdate);
	
	@Query(value="select grpAuthMst.AUTHORITY,grpAuthMst.GROUPAUTHORITYDESC,grpAuth.GROUP_ID,"
			+ "grps.GROUP_NAME,grps.GROUP_DESC,grpAuth.ENABLED from T_GROUPS grps, GROUP_AUTHORITIES grpAuth,"
			+ " GROUP_AUTHORITIES_MASTER grpAuthMst where grpAuth.GROUP_ID=grps.ID and"
             + " grpAuth.AUTHORITY=grpAuthMst.AUTHORITY  and grpAuthMst.AUTHORITY =?1",nativeQuery=true)
	public List<Object[]> fetchassignroledetails(String authority);
	

	@Query(value="call insertGROUP_AUTHORITIES(?1,?2,?3,?4,?5)",nativeQuery=true)
	public Object insertrecordgroupauyhorities(String authority,double groupid,char enabled,Date creationdate,String createdby);
	
	@Query(value="call UpdateRecordGROUP_AUTHORITIES(?1,?2,?3,?4)",nativeQuery=true)
	public Object updaterecordgroupauyhorities(char enabled,Date modifidationdate,String modifiedby,double groupid);
	
}

