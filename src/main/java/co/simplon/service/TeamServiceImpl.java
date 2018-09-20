package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Team;
import co.simplon.repo.TeamRepo;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepo teamRepo;

	@Override
	public List<Team> getAll() {
		// TODO Auto-generated method stub
		return teamRepo.findAll();
	}

}
