package com.javahash.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.javahash.spring.dao.EmployeeRepository;
import com.javahash.spring.model.Employee;
import com.javahash.spring.service.IEmployeesService;

public class EmployeesServiceImpl implements IEmployeesService {
	
	@Autowired
	private EmployeeRepository repository;

	public Iterable<Employee> findEmployeeByName(String name) {
		return repository.findEmployeesByName(name);
	}
	
	public Iterable<Employee> findEmployeeByAge(int age) {
		return repository.findEmployeesByAge(age);
	}

	public Employee findEmployeeById(String id) {
		return repository.findEmployeeById(id);
	}

	public Iterable<Employee> findAll() {
		return repository.findAll();
	}

	public Employee create(Employee employee) {
		Employee empl = repository.save(employee);
		return empl;
	}

	public void delete(String id) {
		repository.delete(id);		
	}

}
