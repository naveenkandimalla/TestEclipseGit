package com.sais.cashoffice.CashOfficeTest.master.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.entities.TCashier;
import com.sais.cashoffice.CashOfficeTest.entities.TPaymentMethod;
import com.sais.cashoffice.CashOfficeTest.master.repository.PaymentMethodRepository;
import com.sais.cashoffice.CashOfficeTest.master.service.PaymentMethdService;;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PaymentMethodController {

	@Autowired
	private PaymentMethodRepository paymethod;
	
	@Autowired
	private PaymentMethdService paymentMethosS;

	@GetMapping("/paymentMethod")	
	public List<TPaymentMethod> getAllPaymentMethods() {
		return paymentMethosS.fetchAllPaymentDetails();
	}

	@PostMapping("/createPaymentMethod")
	@Transactional
	public TPaymentMethod createPaymentmethod(@Valid @RequestBody TPaymentMethod paymentMethod,@RequestParam("createdby") String createdby) {	
		
		if (paymentMethod.getEnabled() == 1)
			paymentMethod.setEnabled('1');
		else
			paymentMethod.setEnabled('0');	
		
		TPaymentMethod id=paymethod.findByPayMethodCode(paymentMethod.getPayMethodCode());
		System.out.println(id);
		if(id !=null) {
			paymentMethod.setPayMethodId(id.getPayMethodId());
			paymentMethod.setModifiedBy(createdby);
			
			return this.paymethod.save(paymentMethod);	
		}else {	
			paymentMethod.setCreatedBy(createdby);
			return this.paymethod.save(paymentMethod);
		}
		
	}
}
