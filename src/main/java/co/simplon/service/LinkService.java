package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Link;
import co.simplon.model.LinkType;

@Service
public interface LinkService {

	public List<Link> getAll();

	/* public List<Link> getByTitle(String titleLink); */

	/*
	 * public List<Link> getByTitleStartWith(String name);
	 * 
	 * public List<Link> getByActivity(Activity activity);
	 */

	public List<Link> getByLinkType(LinkType linkType);

	/*
	 * public List<Link> getByActivityAndByLinkType(Activity activity, LinkType
	 * linkType);
	 * 
	 * public List<Link> getByActivityAndByTitleStartWith(Activity activity, String
	 * titleLink);
	 * 
	 * public List<Link> getByActivityLinkAndLinkTypeAndTitleLinkStartsWith(Activity
	 * activity, LinkType linkType, String titleLink);
	 */
}
