package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.ModuleModel;
import com.sais.cashoffice.CashOfficeTest.admin.repository.ModuleModelRepository;

@Service
public class ModuleModelServiceImpl implements ModuleModelService{

	@Autowired
	private ModuleModelRepository mmr;
	
	@Override
	public List<ModuleModel> getModuledetails() {
		
		List<ModuleModel>  mm = new ArrayList<ModuleModel>();
		List<Object[]> appi = mmr.getModuledetails();
		
		
		try{
			
			if(appi !=null && !appi.isEmpty()){
				
				for(Object[] object:appi){
					
//					private double moduleid;
//					private String modulecode;
//					private String moduledesc ;
//					private Date creationdate;
//					private String createdby ;
//					private Date modifieddatetime; 
//					private String modifiedby ;
//					private String comments;
					
					ModuleModel m = new ModuleModel();
					
					m.setModuleid((double) object[0]);
					m.setModulecode((String) object[1]);
					m.setModuledesc((String) object[2]);
					m.setCreationdate((Date) object[3]);
					m.setCreatedby((String) object[4]);
					m.setModifieddatetime((Date) object[5]);
					m.setModifiedby((String) object[6]);
					m.setComments((String) object[7]);
					
					mm.add(m);
					
					
				}
				
				
			}
			
			
			return mm;
		}catch(NullPointerException e){
			System.out.println("null pointer exception raised");
			
			return null;
		}
		
		
	
		
	}

}
