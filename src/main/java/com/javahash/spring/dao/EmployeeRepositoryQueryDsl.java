package com.javahash.spring.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javahash.spring.model.Employee;

@Repository
public interface EmployeeRepositoryQueryDsl extends CrudRepository<Employee,String>, QueryDslPredicateExecutor<Employee> {
	
	List<Employee> findEmployeeByAge(int age);
	
	/**
	 * Returns all {@link Employee}s having the given attribute.
	 * 
	 * @param attribute
	 * @return
	 */
	@Query("{ ?0 : ?1 }")
	List<Employee> findByAttributes(String key, String value);
}
