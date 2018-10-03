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

import co.simplon.model.Link;
import co.simplon.service.LinkService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class LinkController {

	@Autowired
	private LinkService linkService;

	@RequestMapping("/link")
	@GetMapping
	public ResponseEntity<List<Link>> getLink(
			@RequestParam("titleSearchedPatern") Optional<String> titleSearchedPaternStrOpt,
			@RequestParam("linkTypeId") Optional<String> linkTypeIdStrOpt,
			@RequestParam("activityId") Optional<String> activityIdStrOpt) {
		ResponseEntity<List<Link>> result = null;
		List<Link> linkList;
		int factorSearch = 0;
		Long activityId = null;
		Long linkTypeId = null;
		String titleSearchedPatern = "";

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

		if (linkTypeIdStrOpt.isPresent() && factorSearch != -1) {
			try {
				linkTypeId = Long.parseLong(linkTypeIdStrOpt.get());
				factorSearch += 10;
			} catch (Exception e) {
				// param linkType not correct, setting -1
				factorSearch = -1;
				e.printStackTrace();
			}
		}

		if (titleSearchedPaternStrOpt.isPresent() && factorSearch != -1) {
			titleSearchedPatern = titleSearchedPaternStrOpt.get();
			factorSearch += 100;
		}

		// if all parameters received are good
		if (factorSearch != -1) {

			switch (factorSearch) {

			case 1: {
				// all links by activity chosen
				linkList = linkService.getByActivityId(activityId);
				break;
			}
			case 10: {
				// all links by typeLink chosen
				linkList = linkService.getByLinkTypeId(linkTypeId);
				break;
			}
			case 11: {
				// all links by activity and linkType chosen
				linkList = linkService.getByActivityIdAndLinkTypeId(activityId, linkTypeId);
				break;
			}
			case 100: {
				// all links containing word entered
				linkList = linkService.getByTitleContaining(titleSearchedPatern);
				break;
			}
			case 101: {
				// all links by activity chosen and containing word entered
				linkList = linkService.getByActivityIdAndTitleContaining(activityId, titleSearchedPatern);
				break;
			}
			case 110: {
				// all links by linkType chosen and containing word entered
				linkList = linkService.getByLinkTypeIdAndTitleContaining(titleSearchedPatern, linkTypeId);
				break;
			}
			case 111: {
				// all links by 3 parameters
				linkList = linkService.getByActivityIdAndLinkTypeIdAndTitleContaining(activityId, linkTypeId,
						titleSearchedPatern);
				break;
			}
			default: {
				// all links
				linkList = linkService.getAll();
				break;
			}
			}
			result = new ResponseEntity<List<Link>>(linkList,
					linkList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);

		} else {
			// if at least one parameter is not correct
			result = new ResponseEntity<List<Link>>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}
}
