package com.sais.cashoffice.CashOfficeTest.paypointmaster.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sais.cashoffice.CashOfficeTest.entities.TPayPoint;
import com.sais.cashoffice.CashOfficeTest.entities.TPpAttribute;
import com.sais.cashoffice.CashOfficeTest.entities.TPpTemplate;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.AssignDbtFileTmpt;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.model.DebitFileTemplateModel;

public interface PaypointService {

	List<TPayPoint> fetchAllPaypoints();

	List<TPpAttribute> fetchPaypointAttributes();

	ResponseEntity<?> assignDebitFileTemplate(AssignDbtFileTmpt form, MultipartFile file,String createdby,String modifiedby);

	List<AssignDbtFileTmpt> fetchAsgndPayPointDetails();
	
	List<DebitFileTemplateModel> getalltemplatedetails();

}
