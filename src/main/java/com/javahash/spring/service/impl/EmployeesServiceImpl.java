package com.javahash.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.javahash.spring.dao.EmployeeRepositoryQueryDsl;
import com.javahash.spring.model.Employee;
import com.javahash.spring.service.IEmployeesService;

public class EmployeesServiceImpl implements IEmployeesService {
	
	@Autowired
	private EmployeeRepositoryQueryDsl repository;

	public Iterable<Employee> findEmployeeByAttributes(String key, String value) {
		return repository.findByAttributes(key, value);
	}
	
	public Employee findEmployeeById(String id) {
		return repository.findOne(id);
	}

	public Iterable<Employee> findAll() {
		return repository.findAll();
	}
	
	public Iterable<Employee> findEmployeeByAge(int age){
		return repository.findEmployeeByAge(age);
	}

	public Employee create(Employee employee) {
		Employee empl = repository.save(employee);
		return empl;
	}

	public void delete(String id) {
		repository.delete(id);		
	}

}
