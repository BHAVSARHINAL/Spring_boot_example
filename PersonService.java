package com.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Person;
import com.api.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repo;

	public Person Create(Person person) {
		return repo.save(person);
	}

	public List<Person> getPerson() {
		return repo.findAll();
	}

	public Person updatePerson(Person per) {
		Person exists = repo.findById(per.getId()).get();
		exists.setName(per.getName());
		exists.setEmail(per.getEmail());
		exists.setUsername(per.getUsername());
		exists.setPassword(per.getPassword());
		exists.setAddress(per.getAddress());
		exists.setMobile(per.getMobile());
		per.setCreateDate(exists.getCreateDate());
		Person p = repo.save(per);
		return p;
	}
	
	public void deletePerson(int id) {
	     
		 repo.deleteById(id);
	}

}
