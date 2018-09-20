package co.simplon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Access;
import co.simplon.model.Activity;

@Repository
public interface AccessRepo extends JpaRepository<Access, Long> {

	/*
	 * public List<Access> findByTitleAccess(String titleAccess);
	 * 
	 * public List<Access> findByTitleAccessStartsWith(String titleAccess);
	 */

	public List<Access> findByActivityAccess(Activity activity);

	/*
	 * public List<Access> findByLinkType(LinkType linkType);
	 * 
	 * public List<Access> findByActivityAccessAndLinkType(Activity activity,
	 * LinkType linkType);
	 * 
	 * public List<Access> findByActivityAccessAndTitleAccessStartsWith(Activity
	 * activity, String titleAccess);
	 * 
	 * public List<Access>
	 * findByActivityAccessAndLinkTypeAndTitleAccessStartsWith(Activity activity,
	 * LinkType linkType, String titleAccess);
	 */

}
