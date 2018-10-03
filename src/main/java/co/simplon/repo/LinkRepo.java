package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Link;

@Repository
public interface LinkRepo extends JpaRepository<Link, Long> {

	public List<Link> findByTitleIgnoreCaseContaining(String input);

	public List<Link> findByActivityId(Long activityId);

	public List<Link> findByLinkTypeId(Long linkTypeId);

	public List<Link> findByActivityIdAndLinkTypeId(Long activityId, Long linkTypeId);

	public List<Link> findByActivityIdAndTitleIgnoreCaseContaining(Long activityId, String input);

	public List<Link> findByLinkTypeIdAndTitleIgnoreCaseContaining(Long linkTypeId, String input);

	public List<Link> findByActivityIdAndLinkTypeIdAndTitleIgnoreCaseContaining(Long activityId, Long linkTypeId,
			String input);

}
