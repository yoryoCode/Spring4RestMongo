package com.javahash.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.javahash.spring.aop.ControllerErrorHandlerAspect;
import com.javahash.spring.controller.rest.EmployeesController;
import com.javahash.spring.controller.rest.EmployeesControllerAOP;
import com.javahash.spring.service.IEmployeesService;
import com.javahash.spring.service.impl.EmployeesServiceImpl;

@Configuration
@ComponentScan({"com.javahash.spring.model"})
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Import(MongoDBDaoConfig.class)
public class AppConfigurationTest {
	
	@Bean(name="employeesService")
	public IEmployeesService getEmployeesService() {
	    return new EmployeesServiceImpl(); 
	}
	
	@Bean(name="employeesController")
	public EmployeesController getEmployeesController() {
	    return new EmployeesController(); 
	}
	
	@Bean(name="employeesControllerAOP")
	public EmployeesControllerAOP getEmployeesControllerAOP() {
	    return new EmployeesControllerAOP(); 
	}
	
	@Bean
    public ControllerErrorHandlerAspect myAspect() {
        return new ControllerErrorHandlerAspect();
    }
	
}
