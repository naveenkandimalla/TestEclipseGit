package com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Service;

import org.springframework.http.ResponseEntity;

import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.EsoAllocationModel;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.EsoAllocationResponseModel;



public interface EsoAllocationService {
	
	 ResponseEntity<?>  Getesoallocation(EsoAllocationModel es,int userid);
	 
	 public EsoAllocationResponseModel fetchesoallocationresult(EsoAllocationModel es,int userid);

}
