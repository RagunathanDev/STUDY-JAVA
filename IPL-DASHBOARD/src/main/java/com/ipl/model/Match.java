package com.ipl.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {

	@Id
	private Long id;
	private String city;
	private LocalDate date;
	private String playerOfMatch;
	private String venue;
	private String team1;
	private String team2;
	private String tossWinner;
	private String tossDecision;
	private String matchWinner;
	private String result;
	private String resultMargin;
	private String eliminator;
	private String method;
	private String umpire1;
	private String umpire2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlayerOfMatch() {
		return playerOfMatch;
	}

	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getTossWinner() {
		return tossWinner;
	}

	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}

	public String getTossDecision() {
		return tossDecision;
	}

	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}

	public String getMatchWinner() {
		return matchWinner;
	}

	public void setMatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultMargin() {
		return resultMargin;
	}

	public void setResultMargin(String resultMargin) {
		this.resultMargin = resultMargin;
	}

	public String getEliminator() {
		return eliminator;
	}

	public void setEliminator(String eliminator) {
		this.eliminator = eliminator;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUmpire1() {
		return umpire1;
	}

	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}

	public String getUmpire2() {
		return umpire2;
	}

	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}

	public Match(Long id, String city, LocalDate date, String playerOfMatch, String venue, String team1, String team2,
			String tossWinner, String tossDecision, String matchWinner, String result, String resultMargin,
			String eliminator, String method, String umpire1, String umpire2) {
		super();
		this.id = id;
		this.city = city;
		this.date = date;
		this.playerOfMatch = playerOfMatch;
		this.venue = venue;
		this.team1 = team1;
		this.team2 = team2;
		this.tossWinner = tossWinner;
		this.tossDecision = tossDecision;
		this.matchWinner = matchWinner;
		this.result = result;
		this.resultMargin = resultMargin;
		this.eliminator = eliminator;
		this.method = method;
		this.umpire1 = umpire1;
		this.umpire2 = umpire2;
	}

	public Match() {

	}

	@Override
	public String toString() {
		return "Match [city=" + city + ", date=" + date + ", eliminator=" + eliminator + ", id=" + id + ", matchWinner="
				+ matchWinner + ", method=" + method + ", playerOfMatch=" + playerOfMatch + ", result=" + result
				+ ", resultMargin=" + resultMargin + ", team1=" + team1 + ", team2=" + team2 + ", tossDecision="
				+ tossDecision + ", tossWinner=" + tossWinner + ", umpire1=" + umpire1 + ", umpire2=" + umpire2
				+ ", venue=" + venue + "]";
	}
}
