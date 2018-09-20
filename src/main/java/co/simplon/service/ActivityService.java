package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Activity;

@Service
public interface ActivityService {

	public List<Activity> getAll();

}
