package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.LinkType;

@Service
public interface LinkTypeService {

	public List<LinkType> getAll();

	public List<LinkType> getAllByActivityId(Long activityId);

}
