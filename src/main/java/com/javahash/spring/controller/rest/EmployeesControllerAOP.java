package com.javahash.spring.controller.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javahash.spring.model.Employee;
import com.javahash.spring.service.IEmployeesService;
import com.javahash.spring.util.RestPreconditions;

@Controller
@Path("/employees")
public class EmployeesControllerAOP implements CrudController<Employee> {
	
	@Autowired
	public IEmployeesService employeeService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create( Employee resource ){
		System.out.println(resource + " init");
		RestPreconditions.checkNotNull( resource );
		employeeService.create(resource);
		System.out.println(" resource created");
		return Response.status(200).entity(resource).build();		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll(@QueryParam("age") final String age){
		int statusCode = 200;
		Response response = null;
		Iterable<Employee> findAllResult = null;
		
		if(age == null){
			findAllResult = employeeService.findAll();
			
		}
		else{
			
			RestPreconditions.checkValidInteger(age);
			findAllResult = employeeService.findEmployeeByAge(Integer.parseInt(age));
					
		}
						
		response = Response.status(statusCode).entity(findAllResult).build();
		return response;
	}
	
	@GET
	@Path("/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOne(@PathParam("employeeId") final String employeeId) {
		Employee employee = (Employee) employeeService.findEmployeeById(employeeId);
		return Response.status(200).entity(employee).build();
	}
	
	@DELETE
	@Path("/{employeeId}")
	public Response delete(@PathParam("employeeId") String employeeId) {
		employeeService.delete(employeeId);
		String output = "DELETE: " + employeeId;
		return Response.status(204).entity(output).build();
	}

	@Override
	public Response update(String id, Employee resource) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

