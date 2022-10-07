package com.practice.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.practice.demo.service.impl.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

	@Bean
	AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}
}
