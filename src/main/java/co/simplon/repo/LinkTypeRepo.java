package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.model.LinkType;

@Repository
public interface LinkTypeRepo extends JpaRepository<LinkType, Long> {

	// only getAll to autocomplete
	public List<LinkType> getAllByLinkList(@Param("activityIdToFind") Long activityId);

}
