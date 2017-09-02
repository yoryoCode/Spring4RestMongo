package com.javahash.spring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.javahash.spring.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee,String> {
	Iterable<Employee> findEmployeesByAge(int age);  
    Iterable<Employee> findEmployeesByName(String name);
    Iterable<Employee> findEmployeesBySkillsIn(List<String> skills);
    Employee findEmployeeById(String id);
}
