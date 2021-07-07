package com.sais.cashoffice.CashOfficeTest.SpringSecurity.Model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private Collection<? extends GrantedAuthority> authorities;
    private int statuscode;
    private String message;
    private double userid;
    
	public JwtResponse(String accessToken, String username, Collection<? extends GrantedAuthority> authorities,int statuscode,String message,double userid) {
		this.token = accessToken;
		this.username = username;
		this.authorities = authorities;
		this.statuscode=statuscode;
		this.message=message;
		this.userid=userid;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getUserid() {
		return userid;
	}

	public void setUserid(double userid) {
		this.userid = userid;
	}
    
	
    
}
