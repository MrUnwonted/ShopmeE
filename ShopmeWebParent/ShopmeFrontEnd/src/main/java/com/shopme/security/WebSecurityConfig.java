package com.shopme.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().permitAll();
		
//			.authenticated()
//			.and()
//			.formLogin()			
//				.loginPage("/login")
//				.usernameParameter("email")
//				.permitAll()
//			.and().logout().permitAll()
//			.and()
//				.rememberMe()
//					.key("AbcDefgHijKlmnOpqrs_1234567890")
//					.tokenValiditySeconds(7 * 24 * 60 * 60);
//					;
			
	}


}

