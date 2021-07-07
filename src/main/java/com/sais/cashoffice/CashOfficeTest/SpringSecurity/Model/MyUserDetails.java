package com.sais.cashoffice.CashOfficeTest.SpringSecurity.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;
    private double userid;
    
    
    // constructor 
    public MyUserDetails(String userName,String password,boolean active,List<GrantedAuthority> authorities,double userid) {
    	this.userName = userName;
        this.password = password;
        this.active= active;
        this.authorities=authorities;
        this.userid=userid;
               
    }
       
    
    public static MyUserDetails Bulit(User user) {
    	System.out.println("MyUserDetails bulit");
        
    	 List<GrantedAuthority> authorities = user.getRolenames().stream()
    			                              .map(SimpleGrantedAuthority::new)
                                               .collect(Collectors.toList());
           
    	 boolean status = false;
    	 
           if(user.getEnabled()==1) {
        	   status=true;
           }
           
           if(user.getEnabled()==0) {
        	   status=false;
           }
           
          return new MyUserDetails(user.getUsername(),user.getPassword(),status,authorities,user.getUserId());
    }
    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }
    
    
    public double getUserid() {
		return userid;
	}


	public void setUserid(double userid) {
		this.userid = userid;
	}


	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
    
    
}
