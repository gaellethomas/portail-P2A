package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Link;

@Service
public interface LinkService {

	public List<Link> getAll();

	public List<Link> getByLinkTypeId(Long linkTypeId);

	public List<Link> getByActivityIdAndLinkTypeId(Long activityId, Long linkTypeId);

	public List<Link> getByLinkTypeIdAndTitleContaining(String input, Long linkTypeId);

	public List<Link> getByTitleContaining(String input);

	public List<Link> getByActivityId(Long activityId);

	public List<Link> getByActivityIdAndTitleContaining(Long activityId, String input);

	public List<Link> getByActivityIdAndLinkTypeIdAndTitleContaining(Long activityId, Long linkTypeId, String input);

}
