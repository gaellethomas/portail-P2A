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
	public ResponseEntity<List<Link>> displayLink(@RequestParam("typeLinkId") Optional<String> linkTypeIdStrOpt,
			@RequestParam("activityId") Optional<String> activityIdStrOpt) {
		ResponseEntity<List<Link>> result = null;

		if (!linkTypeIdStrOpt.isPresent() && !activityIdStrOpt.isPresent()) {
			// all links, even if not used in front
			result = new ResponseEntity<List<Link>>(linkService.getAll(), HttpStatus.OK);

		} else {
			if (linkTypeIdStrOpt.isPresent()) {
				try {
					Long linkTypeId = Long.parseLong(linkTypeIdStrOpt.get());
					if (activityIdStrOpt.isPresent()) {
						try {
							// link filtered by linkTypeId and activityId
							Long activityId = Long.parseLong(activityIdStrOpt.get());
							List<Link> linkList = linkService.getByActivityIdAndLinkTypeId(activityId, linkTypeId);
							result = new ResponseEntity<List<Link>>(linkList,
									linkList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);

						} catch (Exception e) {
							// param activity not correct
							e.printStackTrace();
							result = new ResponseEntity<List<Link>>(HttpStatus.BAD_REQUEST);
						}

					} else {
						// param activity missing
						result = new ResponseEntity<List<Link>>(HttpStatus.BAD_REQUEST);
					}

				} catch (Exception e) {
					// param linkTypeId not correct
					e.printStackTrace();
					result = new ResponseEntity<List<Link>>(HttpStatus.BAD_REQUEST);
				}

			} else {
				// param typeLink missing
				result = new ResponseEntity<List<Link>>(HttpStatus.BAD_REQUEST);
			}
		}
		return result;
	}

	/*
	 * @RequestMapping("/commun/{linkType}")
	 * 
	 * @GetMapping public ResponseEntity<List<Link>>
	 * displayAllByLinkType(@PathVariable("linkType") LinkType linkType) { return
	 * linkService.getByLinkType(linkType); }
	 * 
	 * 
	 * display all link in accordance with activity page
	 * 
	 * @RequestMapping("/{activity}")
	 * 
	 * @GetMapping public List<Link> displayLinkByActivity(@PathVariable("activity")
	 * Activity activity) { return linkServiceImpl.getByActivity(activity); }
	 */

}
