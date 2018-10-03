package co.simplon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.model.Person;
import co.simplon.model.Team;
import co.simplon.repo.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepo personRepo;
	@Autowired
	private TeamService teamService;

	@Override
	public List<Person> getAll() {
		return personRepo.findAll();
	}

	@Override
	public List<Person> getByName(String name) {
		return personRepo.findByName(name);
	}

	@Override
	public List<Person> getByNameContaining(String name) {
		return personRepo.findByNameIgnoreCaseContaining(name);
	}

	@Override
	public List<Person> getByUidContaining(String uid) {
		return personRepo.findByUidIgnoreCaseContaining(uid);
	}

	@Override
	public List<Person> getByFirstNameContaining(String firstName) {
		return personRepo.findByFirstNameIgnoreCaseContaining(firstName);
	}

	@Override
	public List<Person> getByNameContainingAndFirstNameContaining(String name, String firstName) {
		return personRepo.findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContaining(name, firstName);
	}

	@Override
	public List<Person> getByNameContainingAndFirstNameContainingAndUidContaining(String name, String firstName,
			String uid) {
		return personRepo.findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContainingAndUidIgnoreCaseContaining(name,
				firstName, uid);
	}

	@Override
	public List<Person> getByTeamP2a(Long activityId) {
		Team teamP2a = teamService.getByName("P2A");
		return personRepo.findByTeamAndActivityListId(teamP2a, activityId);
	}

	@Override
	public List<Person> getByTeamOthers(Long activityId) {
		Team teamP2a = teamService.getByName("P2A");
		return personRepo.findByTeamNotAndActivityListId(teamP2a, activityId);
	}

	@Override
	public List<Person> getByActivityId(Long activityId) {
		return personRepo.findByActivityListId(activityId);
	}

	@Override
	public List<Person> getByNameContainingAndFirstNameContainingAndActivityId(String name, String firstName,
			Long activityId) {

		return personRepo.findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContainingAndActivityListId(name,
				firstName, activityId);
	}

	@Override
	public List<Person> getByNameContainingAndActivityId(String name, Long activityId) {
		return personRepo.findByNameIgnoreCaseContainingAndActivityListId(name, activityId);
	}

	@Override
	public List<Person> getByNameContainingAndUidContaining(String name, String uid) {
		return personRepo.findByNameIgnoreCaseContainingAndUidIgnoreCaseContaining(name, uid);
	}

	@Override
	public List<Person> getByUidContainingAndActivityId(String uid, Long activityId) {
		return personRepo.findByUidIgnoreCaseContainingAndActivityListId(uid, activityId);
	}

	@Override
	public List<Person> getByFirstNameContainingAndActivityId(String firstName, Long activityId) {
		return personRepo.findByFirstNameIgnoreCaseContainingAndActivityListId(firstName, activityId);
	}

	@Override
	public List<Person> getByFirstNameContainingAndUidContaining(String firstName, String uid) {
		return personRepo.findByFirstNameIgnoreCaseContainingAndUidIgnoreCaseContaining(firstName, uid);
	}

	@Override
	public List<Person> getByFirstNameContainingAndUidContainingAndActivityId(String firstName, String uid,
			Long activityId) {
		return personRepo.findByFirstNameIgnoreCaseContainingAndUidIgnoreCaseContainingAndActivityListId(firstName, uid,
				activityId);
	}

	@Override
	public List<Person> getByNameContainingAndFirstNameContainingAndUidContainingAndActivityId(String name,
			String firstName, String uid, Long activityId) {
		return personRepo
				.findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContainingAndUidIgnoreCaseContainingAndActivityListId(
						name, firstName, uid, activityId);
	}

}
