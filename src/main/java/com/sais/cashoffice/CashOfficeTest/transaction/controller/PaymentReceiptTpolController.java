package com.sais.cashoffice.CashOfficeTest.transaction.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.transaction.model.PaymentReceiptTpol;
import com.sais.cashoffice.CashOfficeTest.transaction.model.PaymentReceiptTppForm;
import com.sais.cashoffice.CashOfficeTest.transaction.service.PaymentReceiptTpolServiceImpl;
import com.sais.cashoffice.CashOfficeTest.transaction.service.PaymentReceiptTppServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PaymentReceiptTpolController {

	@Autowired
	private PaymentReceiptTpolServiceImpl paymentTpolImpl;

	@Autowired
	private PaymentReceiptTppServiceImpl paymentTppImpl;

	@PostMapping(path = "/InsertTpolDtls")
	public ResponseEntity<?> insertTpolDetails(@RequestBody PaymentReceiptTpol[] dtls,
			@RequestParam("createdby") String createdby, @RequestParam("receiptallid") double receiptallid) {

		List<Double> rcpttpolid = new ArrayList<>();

		for (int i = 0; i < dtls.length; i++) {

			LocalDate locdate = LocalDate.now();

			double tpolid = paymentTpolImpl.insertTpolDetails(receiptallid, dtls[i].getCorapp_ActivityId(),
					dtls[i].getPeriod(), dtls[i].getCorPolicyCode(), dtls[i].getCorStatus(), dtls[i].getCorPayerName(),
					BigDecimal.valueOf(dtls[i].getCorArrears()), BigDecimal.valueOf(dtls[i].getCorExpectedAmount()),
					BigDecimal.valueOf(dtls[i].getCorAllocatedAmount()), createdby, locdate);
			
			System.out.println(tpolid);
			rcpttpolid.add(tpolid);
		}
		return ResponseEntity.ok().body(rcpttpolid);
	}

	@PostMapping(path = "/InsertTppDtls", consumes = "application/json")
	public ResponseEntity<?> insertTppDetails(@RequestBody PaymentReceiptTppForm[] tpp,
			@RequestParam("createdby") String createdby, @RequestParam("receiptallid") double receiptallid) {

		List<Double> tppid = new ArrayList<>();

		for (int i = 0; i < tpp.length; i++) {

			double rcpttppid = paymentTppImpl.insertTppDetails(receiptallid, tpp[i].getTppActivity(),
					tpp[i].getTppPeriod(), tpp[i].getTppPaypoint(), tpp[i].getTppGrossAmount(),
					tpp[i].getTppReceiptedAmount(), createdby);
			tppid.add(rcpttppid);

		}

		return ResponseEntity.ok().body(tppid);
	}

}
