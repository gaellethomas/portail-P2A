package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Access;
import co.simplon.model.Activity;

@Service
public interface AccessService {

	public List<Access> getAll();

	/* public List<Access> getByTitle(String titleAccess); */

	/* public List<Access> getByTitleStartWith(String name); */

	public List<Access> getByActivity(Activity activity);

	/*
	 * public List<Access> getByLinkType(LinkType linkType);
	 * 
	 * public List<Access> getByActivityAndByLinkType(Activity activity, LinkType
	 * linkType);
	 * 
	 * public List<Access> getByActivityAndByTitleStartWith(Activity activity,
	 * String titleAccess);
	 * 
	 * public List<Access>
	 * getByActivityAccessAndLinkTypeAndTitleAccessStartsWith(Activity activity,
	 * LinkType linkType, String titleAccess);
	 */
}
