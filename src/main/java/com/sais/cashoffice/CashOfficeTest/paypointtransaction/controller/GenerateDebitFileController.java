package com.sais.cashoffice.CashOfficeTest.paypointtransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.entities.TPpTemplate;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.repository.PaypointTemplateRepository;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.model.GenDebitFileForm;
import com.sais.cashoffice.CashOfficeTest.paypointtransaction.service.GenerateDebitFileService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GenerateDebitFileController {

	@Autowired
	PaypointTemplateRepository ppTmplRepo;
	
	@Autowired
	GenerateDebitFileService genDbtFlService;

	@GetMapping("/getTemplateName/{ppId}")
	public String getTempalteNameForPp(@PathVariable("ppId") String paypoint) {
		System.out.println(paypoint+"--paypoint id");
		try {
		return ppTmplRepo.findByPaypointId(Long.valueOf(paypoint)).getPpTemplateCode();
		
		}catch(Exception e) {
			//return "Failed To fetch Template for paypoint"+paypoint;
			return e.getMessage();
		}
		
	}

	@PostMapping("/generateDebitFileForPaypoint")
	public ResponseEntity<?> generateDebitFileForPaypoint(@RequestBody GenDebitFileForm form,@RequestParam("createdby") String user) {
		System.out.println("we are ready for inserting the record");
		return genDbtFlService.generateManualDebitFile(form,user);
	}

}
