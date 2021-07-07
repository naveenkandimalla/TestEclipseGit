package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessAuthority;
import com.sais.cashoffice.CashOfficeTest.admin.repository.PageAccessAuthorityRepository;

@Service
public class PageAccessAuthorityServiceImpl implements PageAccessAuthorityService {

	@Autowired
	private PageAccessAuthorityRepository par;
	
	
	@Override
	public List<PageAccessAuthority> getpageaccessAuthoritydetails() {
	
		List<PageAccessAuthority> paa = new ArrayList<PageAccessAuthority>();
		
		List<Object[]> appi = par.getpageaccessAuthoritydetails();
		
		try{
			
			if(appi !=null & !appi.isEmpty()){
				 
				for(Object[] object:appi){
					
//					private double pageaccessRoleId;
//					private String authority;
//					private String comments;
//					private String createdBy;
//					private Date creationDate;
//					private String enabled;
//					private String modifiedBy;
//					private Date modifiedDatetime;
//					private double pageaccessId;
					
					
					PageAccessAuthority p = new PageAccessAuthority();
					
					p.setPageaccessRoleId((double) object[0]);
					p.setAuthority((String) object[1]);
					p.setComments((String) object[2]);
					p.setCreatedBy((String) object[3]);
					p.setCreationDate((Date) object[4]);
					p.setEnabled((char) object[5]);
					p.setModifiedBy((String) object[6]);
					p.setModifiedDatetime((Date) object[7]);
					p.setPageaccessId((double) object[8]);
					
					paa.add(p);
					
				}
				
				
			}
			
			return paa;
			
		}catch(NullPointerException e){
			System.out.println("null pointer exception has raised");
			return null;
			
		}
		 
		
		
	}


	@Override
	public Object insertrecordpageaccessauthority(String authority, char enable, double pageaccessid, Date creationdate,
			String createdby) {
		
		return par.insertrecordpageaccessauthority(authority, enable, pageaccessid, creationdate, createdby);
	}


	@Override
	public Object updaterecordT_PAGEACCESS_AUTHORITIES(double pageaccessid, String authority, Date modifieddate,
			char enable, String modifiedby, double pageaccessrole) {
		
		return par.updaterecordT_PAGEACCESS_AUTHORITIES(pageaccessid, authority,
				                                      modifieddate, enable, modifiedby, pageaccessrole);
	}


	


	
}
