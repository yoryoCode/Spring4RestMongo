package com.javahash.spring.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javahash.spring.config.AppConfigurationTest;
import com.javahash.spring.model.Employee;
import com.javahash.spring.model.Skill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfigurationTest.class)
public class EmployeesServiceIntegrationTest {

      @Autowired
      private IEmployeesService employeesService;

      @Test
      public void testCreateEmployee() {
    	  
    	Employee employee =new Employee();
    	employee.setAge(40);
    	employee.setName("Katia Trujillo Lopez");
    	List<Skill> skills = new ArrayList<Skill>();
    	Skill skillJava = new Skill();
    	skillJava.setExperience(5);
    	skillJava.setName("Psicologia");
    	Skill skillRest = new Skill();
    	skillRest.setExperience(3);
    	skillRest.setName("Filosofia");
    	skills.add(skillJava);
    	skills.add(skillRest);
    	
    	employee.setSkills(skills);
    	  
        Employee returnEmployee = employeesService.create(employee);
        assertTrue(returnEmployee != null);
        assertTrue(returnEmployee.getId() != null);
      }
      

      @Test
      public void testGetAllEmployee() {
    	  Iterable<Employee> employees = employeesService.findAll();
    	  assertTrue(employees !=null);
      }
      
      @Test
      public void testGetEmployeeById() {
    	  String id = "59a3530a80f8345b6bef8ca7";
    	  Employee employee = employeesService.findEmployeeById(id);
    	  assertTrue(employee !=null);
      }
      
      @Test
      public void testGetEmployeeByAttribute() {
    	  Iterable<Employee> employees = employeesService.findEmployeeByAttributes("name", "Jorge Garcia Marin");
    	  assertTrue(employees !=null);
      }
      
}