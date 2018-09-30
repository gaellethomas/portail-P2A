package co.simplon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.model.LinkType;
import co.simplon.repo.LinkTypeRepo;

@Service
public class LinkTypeServiceImpl implements LinkTypeService {

	@Autowired
	private LinkTypeRepo linkTypeRepo;

	@Override
	public List<LinkType> getAll() {
		return linkTypeRepo.findAll();
	}

	@Override
	public List<LinkType> getAllByActivityId(Long activityId) {
		return linkTypeRepo.getAllByLinkList(activityId);
	}

}
