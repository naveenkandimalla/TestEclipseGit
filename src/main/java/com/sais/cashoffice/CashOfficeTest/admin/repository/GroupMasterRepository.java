package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.Group_Authorities_Master;

@Repository
public interface GroupMasterRepository extends JpaRepository<Group_Authorities_Master,Long>{
	
	
	
	@Query(value="call insertT_GROUPS(?1,?2,?3,?4)",nativeQuery=true)
	public Object insertrecordtgroup(String groupname,
			                           String groupdesc,
			                           String createdby,
			                           Date creationdate);

	
	
	@Query(value="call updateT_GROUPS(?1,?2,?3,?4,?5)",nativeQuery=true)
	public Object updaterecordtgroup(String groupname,
			                           String groupdesc,
			                           String modifiedby,
			                           Date modifieddate,
			                           double groupid);
}
