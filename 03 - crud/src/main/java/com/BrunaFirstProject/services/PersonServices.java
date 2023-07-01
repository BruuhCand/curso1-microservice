package com.BrunaFirstProject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.BrunaFirstProject.entities.Person;

@Service
public class PersonServices {
	
	
	private final AtomicLong counter = new AtomicLong(); //serve para simular um id no banco de dados
	
	
	public Person create(Person person) { //add uma pessoa
		return person;
	}
	

	public Person update(Person person) { //altera uma pessoa
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet()); // criar numero incrementado
		person.setFirstName("Bruna");
		person.setLastName("Candido");
		person.setAddress("Londrina");
		person.setGender("Femme");
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();	
		
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet()); // criar numero incrementado
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brazil " + i);
		person.setGender("Gender " + i);
		
		return person;
	}
}
