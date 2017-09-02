package com.javahash.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.javahash.spring.model.Foo;
import com.javahash.spring.service.IFooService;

public class FooServiceImpl implements IFooService{

	public List<Foo> findAll() {
		
		List<Foo> foos = new ArrayList<Foo>();
		
		Foo foo = new Foo();
		foo.setId(1L);
		foos.add(foo);
		
		Foo otherFoo = new Foo();
		otherFoo.setId(2L);
		foos.add(otherFoo);
		
		return foos;
	}

	public Foo findOne(Long id) {
		Foo foo = new Foo();
		foo.setId(id);
		return foo;
	}

	public Foo create(Foo resource) {
		// TODO Auto-generated method stub
		return resource;
	}

	public void update(Foo resource) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Foo getById(Long id) {
		Foo foo = new Foo();
		foo.setId(id);
		return foo;
	}

}
