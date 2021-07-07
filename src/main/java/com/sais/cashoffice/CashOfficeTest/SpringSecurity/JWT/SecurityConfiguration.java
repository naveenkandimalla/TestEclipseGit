package com.sais.cashoffice.CashOfficeTest.SpringSecurity.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;





@Configuration
@EnableWebSecurity(
		//debug = true
		)
@EnableGlobalMethodSecurity(
		prePostEnabled = true
)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;
    
    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }
    
 

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//System.out.println("AuthenticationManagerBuilder");
        auth.userDetailsService(userDetailsService);
    
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
    	//System.out.println("PasswordEncoder");
        return NoOpPasswordEncoder.getInstance();
    }
     
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//System.out.println("HttpSecurity");
    	 http.cors().and().csrf().disable().
         authorizeRequests()
         .antMatchers("CashOffice-Test/api/**","/login").permitAll()
         .anyRequest().authenticated()
         .and()
         .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 
 http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

   
}
