package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Person;
import co.simplon.model.Team;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	public List<Person> findByActivityListId(Long activityListId);

	public List<Person> findByTeamAndActivityListId(Team team, Long activityListId);

	public List<Person> findByTeamNotAndActivityListId(Team team, Long activityListId);

	public List<Person> findByName(String name);

	public List<Person> findByNameIgnoreCaseContaining(String name);

	public List<Person> findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContaining(String name, String firstName);

	public List<Person> findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContainingAndActivityListId(String name,
			String firstName, Long activityListId);

	public List<Person> findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContainingAndUidIgnoreCaseContaining(
			String name, String firstName, String uid);

	public List<Person> findByNameIgnoreCaseContainingAndActivityListId(String name, Long activityListId);

	public List<Person> findByNameIgnoreCaseContainingAndUidIgnoreCaseContaining(String name, String uid);

	public List<Person> findByUidIgnoreCaseContaining(String uid);

	public List<Person> findByUidIgnoreCaseContainingAndActivityListId(String uid, Long activityListId);

	public List<Person> findByFirstNameIgnoreCaseContaining(String firstName);

	public List<Person> findByFirstNameIgnoreCaseContainingAndActivityListId(String firstName, Long activityListId);

	public List<Person> findByFirstNameIgnoreCaseContainingAndUidIgnoreCaseContaining(String firstName, String uid);

	public List<Person> findByFirstNameIgnoreCaseContainingAndUidIgnoreCaseContainingAndActivityListId(String firstName,
			String uid, Long activityListId);

	public List<Person> findByNameIgnoreCaseContainingAndFirstNameIgnoreCaseContainingAndUidIgnoreCaseContainingAndActivityListId(
			String name, String firstName, String uid, Long activityListId);
}
