package com.javahash.spring.controller.rest.jersey;

import java.util.List;

//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javahash.spring.model.Foo;
import com.javahash.spring.service.IFooService;
import com.javahash.spring.util.RestPreconditions;

@Controller
//@Path("/foos")
public class FooJerseyController {
	
//	@Autowired
//	IFooService fooService;
// 
//	@GET
//	public @ResponseBody List<Foo> findAll(){
//		System.out.println("findAllResult init");
//		List<Foo> findAllResult = fooService.findAll();
//		System.out.println("findAllResult ended");
//		return findAllResult;
//	}
//	
//	@POST 
//	public Foo create( Foo resource ){
//		System.out.println(resource + " init");
//		RestPreconditions.checkNotNull( resource );
//		Foo foo = fooService.create( resource );
//		System.out.println(foo.getId() + " jersey foo created");
//		return foo;
//	}
//	
//	@PUT
//    @Path("/{param}")
//    public Response putMsg(@PathParam("param") String param) {
//        String output = "PUT: Jersey say : " + param;
//        return Response.status(200).entity(output).build();
//    }
//	
//	@DELETE
//    @Path("/{param}")
//    public Response deleteMsg(@PathParam("param") String param) {
//        String output = "DELETE:Jersey say : " + param;
//        return Response.status(204).entity(output).build();
//    }
	
}
