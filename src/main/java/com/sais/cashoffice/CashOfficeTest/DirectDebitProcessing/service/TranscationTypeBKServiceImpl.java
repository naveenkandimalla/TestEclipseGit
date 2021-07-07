package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model.TranscationTypeBKModel;
import com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.repository.TranscationTypeBKdesRespository;


@Service
public class TranscationTypeBKServiceImpl implements TranscationTypeBAnkService  {
	
	@Autowired
	private TranscationTypeBKdesRespository ttr;

	@Override
	public List<TranscationTypeBKModel> fetchbanktranscationtypes() {
		
		List<Object[]> tr = ttr.gettranscationtypesbankcodedesc();
		
		List<TranscationTypeBKModel> tm = new ArrayList<TranscationTypeBKModel>();
		
		if(tr !=null && !tr.isEmpty()){
			
			for(Object[] t:tr){
				TranscationTypeBKModel m = new TranscationTypeBKModel();
				
				m.setTranscationtype((String) t[0]);
				m.setTransdescription((String) t[1]);
				
				tm.add(m);
				
				
			}
			
		}
		
		return tm;
	}



}
