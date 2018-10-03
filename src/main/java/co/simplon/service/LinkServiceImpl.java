package co.simplon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.model.Link;
import co.simplon.repo.LinkRepo;

@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkRepo linkRepo;

	@Override
	public List<Link> getAll() {
		return linkRepo.findAll();
	}

	@Override
	public List<Link> getByLinkTypeId(Long linkTypeId) {
		return linkRepo.findByLinkTypeId(linkTypeId);
	}

	@Override
	public List<Link> getByActivityIdAndLinkTypeId(Long activityId, Long linkTypeId) {
		return linkRepo.findByActivityIdAndLinkTypeId(activityId, linkTypeId);
	}

	@Override
	public List<Link> getByTitleContaining(String input) {
		return linkRepo.findByTitleIgnoreCaseContaining(input);
	}

	@Override
	public List<Link> getByActivityId(Long activityId) {
		return linkRepo.findByActivityId(activityId);
	}

	@Override
	public List<Link> getByActivityIdAndTitleContaining(Long activityId, String input) {
		return linkRepo.findByActivityIdAndTitleIgnoreCaseContaining(activityId, input);
	}

	@Override
	public List<Link> getByActivityIdAndLinkTypeIdAndTitleContaining(Long activityId, Long linkTypeId, String input) {
		return linkRepo.findByActivityIdAndLinkTypeIdAndTitleIgnoreCaseContaining(activityId, linkTypeId, input);
	}

	@Override
	public List<Link> getByLinkTypeIdAndTitleContaining(String input, Long linkTypeId) {
		return linkRepo.findByLinkTypeIdAndTitleIgnoreCaseContaining(linkTypeId, input);
	}

}
