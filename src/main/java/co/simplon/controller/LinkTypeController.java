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

import co.simplon.model.LinkType;
import co.simplon.service.LinkTypeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LinkTypeController {

	@Autowired
	private LinkTypeService linkTypeService;

	@RequestMapping("/linkType")
	@GetMapping
	public ResponseEntity<List<LinkType>> getLinkType(@RequestParam("activityId") Optional<String> activityIdStrOpt) {

		ResponseEntity<List<LinkType>> result = null;

		if (activityIdStrOpt.isPresent()) {
			// filtered by activity Id
			try {
				Long activityId = Long.parseLong(activityIdStrOpt.get());
				List<LinkType> linkTypeList = linkTypeService.getAllByActivityId(activityId);
				result = new ResponseEntity<List<LinkType>>(linkTypeList,
						linkTypeList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
			} catch (Exception e) {
				// param activity not correct
				e.printStackTrace();
				result = new ResponseEntity<List<LinkType>>(HttpStatus.BAD_REQUEST);
			}

		} else {
			// return all
			try {
				List<LinkType> linkTypeList = linkTypeService.getAll();
				result = new ResponseEntity<List<LinkType>>(linkTypeList,
						linkTypeList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
			} catch (Exception e) {

				e.printStackTrace();
				result = new ResponseEntity<List<LinkType>>(HttpStatus.BAD_REQUEST);
			}
		}
		return result;
	}
}
