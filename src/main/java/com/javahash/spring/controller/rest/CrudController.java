package com.javahash.spring.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface CrudController<T> {
	
	public @ResponseBody List<T> findAll();
	
	public @ResponseBody T findOne( @PathVariable( "id" ) String id );
	
	public @ResponseBody T create( @RequestBody T resource );
	
	public void update( @PathVariable( "id" ) String id, @RequestBody T resource );
	
	public void delete( @PathVariable("id") String id );
	
}
