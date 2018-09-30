package co.simplon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.Person;
import co.simplon.service.PersonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/person")
	@GetMapping
	// give an object Json type
	// display persons of team P2A, separated contacts, in fonction
	// activity
	// 2 param: 1 = p2a or not ; 2 = which activity
	public ResponseEntity<List<Person>> displayPerson(@RequestParam("belongP2a") Optional<String> p2aStrOpt,
			@RequestParam("activityId") Optional<String> activityIdStrOpt) {

		ResponseEntity<List<Person>> result = null;

		if (!p2aStrOpt.isPresent() && !activityIdStrOpt.isPresent()) {
			// all persons, not used in front
			result = new ResponseEntity<List<Person>>(personService.getAll(), HttpStatus.OK);

		} else {

			if (p2aStrOpt.isPresent()) {
				try {
					Boolean p2a = Boolean.parseBoolean(p2aStrOpt.get());
					if (p2a) {
						// p2a members
						if (activityIdStrOpt.isPresent()) {
							// all p2a members filtered by activity
							try {
								Long activityId = Long.parseLong(activityIdStrOpt.get());
								List<Person> personList = personService.getByTeamP2a(activityId);
								result = new ResponseEntity<List<Person>>(personList,
										personList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
							} catch (Exception e) {
								// param activity not correct
								e.printStackTrace();
								result = new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
							}

						} else {
							// param activity is missing
							result = new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
						}

					} else {
						// others members = contacts
						if (activityIdStrOpt.isPresent()) {
							// all other contacts filtered by activity
							try {
								Long activityId = Long.parseLong(activityIdStrOpt.get());
								List<Person> personList = personService.getByTeamOthers(activityId);
								result = new ResponseEntity<List<Person>>(personList,
										personList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
							} catch (Exception e) {
								// param activity not correct
								e.printStackTrace();
								result = new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
							}

						} else {
							// param activity is missing
							result = new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
						}
					}
				} catch (Exception e) {
					// param p2a not correct
					e.printStackTrace();
					result = new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
				}
			} else {
				// param p2a missing
				result = new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
			}
		}
		return result;
	}

}
