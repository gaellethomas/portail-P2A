package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Access;
import co.simplon.model.Activity;
import co.simplon.repo.AccessRepo;

@Service
public class AccessServiceImpl implements AccessService {

	private AccessRepo accessRepo;

	public AccessServiceImpl(AccessRepo accessRepo) {
		this.accessRepo = accessRepo;
	}

	@Override
	public List<Access> getAll() {
		return accessRepo.findAll();
	}

	/*
	 * @Override public List<Access> getByTitleStartWith(String name) { return
	 * accessRepo.findByTitleAccessStartsWith(name); }
	 */

	@Override
	public List<Access> getByActivity(Activity activity) {
		return accessRepo.findByActivityAccess(activity);
	}

	/*
	 * @Override public List<Access> getByActivityAndByLinkType(Activity activity,
	 * LinkType linkType) { return
	 * accessRepo.findByActivityAccessAndLinkType(activity, linkType); }
	 * 
	 * @Override public List<Access> getByActivityAndByTitleStartWith(Activity
	 * activity, String titleAccess) { return
	 * accessRepo.findByActivityAccessAndTitleAccessStartsWith(activity,
	 * titleAccess); }
	 * 
	 * @Override public List<Access> getByTitle(String titleAccess) { // TODO
	 * Auto-generated method stub return accessRepo.findByTitleAccess(titleAccess);
	 * }
	 * 
	 * @Override public List<Access> getByLinkType(LinkType linkType) { // TODO
	 * Auto-generated method stub return accessRepo.findByLinkType(linkType); }
	 * 
	 * @Override public List<Access>
	 * getByActivityAccessAndLinkTypeAndTitleAccessStartsWith(Activity activity,
	 * LinkType linkType, String titleAccess) { // TODO Auto-generated method stub
	 * return null; }
	 */

}
