package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Link;
import co.simplon.repo.LinkRepo;

@Service
public class LinkServiceImpl implements LinkService {

	private LinkRepo linkRepo;

	public LinkServiceImpl(LinkRepo linkRepo) {
		this.linkRepo = linkRepo;
	}

	@Override
	public List<Link> getAll() {
		return linkRepo.findAll();
	}

	/*
	 * @Override public List<Link> getByTitleStartWith(String name) { return
	 * linkRepo.findByTitleLinkStartsWith(name); }
	 */

	@Override
	public List<Link> getByActivityIdAndLinkTypeId(Long activityId, Long linkTypeId) {
		return linkRepo.findByActivityIdAndLinkTypeId(activityId, linkTypeId);
	}

	/*
	 * @Override public List<Link> getByActivityAndByTitleStartWith(Activity
	 * activity, String titleLink) { return
	 * linkRepo.findByActivityLinkAndTitleLinkStartsWith(activity, titleLink); }
	 * 
	 * @Override public List<Link> getByTitle(String titleLink) { // TODO
	 * Auto-generated method stub return linkRepo.findByTitleLink(titleLink); }
	 */

	@Override
	public List<Link> getByLinkTypeId(Long linkTypeId) {
		return linkRepo.findByLinkTypeId(linkTypeId);
	}

	/*
	 * @Override public List<Link>
	 * getByActivityLinkAndLinkTypeAndTitleLinkStartsWith(Activity activity,
	 * LinkType linkType, String titleLink) { // TODO Auto-generated method stub
	 * return null; }
	 */

}
