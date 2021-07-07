package com.sais.cashoffice.CashOfficeTest.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.admin.model.PageAccessMaster;
import com.sais.cashoffice.CashOfficeTest.admin.repository.PageAccessMasterRepository;



@Service
public class PageAccessMasterServiceImpl implements PageAccessMasterService {

	@Autowired
	private PageAccessMasterRepository pmr;
	
	
	@Override
	public List<PageAccessMaster> getpageaccessMasterdetails() {
		
		List<PageAccessMaster> pam = new ArrayList<PageAccessMaster>();
		List<Object[]> appi = pmr.getpageaccessMasterdetails();
//		System.out.println(appi.size());
//		System.out.println(appi !=null);
//		System.out.println( !appi.isEmpty());
//		System.out.println( appi !=null && !appi.isEmpty());		
		try{
			
			if(appi !=null && !appi.isEmpty()){
				
				for(Object[] object:appi){
					
					PageAccessMaster pc = new PageAccessMaster();
					pc.setPageaccessId((double) object[0]);
					pc.setComments((String) object[1]);
					pc.setCreatedBy((String) object[2]);
					pc.setCreationDate((Date) object[3] );
                   // pc.setEnabled((char) object[4]);
                    pc.setModifiedBy((String) object[4]);
                    pc.setModifiedDatetime((Date) object[5]);
                    pc.setScreenCode((String) object[6]);
                    pc.setScreenDesc((String) object[7]);
                    pc.setUrl((String) object[8]);
                    pc.setModuleid((double) object[9]);
                    pc.setStatus((char) object[10]);
                    
                    
                    pam.add(pc);
					
					
					
				}
				
			}
			
			return pam;
			
		}catch(NullPointerException e){
			
			System.out.println("null pointer exception is raised");
			return null;
		}
		
		
		
	}


	@Override
	public Object insertrecordpageaccessmaster(String screencode, String screendesc, String url, double mouldid,
			Date creationdate, String createdby, char enabled) {

		return pmr.insertrecordpageaccessmaster(screencode, screendesc, url, mouldid, creationdate, createdby, enabled);
	}


	@Override
	public Object updaterecordpageaccessmaster(double pageaccessid, String screencode, String screendesc, String url,
			double mouldid, Date modifiteddate, String modifiedby,char status) {
		
		return pmr.updaterecordpageaccessmaster(pageaccessid, screencode, screendesc, url, mouldid, modifiteddate, modifiedby,status);
				
	}

}
