package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Person;

@Service
public interface PersonService {

	public List<Person> getAll();

	// volonte de rechercher un collaborateur ou un ctc par son appartenance a une
	// activité de sa
	// liste, pas sure du result,a tester

	public List<Person> getByTeamP2a(Long activityId);

	public List<Person> getByTeamOthers();

	public List<Person> getByTeamOthers(Long activityId);

	public List<Person> getByName(String name);

	public List<Person> getByNameContaining(String name);

	public List<Person> getByUid(String uid);

	public List<Person> getByFirstName(String firstName);

	public List<Person> getByNameAndFirstName(String name, String firstName);

	public List<Person> getByNameAndFirstNameAndUid(String name, String firstName, String uid);

}
