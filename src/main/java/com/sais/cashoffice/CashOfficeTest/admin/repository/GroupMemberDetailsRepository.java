package com.sais.cashoffice.CashOfficeTest.admin.repository;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;


@Repository
public interface GroupMemberDetailsRepository extends JpaRepository<User,Long> {
	


	@Query(value="call insertrecordGROUP_MEMBERS(?1,?2,?3,?4,?5)",nativeQuery=true)
	public int insertrecordgroupmember(double groupid,
			                            String username,
			                            String enable,
			                            Date creationdate,
			                            String createdby);
	
	
	@Query(value="call insertrecordGROUP_MEMBERS(?1,?2,?3,?4,?5)",nativeQuery=true)
	public int updaterecordgroupmember(
			                           double groupmemid,
			                            String enable,
			                            double groupid,
			                            Date modifieddate,
			                            String modifiedby);
	
}
