package com.BrunaFirstProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BrunaFirstProject.entities.Person;
import com.BrunaFirstProject.services.PersonServices;

@RestController
@RequestMapping("/person") //sempre que for acessar esse controller precisa disso
public class PersonController {

	@Autowired
	private PersonServices services;
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public 	Person findById(@PathVariable("id") String id )  {
		
		return services.findById(id);
		
	}
	
	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public 	List<Person> findAll()  {
		
		return services.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public 	Person create(@RequestBody Person person)  { //chama o services, cria o objeto e desolve JSON
		
		return services.create(person);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public 	Person update(@RequestBody Person person)  { //faz update da pessoa no banco de dados e altera
		
		return services.update(person);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id )  {
		
		services.delete(id);
		
	}
	
	
	
}
