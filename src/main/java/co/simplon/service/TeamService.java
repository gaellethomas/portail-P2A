package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Team;

@Service
public interface TeamService {

	public List<Team> getAll();

}
