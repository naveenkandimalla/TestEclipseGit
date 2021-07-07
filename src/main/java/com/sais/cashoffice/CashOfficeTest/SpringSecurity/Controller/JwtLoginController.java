package com.sais.cashoffice.CashOfficeTest.SpringSecurity.Controller;

import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sais.cashoffice.CashOfficeTest.SpringSecurity.JWT.JwtAuthEntryPoint;
import com.sais.cashoffice.CashOfficeTest.SpringSecurity.JWT.JwtProvider;
import com.sais.cashoffice.CashOfficeTest.SpringSecurity.Model.JwtResponse;
import com.sais.cashoffice.CashOfficeTest.SpringSecurity.Model.LoginForm;
import com.sais.cashoffice.CashOfficeTest.SpringSecurity.Repository.UserDetailsRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class JwtLoginController implements ErrorController {

	 private static final Logger logger = LoggerFactory.getLogger(JwtLoginController.class);

	@Autowired
	UserDetailsRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
        
	
	@PostMapping(path="/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
       try {
    	   System.out.println("user login name --->"+loginRequest.getUsername());
   		
   		Authentication authentication = authenticationManager.authenticate(
   				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

   		SecurityContextHolder.getContext().setAuthentication(authentication);

   		String jwt = jwtProvider.generateJwtToken(authentication);
   		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
   		
   		double userid = userRepository.finduserid(loginRequest.getUsername());
        
   		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(), HttpStatus.OK.value(),"authenicated successfully",userid));
        }catch(BadCredentialsException e) {
    	   return ResponseEntity.ok(new JwtResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR.value(),"authenication failed",0));
       }catch(Exception e) {
     	   e.printStackTrace();
     	  return null;
        }
	
       
		
	}

	
	// PostAuthorize it also support due to we mention it in @EnableGlobalMethodSecurity
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String userAccess() {
		return ">>> User Contents!";
	}
//
//	@GetMapping("/api/test/pm")
//	@PreAuthorize("hasRole('TICKET') or hasRole('ADMIN')")
//	public String projectManagementAccess() {
//		return ">>> TICKET Management Board";
//	}
//	
//	@GetMapping("/api/test/admin")
//	@PreAuthorize("hasRole('ADMIN')")
//	public String adminAccess() {
//		return ">>> Admin Contents";
//	}
	
	
	
  // here below method will handle if we any error occured such as wrong url / authorization
	@RequestMapping("/error")
	public String getErrorPath(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        
	 
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return ("<h1>Searching page Url Does not exist</h1>");
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	return ("<h1>Something went wrong! </h1>"
	        	        + "<h2>Our Engineers are on it</h2>");
	        }else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	            return ("<h1>User does not have access to this page</h1>");
	        }else if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
	            return ("<h1>User does not have AUTHORIZED to access  this page</h1>");
	        }
	    }
	    return ("UnExcepted Error Occured");
	}

	@Override
	public String getErrorPath() {
		
		return "/error";
	}
}

