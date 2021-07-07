package com.sais.cashoffice.CashOfficeTest.admin.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sais.cashoffice.CashOfficeTest.admin.model.GenerateNumber;

@Repository
public interface GenerateNumberRepository extends JpaRepository<GenerateNumber,Double> {
	
	
@Query(value="select max(id) from GenerateNumber",nativeQuery=true)
public double getid();


@Modifying
@Transactional
@Query(value="insert into GenerateNumber(id) values(?1) ",nativeQuery=true)
public void insertid(double id );

}
