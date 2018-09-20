package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Activity;
import co.simplon.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	public List<Person> findByName(String name);

	public List<Person> findByNameStartsWith(String name);

	public List<Person> findByUid(String uid);

	public List<Person> findByFirstName(String firstName);

	public List<Person> findByNameAndFirstName(String name, String firstName);

	public List<Person> findByNameAndFirstNameAndUid(String name, String firstName, String uid);

	// volonte de rechercher une personne par son appartenance a une activité de sa
	// liste, pas sure du result,a tester
	public List<Person> findByActivityListIsIn(Activity activity);
}
