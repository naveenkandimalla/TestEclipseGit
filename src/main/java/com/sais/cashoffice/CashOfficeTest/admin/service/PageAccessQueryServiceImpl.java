package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessQueryModel;
import com.sais.cashoffice.CashOfficeTest.admin.repository.PageAccessQueryRepository;

@Service
public class PageAccessQueryServiceImpl implements PageAccessQueryService {
	
	
   @Autowired
   private PageAccessQueryRepository par;
	

	@Override
	public List<PageAccessQueryModel> fetchrolebypageaccessid(double pageaccessid) {
		
		 try{
			 
			 List<PageAccessQueryModel> pqm = new ArrayList<PageAccessQueryModel>();
			 
			 List<Object[]> appi = par.fetchrolebypageaccessid(pageaccessid);
			 
			 
			 if(appi !=null && !appi.isEmpty()){
				 
				 for(Object[] object:appi){
					 
					 PageAccessQueryModel p = new PageAccessQueryModel();
					 

					  p.setPageaccessroleid((double) object[0]);
					  p.setEnabled((char) object[1]);
					  p.setAuthority((String) object[2]);
					  p.setGroupaauthoritydescription((String) object[3]);
					 
					  
					  
					  pqm.add(p);
					 
					 
				 }
				 
			 }
			 
			 
			 
			return pqm; 
		 }catch(NullPointerException e){
			 
			 System.out.println("null pointer exception is raised");
			 
			 return null;
			 
		 }
		
		
		
		
	}

}
