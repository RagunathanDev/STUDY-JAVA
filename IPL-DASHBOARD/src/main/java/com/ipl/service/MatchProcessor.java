package com.ipl.service;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import com.ipl.model.Match;
import com.ipl.model.MatchInput;

public class MatchProcessor implements ItemProcessor<MatchInput, Match> {

	@Override
	public Match process(MatchInput matchInput) throws Exception {
		Match match = new Match();
		match.setId(Long.parseLong(matchInput.getId()));
		match.setCity(matchInput.getCity());
		match.setDate(LocalDate.parse(matchInput.getDate()));
		match.setPlayerOfMatch(matchInput.getPlayer_of_match());
		match.setVenue(matchInput.getVenue());

		String team1, team2;
		if ("bat".equals(matchInput.getToss_decision())) {
			team1 = matchInput.getToss_winner();
			team2 = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2()
					: matchInput.getTeam1();
		} else {
			team2 = matchInput.getToss_winner();
			team1 = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2()
					: matchInput.getTeam1();
		}

		match.setTeam1(team1);
		match.setTeam2(team2);
		match.setTossWinner(matchInput.getToss_winner());
		match.setMatchWinner(matchInput.getWinner());
		match.setResult(matchInput.getResult());
		match.setResultMargin(matchInput.getResult_margin());
		match.setEliminator(matchInput.getEliminator());
		match.setMethod(matchInput.getMethod());
		match.setUmpire1(matchInput.getUmpire1());
		match.setUmpire2(matchInput.getUmpire2());
		return match;
	}

}
