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
	public ResponseEntity<List<Person>> getPerson(@RequestParam("belongP2a") Optional<String> p2aStrOpt,
			@RequestParam("nameEntered") Optional<String> nameEnteredStrOpt,
			@RequestParam("firstNameEntered") Optional<String> firstNameEnteredStrOpt,
			@RequestParam("uidEntered") Optional<String> uidEnteredStrOpt,
			@RequestParam("activityId") Optional<String> activityIdStrOpt) {
		ResponseEntity<List<Person>> result = null;
		List<Person> personSearchedList;
		int factorSearch = 0;
		String nameEntered = "";
		String firstNameEntered = "";
		String uidEntered = "";
		Long activityId = null;
		Boolean p2a;

		if (activityIdStrOpt.isPresent()) {
			try {
				activityId = Long.parseLong(activityIdStrOpt.get());
				factorSearch += 1;
			} catch (Exception e) {
				// param activity not correct, setting -1
				factorSearch = -1;
				e.printStackTrace();
			}
		}

		if (uidEnteredStrOpt.isPresent() && factorSearch != -1) {
			uidEntered = uidEnteredStrOpt.get();
			factorSearch += 10;
		}

		if (firstNameEnteredStrOpt.isPresent() && factorSearch != -1) {
			firstNameEntered = firstNameEnteredStrOpt.get();
			factorSearch += 100;
		}

		if (nameEnteredStrOpt.isPresent() && factorSearch != -1) {
			nameEntered = nameEnteredStrOpt.get();
			factorSearch += 1000;
		}

		if (p2aStrOpt.isPresent() && factorSearch != -1) {
			try {
				p2a = Boolean.parseBoolean(p2aStrOpt.get());
				if (p2a) {
					factorSearch += 10000;
				} else {
					factorSearch += 20000;
				}
			} catch (Exception e) {
				// param activity not correct, setting -1
				factorSearch = -1;
				e.printStackTrace();
			}
		}

		if (factorSearch != -1) {
			// if all parameters received are good
			switch (factorSearch) {

			case 1: {
				// all persons by activity chosen
				personSearchedList = personService.getByActivityId(activityId);
				break;
			}
			case 10: {
				// all persons by uid chosen
				personSearchedList = personService.getByUidContaining(uidEntered);
				break;
			}
			case 11: {
				// all persons by activity and uid selected
				personSearchedList = personService.getByUidContainingAndActivityId(uidEntered, activityId);
				break;
			}
			case 100: {
				// all persons by firstname
				personSearchedList = personService.getByFirstNameContaining(firstNameEntered);
				break;
			}
			case 101: {
				// all persons by activity selected and firstName entered
				personSearchedList = personService.getByFirstNameContainingAndActivityId(firstNameEntered, activityId);
				break;
			}
			case 110: {
				// all persons by firstname and uid entered
				personSearchedList = personService.getByFirstNameContainingAndUidContaining(firstNameEntered,
						uidEntered);
				break;
			}
			case 111: {
				// all persons by firstname and uid entered, and activityid selected
				personSearchedList = personService.getByFirstNameContainingAndUidContainingAndActivityId(
						firstNameEntered, uidEntered, activityId);
				break;
			}
			case 1000: {
				// all persons by name
				personSearchedList = personService.getByNameContaining(nameEntered);
				break;
			}
			case 1001: {
				// all persons by name and activity entered
				personSearchedList = personService.getByNameContainingAndActivityId(nameEntered, activityId);
				break;
			}
			case 1010: {
				// all persons by name and uid
				personSearchedList = personService.getByNameContainingAndUidContaining(nameEntered, uidEntered);
				break;
			}
			case 1100: {
				// all persons by name and firstName entered
				personSearchedList = personService.getByNameContainingAndFirstNameContaining(nameEntered,
						firstNameEntered);
				break;
			}
			case 1101: {
				// all persons by name firstname and activity
				personSearchedList = personService.getByNameContainingAndFirstNameContainingAndActivityId(nameEntered,
						firstNameEntered, activityId);
				break;
			}
			case 1110: {
				// all persons by name firstname and uid entered
				personSearchedList = personService.getByNameContainingAndFirstNameContainingAndUidContaining(
						nameEntered, firstNameEntered, uidEntered);
				break;
			}
			case 1111: {
				// all persons by name firstname uid and activity entered
				personSearchedList = personService
						.getByNameContainingAndFirstNameContainingAndUidContainingAndActivityId(nameEntered,
								firstNameEntered, uidEntered, activityId);
				break;
			}

			case 10001: {
				// all persons by belong team P2a, and activity chosen
				personSearchedList = personService.getByTeamP2a(activityId);
				break;
			}

			case 20001: {
				// all persons by not belong team P2a, and activity chosen
				personSearchedList = personService.getByTeamOthers(activityId);
				break;
			}

			default: {
				// no parameter return all persons
				personSearchedList = personService.getAll();
				break;
			}
			}
			result = new ResponseEntity<List<Person>>(personSearchedList,
					personSearchedList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);

		} else {
			// if at least one parameter is not correct
			result = new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

}
