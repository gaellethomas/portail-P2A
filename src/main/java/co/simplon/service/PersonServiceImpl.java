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
	public List<Person> getByNameContaining(String name) {
		// TODO Auto-generated method stub
		return personRepo.findByNameContaining(name);
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
	public List<Person> getByTeamP2a(Long activityId) {
		Team teamP2a = teamService.getByName("P2A");
		// choose 0 to mean "without activity"
		// if (activityId == 0) {
		// return personRepo.findByTeam(teamP2a);
		// } else {
		return personRepo.findByTeamAndActivityListId(teamP2a, activityId);
	}
	// }

	@Override
	public List<Person> getByTeamOthers(Long activityId) {
		Team teamP2a = teamService.getByName("P2A");
		return personRepo.findByTeamNotAndActivityListId(teamP2a, activityId);
	}

	@Override
	public List<Person> getByTeamOthers() {
		Team teamP2a = teamService.getByName("P2A");
		// if (activityId == 0) {
		return personRepo.findByTeamNot(teamP2a);
		// } else {
		// return personRepo.findByTeamNotAndActivityListId(teamP2a, activityId);
		// }
	}

}
