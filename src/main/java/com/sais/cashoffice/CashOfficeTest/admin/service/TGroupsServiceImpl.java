package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.TGroups;
import com.sais.cashoffice.CashOfficeTest.admin.repository.TGroupsRepository;


@Service
public class TGroupsServiceImpl implements TGroupsService {
	
	@Autowired
	private TGroupsRepository tgr;

	@Override
	public List<TGroups> getallgroupsdetails() {
	    
		
		List<TGroups> tg = new ArrayList<TGroups>();
		
		List<Object[]>  tgrp= tgr.getallgroupsdetails();
		
		try{
			
			if(tgrp !=null && !tgrp.isEmpty()){
				
				   for(Object[] object:tgrp){
					   
					   TGroups t = new TGroups();  
   
					   t.setId((double) object[0]);
					   t.setGroupname((String) object[1]);
					   t.setGroupdesc((String) object[2]);
					   t.setCreationdate((Timestamp) object[3]);
					   t.setCreatedby((String) object[4]);
					   t.setModifieddate((Timestamp) object[5]);
					   t.setModifiedby((String) object[6]);
					   
					   tg.add(t);
				   }
				
				
			}
			
			return tg;
			
		}catch(NullPointerException e ){
			 
			return null;
		}
	}

  

}
