package co.simplon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Activity;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {

	// only getAll to autocomplete
}
