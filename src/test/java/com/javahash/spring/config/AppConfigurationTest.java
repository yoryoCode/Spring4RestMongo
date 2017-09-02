package com.javahash.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.javahash.spring.service.IEmployeesService;
import com.javahash.spring.service.impl.EmployeesServiceImpl;

@Configuration
@ComponentScan(basePackages={"com.javahash.spring.service",
		"com.javahash.spring.model"})
@Import(MongoDBDaoConfig.class)
public class AppConfigurationTest {
	
	@Bean(name="employeesService")
	public IEmployeesService getEmployeesService() {
	    return new EmployeesServiceImpl(); 
	}
	
}
