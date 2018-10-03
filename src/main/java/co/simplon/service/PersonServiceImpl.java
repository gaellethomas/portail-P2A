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
		return personRepo.findByNameContaining(name);
	}

	@Override
	public List<Person> getByUid(String uid) {
		return personRepo.findByUid(uid);
	}

	@Override
	public List<Person> getByFirstNameContaining(String firstName) {
		// TODO Auto-generated method stub
		return personRepo.findByFirstNameContaining(firstName);
	}

	@Override
	public List<Person> getByNameContainingAndFirstNameContaining(String name, String firstName) {
		// TODO Auto-generated method stub
		return personRepo.findByNameContainingAndFirstNameContaining(name, firstName);
	}

	@Override
	public List<Person> getByNameContainingAndFirstNameContainingAndUid(String name, String firstName, String uid) {
		// TODO Auto-generated method stub
		return personRepo.findByNameContainingAndFirstNameContainingAndUid(name, firstName, uid);
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

		return personRepo.findByNameContainingAndFirstNameContainingAndActivityListId(name, firstName, activityId);
	}

	@Override
	public List<Person> getByNameContainingAndActivityId(String name, Long activityId) {
		return personRepo.findByNameContainingAndActivityListId(name, activityId);
	}

	@Override
	public List<Person> getByNameContainingAndUid(String name, String uid) {
		return personRepo.findByNameContainingAndUid(name, uid);
	}

	@Override
	public List<Person> getByUidAndActivityId(String uid, Long activityId) {
		return personRepo.findByUidAndActivityListId(uid, activityId);
	}

	@Override
	public List<Person> getByFirstNameContainingAndActivityId(String firstName, Long activityId) {
		return personRepo.findByFirstNameContainingAndActivityListId(firstName, activityId);
	}

	@Override
	public List<Person> getByFirstNameContainingAndUid(String firstName, String uid) {
		return personRepo.findByFirstNameContainingAndUid(firstName, uid);
	}

	@Override
	public List<Person> getByFirstNameContainingAndUidAndActivityId(String firstName, String uid, Long activityId) {
		return personRepo.findByFirstNameContainingAndUidAndActivityListId(firstName, uid, activityId);
	}

	@Override
	public List<Person> getByNameContainingAndFirstNameContainingAndUidAndActivityId(String name, String firstName,
			String uid, Long activityId) {
		return personRepo.findByNameContainingAndFirstNameContainingAndUidAndActivityListId(name, firstName, uid,
				activityId);
	}

}
