package com.ipl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.model.Team;
import com.ipl.repository.MatchRepository;
import com.ipl.repository.TeamRepository;

@RestController
public class TeamController {

	@Autowired
	private TeamRepository teamRepo;

	@Autowired
	private MatchRepository matchRepo;

	public void getTeamRepository(TeamRepository teamRepo, MatchRepository matchRepo) {
		this.teamRepo = teamRepo;
		this.matchRepo = matchRepo;
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {

		Team team = this.teamRepo.findByTeamName(teamName);
		team.setMatches(this.matchRepo.findLatestMatchByTeam(teamName, 4));
		return team;
	}
}
