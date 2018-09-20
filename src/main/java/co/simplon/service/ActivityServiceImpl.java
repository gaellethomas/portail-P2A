package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Activity;
import co.simplon.repo.ActivityRepo;

@Service
public class ActivityServiceImpl implements ActivityService {

	private ActivityRepo activityRepo;

	@Override
	public List<Activity> getAll() {
		// TODO Auto-generated method stub
		return activityRepo.findAll();
	}

}
