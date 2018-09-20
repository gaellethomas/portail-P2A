package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.LinkType;
import co.simplon.repo.LinkTypeRepo;

@Service
public class LinkTypeServiceImpl implements LinkTypeService {

	private LinkTypeRepo linkTypeRepo;

	@Override
	public List<LinkType> getAll() {
		// TODO Auto-generated method stub
		return linkTypeRepo.findAll();
	}

}
