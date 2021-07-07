package com.sais.cashoffice.CashOfficeTest.admin.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.admin.repository.GenerateNumberRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class GenerateNumberController {
	
	@Autowired
	private GenerateNumberRepository gn;
	
	
	@GetMapping(path="/generateuniquenumber")
	public String fetchuniquenumber(){
		
		double number = gn.getid();
		System.out.println(number);
		
		DecimalFormat df = new DecimalFormat("S00000000000");
		String formattednumber = df.format(number);
		
		System.out.println(formattednumber);
		
		double newnumber = number+1;
		System.out.println(newnumber);
		 gn.insertid(newnumber);
	
		
		return formattednumber;
		
	}
	

}
