package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Activity;
import co.simplon.model.Person;

@Service
public interface PersonService {

	public List<Person> getAll();

	public List<Person> getByName(String name);

	public List<Person> getByNameStartsWith(String name);

	public List<Person> getByUid(String uid);

	public List<Person> getByFirstName(String firstName);

	public List<Person> getByNameAndFirstName(String name, String firstName);

	public List<Person> getByNameAndFirstNameAndUid(String name, String firstName, String uid);

	// volonte de rechercher une personne par son appartenance a une activité de sa
	// liste, pas sure du result,a tester
	public List<Person> findByActivityListIsIn(Activity activity);

}
