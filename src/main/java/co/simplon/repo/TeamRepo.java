package co.simplon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {

	// getAll for drop dowm menu, to create person in database
	// save all teams existing in database

}
