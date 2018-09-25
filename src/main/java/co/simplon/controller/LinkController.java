package co.simplon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.Link;
import co.simplon.model.LinkType;
import co.simplon.service.LinkServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/link")
public class LinkController {

	private LinkServiceImpl linkServiceImpl;

	public LinkController(LinkServiceImpl linkServiceImpl) {
		this.linkServiceImpl = linkServiceImpl;
	}

	// revoir toutes les methodes si on affiche les proc d un cote et les liens de l
	// autre

	@RequestMapping("/commun")
	@GetMapping
	public List<Link> displayAllLink() {
		return linkServiceImpl.getAll();
	}

	@RequestMapping("/commun/{linkType}")
	@GetMapping
	public List<Link> displayAllByLinkType(@PathVariable("linkType") LinkType linkType) {
		return linkServiceImpl.getByLinkType(linkType);
	}

	/*
	 * display all link in accordance with activity page
	 * 
	 * @RequestMapping("/{activity}")
	 * 
	 * @GetMapping public List<Link> displayLinkByActivity(@PathVariable("activity")
	 * Activity activity) { return linkServiceImpl.getByActivity(activity); }
	 */

}
