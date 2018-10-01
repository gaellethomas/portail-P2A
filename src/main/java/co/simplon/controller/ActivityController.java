package co.simplon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.Activity;
import co.simplon.service.ActivityService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping("/activity")
	@GetMapping
	public ResponseEntity<List<Activity>> displayActivity() {
		ResponseEntity<List<Activity>> result = null;
		result = new ResponseEntity<List<Activity>>(activityService.getAll(), HttpStatus.OK);
		return result;
	}
}
