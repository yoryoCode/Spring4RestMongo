package com.javahash.spring.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javahash.spring.model.Foo;
import com.javahash.spring.service.IFooService;
import com.javahash.spring.util.RestPreconditions;

@Profile("spring-rest")
//@RestController
@RequestMapping( value = "/foos" )
public class FooRestController{
 
	@Autowired
	IFooService fooService;
 
	@RequestMapping(method=RequestMethod.GET)
	public List<Foo> findAll(){
		System.out.println("findAllFooRestResult init");
		List<Foo> findAllResult = fooService.findAll();
		System.out.println("findAllFooRestResult ended");
		return findAllResult;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Foo findOne( @PathVariable( "id" ) Long id ){
		return (Foo) RestPreconditions.checkFound( fooService.findOne( id ) );
	}
	
	@RequestMapping( method = RequestMethod.POST )
	@ResponseStatus( HttpStatus.CREATED )
	public Foo create( @RequestBody Foo resource ){
		System.out.println(resource + " init");
		RestPreconditions.checkNotNull( resource );
		Foo foo = fooService.create( resource );
		System.out.println(foo.getId() + " created");
		return foo;
	}
 
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	@ResponseStatus( HttpStatus.OK )
	public void update( @PathVariable( "id" ) Long id, @RequestBody Foo resource ){
		System.out.println("entity: " + id + " init");
		RestPreconditions.checkNotNull( resource );
		RestPreconditions.checkNotNull( fooService.getById( resource.getId() ) );
		fooService.update( resource );
		System.out.println("entity: " + id + " updated");
	}
 
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	@ResponseStatus( HttpStatus.NOT_FOUND )
	public void delete( @PathVariable("id") Long id ){
		fooService.deleteById( id );
		System.out.println("entity: " + id + " deleted");
	}
}
