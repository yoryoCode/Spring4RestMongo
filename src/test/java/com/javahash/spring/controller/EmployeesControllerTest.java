package com.javahash.spring.controller;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javahash.spring.config.AppConfigurationTest;
import com.javahash.spring.controller.rest.EmployeesControllerAOP;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfigurationTest.class)
public class EmployeesControllerTest {
	
	@Autowired
    private EmployeesControllerAOP employeesController;
	
	@Test
    public void testGetAllEmployees_Status200() {
  	  Response response = employeesController.findAll("39");
  	  Assert.assertEquals(200, response.getStatus());
  	}
	
	@Test
    public void testGetAllEmployees_Status204() {
  	  Response response = employeesController.findAll("90");
  	  Assert.assertEquals(204, response.getStatus());
  	}
	
	@Test
    public void testGetAllEmployees_Status400() {
  	  Response response = employeesController.findAll("edad");
  	  Assert.assertEquals(400, response.getStatus());
  	}

}
