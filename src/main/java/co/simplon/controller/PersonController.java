package co.simplon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.Activity;
import co.simplon.model.Person;
import co.simplon.service.PersonServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
// revoir les request mapping selon le choix client
@RequestMapping("/person")
public class PersonController {

	private PersonServiceImpl personServiceImpl;

	@GetMapping
	public List<Person> displayAllPerson() {
		return personServiceImpl.getAll();
	}

	@RequestMapping("/{activity}")
	@GetMapping
	public List<Person> displayPersonByActivity(@PathVariable("activity") Activity activity) {
		return personServiceImpl.findByActivityListIsIn(activity);
	}

}
