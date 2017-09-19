package com.javahash.spring.service;

import com.javahash.spring.model.Employee;

public interface IEmployeesService {
	
	public Iterable<Employee> findEmployeeByAttributes(String key, String value);
	
	public Employee findEmployeeById(String id);
	
	public Iterable<Employee> findEmployeeByAge(int age);
	
	public Iterable<Employee> findAll();
	
	public Employee create(Employee employee);
	
	public void delete(String id);

}
