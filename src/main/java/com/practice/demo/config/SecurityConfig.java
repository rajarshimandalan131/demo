//package com.practice.demo.config;
//
//import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
//import org.springframework.boot.actuate.health.HealthEndpoint;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@SuppressWarnings("deprecation")
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.authorizeHttpRequests().requestMatchers(EndpointRequest.to(HealthEndpoint.class))
//					.permitAll().requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
//					.and().httpBasic();
//	}
//}
