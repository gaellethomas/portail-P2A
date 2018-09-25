package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Activity;
import co.simplon.model.Link;
import co.simplon.model.LinkType;

@Repository
public interface LinkRepo extends JpaRepository<Link, Long> {

	/*
	 * public List<Link> findByTitleLink(String titleLink);
	 * 
	 * public List<Link> findByTitleLinkStartsWith(String titleLink);
	 */

	public List<Link> findByActivityLink(Activity activity);

	public List<Link> findByLinkType(LinkType linkType);
	/*
	 * public List<Link> findByActivityLinkAndLinkType(Activity activity, LinkType
	 * linkType);
	 * 
	 * public List<Link> findByActivityLinkAndTitleLinkStartsWith(Activity activity,
	 * String titleLink);
	 * 
	 * public List<Link>
	 * findByActivityLinkAndLinkTypeAndTitleLinkStartsWith(Activity activity,
	 * LinkType linkType, String titleLink);
	 */

}
