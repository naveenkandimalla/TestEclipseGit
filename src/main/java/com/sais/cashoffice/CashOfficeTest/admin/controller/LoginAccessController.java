package com.sais.cashoffice.CashOfficeTest.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.admin.model.User;
import com.sais.cashoffice.CashOfficeTest.admin.service.LoginAccessServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class LoginAccessController {
	
	@Autowired
	private LoginAccessServiceImpl las;
	
	@GetMapping(path = "/userAuthenticate",produces="application/json")
	public List<User> userAuthenticate(@RequestParam("uName") String uName,  @RequestParam("Pwd") String Pwd) {
		System.out.println("User Name:"+ uName);
		System.out.println("Password:"+ Pwd);
		return las.userAuthenticate(uName, Pwd);
	}

}
