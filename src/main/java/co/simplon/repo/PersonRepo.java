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

	public List<Person> findByNameContaining(String name);

	public List<Person> findByNameContainingAndFirstNameContaining(String name, String firstName);

	public List<Person> findByNameContainingAndFirstNameContainingAndActivityListId(String name, String firstName,
			Long activityListId);

	public List<Person> findByNameContainingAndFirstNameContainingAndUid(String name, String firstName, String uid);

	public List<Person> findByNameContainingAndActivityListId(String name, Long activityListId);

	public List<Person> findByNameContainingAndUid(String name, String uid);

	public List<Person> findByUid(String uid);

	public List<Person> findByUidAndActivityListId(String uid, Long activityListId);

	public List<Person> findByFirstNameContaining(String firstName);

	public List<Person> findByFirstNameContainingAndActivityListId(String firstName, Long activityListId);

	public List<Person> findByFirstNameContainingAndUid(String firstName, String uid);

	public List<Person> findByFirstNameContainingAndUidAndActivityListId(String firstName, String uid,
			Long activityListId);

	public List<Person> findByNameContainingAndFirstNameContainingAndUidAndActivityListId(String name, String firstName,
			String uid, Long activityListId);
}
