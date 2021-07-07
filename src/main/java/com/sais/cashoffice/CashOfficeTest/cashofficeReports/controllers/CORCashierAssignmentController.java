package com.sais.cashoffice.CashOfficeTest.cashofficeReports.controllers;

import java.util.ArrayList;
import java.util.Date;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CORCashierAssignment;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities.CashierAssignPaymentMode;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository.CORCashierAssignmentRepository;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository.CORPaymentMethodRepository;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.repository.CashierAssignmentPaymentModeRepository;
import com.sais.cashoffice.CashOfficeTest.cashofficeReports.services.CORCashierAssignmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/cor_cashier-assignment")

public class CORCashierAssignmentController {

	@Autowired
	CORCashierAssignmentService caRepos;

	@Autowired
	CORCashierAssignmentRepository cashRepo;
	
	@Autowired
	CORPaymentMethodRepository payRepo;
	
	@Autowired
	CashierAssignmentPaymentModeRepository cpr;

	// fetch the Payment Methods for assign cashoffice
	@GetMapping("/paymentMethods/{branch_code}&{cash_office_code}")
	public List<CashierAssignPaymentMode> getCashierAssignment(@PathVariable("branch_code") String branch_code,
			@PathVariable("cash_office_code") String cash_office_code) {

		List<Object[]> result = cpr.getCa(branch_code, cash_office_code);

		if (result == null) {
			return new ArrayList<CashierAssignPaymentMode>();
		} else {
			List<CashierAssignPaymentMode> cap = new ArrayList<CashierAssignPaymentMode>();
			
			for(Object[] object:result) {
				CashierAssignPaymentMode c = new CashierAssignPaymentMode();
				c.setPay_method_code( (String) object[0]);
				c.setCash_office_code((String) object[1]);
				c.setPay_method_desc((String) object[2]);
				c.setPay_start_date((Date) object[3]);
				c.setPay_end_date((Date) object[4]);
				c.setCash_office_desc((String) object[5]);
				c.setBranch_name((String) object[6]);
				cap.add(c);
			}
			
			return cap;
		}
	}
	
	// fetch the Application details
		@GetMapping("/application/{branch_code}&{cash_office_code}")
		public List<Object[]> getApp(@PathVariable("branch_code") String branch_code,
				@PathVariable("cash_office_code") String cash_office_code) {

			List<Object[]> result = cashRepo.getApplication(branch_code, cash_office_code);

			if (result == null) {
				return new ArrayList<Object[]>();
			} else {

				return result;
			}
		}
	
	@GetMapping("/all-ca/")
	public List<CORCashierAssignment> getAllCashierAssignment() {

		List<CORCashierAssignment> result = cashRepo.findAll() ;

		if (result == null) {
			return new ArrayList<CORCashierAssignment>();
		} else {

			return result;
		}
	}

	


	@GetMapping("/paymentMethodsone/{branch_code}")
	public List<Object[]> getCashierAssignmentOne(@PathVariable("branch_code") String branch_code) {

		List<Object[]> result = cashRepo.getPay(branch_code);

		if (result == null) {
			return new ArrayList<Object[]>();
		} else {

			return result;
		}
	}

	@GetMapping("/allpaymentMethods")

	public List<CORCashierAssignment> getCashierAssignmentZero() {
		
		List<CORCashierAssignment> result = cashRepo.getPayment();

		if (result == null) {
			return new ArrayList<CORCashierAssignment>();
		} else {

			return result;
		}
		
	}

	

	@GetMapping("/applicationone/{branch_code}")

	public List<Object[]> getAppOne(@PathVariable("branch_code") String branch_code) {

		List<Object[]> result = cashRepo.getAppOne(branch_code);

		if (result == null) {
			return new ArrayList<Object[]>();
		} else {

			return result;
		}
	}

	@GetMapping("/applicationzero")

	public List<Object[]> getAppZero() {

		List<Object[]> result = cashRepo.getAppZero();

		if (result == null) {
			return new ArrayList<Object[]>();
		} else {

			return result;
		}
	}

	// Cashiers
	@GetMapping("/cashier/{branch_code}&{cash_office_code}")

	public List<Object[]> getCashier(@PathVariable("branch_code") String branch_code,
			@PathVariable("cash_office_code") String cash_office_code) {

		List<Object[]> result = cashRepo.getCashiers(branch_code, cash_office_code);

		if (result == null) {
			return new ArrayList<Object[]>();
		} else {

			return result;
		}
	}

	@GetMapping("/cashierone/{branch_code}")

	public List<Object[]> getCashierOne(@PathVariable("branch_code") String branch_code) {

		List<Object[]> result = cashRepo.getCashiersOne(branch_code);

		if (result == null) {
			return new ArrayList<Object[]>();
		} else {

			return result;
		}
	}

	@GetMapping("/cashierzero")

	public List<CORCashierAssignment> getCashierZero() {

		List<CORCashierAssignment> result = cashRepo.getCashiersZero();

		if (result == null) {
			return new ArrayList<CORCashierAssignment>();
		} else {

			return result;
		}
	}

	@GetMapping("/branchCodes")
	public List<Object[]> getBranchCodes() {

		List<Object[]> result = cashRepo.getBranchCode();

		if (result == null) {
			return new ArrayList<Object[]>();
		} else {

			return result;
		}
	}

	@GetMapping("/CashCodes/{branch_code}")
	public List<Object[]> getCashCodes(@PathVariable("branch_code") String branch_code) {

		List<Object[]> result = cashRepo.getCashCode(branch_code);

		if (result == null) {
			return new ArrayList<Object[]>();
		} else {

			return result;
		}
	}

	@GetMapping("/allreports")
	public List<CORCashierAssignment> getAllReports(){
		
		List<CORCashierAssignment> allr = cashRepo.findAll();
		
		return allr;
	}
}
