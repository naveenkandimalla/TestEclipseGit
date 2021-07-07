package com.sais.cashoffice.CashOfficeTest.SpringSecurity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sais.cashoffice.CashOfficeTest.SpringSecurity.Model.MyUserDetails;
import com.sais.cashoffice.CashOfficeTest.SpringSecurity.Model.User;
import com.sais.cashoffice.CashOfficeTest.SpringSecurity.Repository.UserDetailsRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

   @Autowired
   private  UserDetailsRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	//System.out.println("MyUserDetailsService --->loadUserByUsername");
    Optional<User> user = userRepository.finduserName(userName);     
    user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
    
    // in order to find roles assign to login user we are calling another query to check assign roles
    
    List<String> roles = userRepository.fetchRolesForLoginUser(userName);
    
    // printing the list items 
    //System.out.println(Arrays.toString(roles.toArray()));
    
    // converting all lower case items int he list to upper case
    roles.replaceAll(String::toUpperCase);
     
    System.out.println(Arrays.toString(roles.toArray()));
    // now appending role details to user 
     User userdetails = user.get();
       
     userdetails.setRolenames(roles);
    
     
       return MyUserDetails.Bulit(userdetails);
       
    }
}
