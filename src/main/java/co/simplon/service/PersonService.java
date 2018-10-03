package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Person;

@Service
public interface PersonService {

	public List<Person> getAll();

	public List<Person> getByTeamP2a(Long activityId);

	public List<Person> getByTeamOthers(Long activityId);

	public List<Person> getByName(String name);

	public List<Person> getByNameContaining(String name);

	public List<Person> getByFirstNameContaining(String firstName);

	public List<Person> getByUidContaining(String uid);

	public List<Person> getByActivityId(Long activityId);

	public List<Person> getByNameContainingAndFirstNameContainingAndActivityId(String name, String firstName,
			Long activityId);

	public List<Person> getByNameContainingAndFirstNameContaining(String name, String firstName);

	public List<Person> getByNameContainingAndFirstNameContainingAndUidContaining(String name, String firstName,
			String uid);

	public List<Person> getByNameContainingAndActivityId(String name, Long activityId);

	public List<Person> getByNameContainingAndUidContaining(String name, String uid);

	public List<Person> getByUidContainingAndActivityId(String uid, Long activityId);

	public List<Person> getByFirstNameContainingAndActivityId(String firstName, Long activityId);

	public List<Person> getByFirstNameContainingAndUidContaining(String firstName, String uid);

	public List<Person> getByFirstNameContainingAndUidContainingAndActivityId(String firstName, String uid,
			Long activityId);

	public List<Person> getByNameContainingAndFirstNameContainingAndUidContainingAndActivityId(String name,
			String firstName, String uid, Long activityId);

}
