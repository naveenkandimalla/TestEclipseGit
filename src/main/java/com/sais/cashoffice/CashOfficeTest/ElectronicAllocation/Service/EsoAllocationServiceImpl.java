package com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Service;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.EsoAllocationModel;
import com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model.EsoAllocationResponseModel;

@Service
public class EsoAllocationServiceImpl implements EsoAllocationService {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public ResponseEntity<?> Getesoallocation(EsoAllocationModel es,int userid) {
	
		EsoAllocationResponseModel response = new EsoAllocationResponseModel();
		
		try {
			response = fetchesoallocationresult(es,userid);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
	
	}

	@Override
	public EsoAllocationResponseModel fetchesoallocationresult(EsoAllocationModel es, int userid) {
		
		EsoAllocationResponseModel response = new EsoAllocationResponseModel();
		
		try{
			
			// initally defining the procedure name
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PE_ESO_ALLOCATION");
			
			
			// Declare the parameters in the same order
		       query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		       query.registerStoredProcedureParameter(2, BigDecimal.class, ParameterMode.IN);
		       query.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
		       query.registerStoredProcedureParameter(4, Double.class, ParameterMode.IN);
		       query.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
		       query.registerStoredProcedureParameter(6, Character.class, ParameterMode.IN);
		       query.registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);
		       query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.OUT);
		       query.registerStoredProcedureParameter(9, String.class, ParameterMode.OUT);
		       
		    // Pass the parameter values
		   	query.setParameter(1, es.getCrhdrid());
			query.setParameter(2, es.getPaypointid());
			query.setParameter(3, es.getPeriod());
			query.setParameter(4, es.getReceiptno());
			query.setParameter(5, es.getReceiptamount());
			query.setParameter(6, es.getFlag());
			query.setParameter(7, userid);
			
			// Execute query
		    boolean excute = query.execute();
		    
		    System.out.println("does query excuted--->"+excute);
		    
		 // Get output parameters
		     int successid = (int) query.getOutputParameterValue(8);
		     String outmessage  = (String)  query.getOutputParameterValue(9);
			
			System.out.println(successid);
			System.out.println(outmessage);
			
			response.setSuccessid(successid);
			response.setFileresponse(outmessage);
			
			return response;
			
		}catch(Exception e){
			
			response.setFileresponse("error occured while excuting allocation process");
			
			return response;
			
		}
		
	}

	

}
