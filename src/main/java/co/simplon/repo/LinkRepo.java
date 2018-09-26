package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Link;

@Repository
public interface LinkRepo extends JpaRepository<Link, Long> {

	/*
	 * public List<Link> findByTitleLink(String titleLink);
	 * 
	 * public List<Link> findByTitleLinkStartsWith(String titleLink);
	 */

	public List<Link> findByActivityId(Long activityId);

	public List<Link> findByLinkTypeId(Long linkTypeId);

	public List<Link> findByActivityIdAndLinkTypeId(Long activityId, Long linkTypeId);

	/*
	 * public List<Link> findByActivityLinkAndTitleLinkStartsWith(Activity activity,
	 * String titleLink);
	 * 
	 * public List<Link>
	 * findByActivityLinkAndLinkTypeAndTitleLinkStartsWith(Activity activity,
	 * LinkType linkType, String titleLink);
	 */

}
