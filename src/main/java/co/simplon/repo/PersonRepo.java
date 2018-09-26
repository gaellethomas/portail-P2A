package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Person;
import co.simplon.model.Team;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	public List<Person> findByTeam(Team team);

	// volonte de rechercher un collaborateur par son appartenance a une activité de
	// sa
	// liste, pas sure du result,a tester

	public List<Person> findByTeamAndActivityListId(Team team, Long activityListId);

	public List<Person> findByTeamNot(Team team);

	public List<Person> findByTeamNotAndActivityListId(Team team, Long activityListId);

	public List<Person> findByName(String name);

	public List<Person> findByNameContaining(String name);

	public List<Person> findByUid(String uid);

	public List<Person> findByFirstName(String firstName);

	public List<Person> findByNameAndFirstName(String name, String firstName);

	public List<Person> findByNameAndFirstNameAndUid(String name, String firstName, String uid);

}
