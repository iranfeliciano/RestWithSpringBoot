package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}

	public Person update(Person person) {
		return person;
	}
	

	public void delete (String id) {
		
	}
	
	
	
	public List<Person> findAll(){
		
	List<Person> persons = new ArrayList<Person>();
	
	for (int i = 0; i < 8; i++) {
		Person person = mockPerson(i);
		persons.add(person);
	}
	return persons;	
	}
	
	public Person findById(String id) {
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Iran");
		person.setLastName("Feliciano");
		person.setAddress("Av. Santa Marina, 1588");
		person.setGender("Male");
		
		return person ;
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name " + i);
		person.setLastName("Person Last Name " + i);
		person.setAddress("Person Some address " + i);
		person.setGender("Male");
		
		return person;
	}	
}
