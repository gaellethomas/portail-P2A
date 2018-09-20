package co.simplon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.Access;
import co.simplon.model.Activity;
import co.simplon.service.AccessServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/access")
public class AccessController {

	private AccessServiceImpl accessServiceImpl;

	public AccessController(AccessServiceImpl accessServiceImpl) {
		this.accessServiceImpl = accessServiceImpl;
	}

	// revoir toutes les methodes si on affiche les proc d un cote et les liens de l
	// autre

	@RequestMapping("/commun")
	@GetMapping
	public List<Access> displayAllAccess() {
		return accessServiceImpl.getAll();
	}

	// display all link in accordance with activity page
	@RequestMapping("/{activity}")
	@GetMapping
	public List<Access> displayAccessByActivity(@PathVariable("activity") Activity activity) {
		return accessServiceImpl.getByActivity(activity);
	}

}
