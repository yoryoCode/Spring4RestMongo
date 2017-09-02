package com.javahash.spring.service;

import java.util.List;

import com.javahash.spring.model.Foo;

public interface IFooService {
	
	List<Foo> findAll();

	Foo findOne(Long id);

	Foo create(Foo resource);

	void update(Foo resource);

	void deleteById(Long id);

	Foo getById(Long id);
	
}
