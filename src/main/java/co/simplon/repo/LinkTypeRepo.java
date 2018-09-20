package co.simplon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.LinkType;

@Repository
public interface LinkTypeRepo extends JpaRepository<LinkType, Long> {

	// only getAll to autocomplete
}
