package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Activity;
import co.simplon.model.Person;
import co.simplon.repo.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepo personRepo;

	public PersonServiceImpl(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return personRepo.findAll();
	}

	@Override
	public List<Person> getByName(String name) {
		// TODO Auto-generated method stub
		return personRepo.findByName(name);
	}

	@Override
	public List<Person> getByNameStartsWith(String name) {
		// TODO Auto-generated method stub
		return personRepo.findByNameStartsWith(name);
	}

	@Override
	public List<Person> getByUid(String uid) {
		// TODO Auto-generated method stub
		return personRepo.findByUid(uid);
	}

	@Override
	public List<Person> getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return personRepo.findByFirstName(firstName);
	}

	@Override
	public List<Person> getByNameAndFirstName(String name, String firstName) {
		// TODO Auto-generated method stub
		return personRepo.findByNameAndFirstName(name, firstName);
	}

	@Override
	public List<Person> getByNameAndFirstNameAndUid(String name, String firstName, String uid) {
		// TODO Auto-generated method stub
		return personRepo.findByNameAndFirstNameAndUid(name, firstName, uid);
	}

	@Override
	public List<Person> findByActivityListIsIn(Activity activity) {
		// TODO Auto-generated method stub
		return personRepo.findByActivityListIsIn(activity);
	}

}
