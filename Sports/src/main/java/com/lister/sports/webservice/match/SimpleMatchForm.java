package com.lister.sports.webservice.match;

import java.util.List;

/**
 * @author sai_pranav
 *
 */
public class SimpleMatchForm {

	private List<String> teams; 
	private int round;
	private String scheduledTime;
	private String location;
	private String status;
	private String winner;
	private String score;
	
	public List<String> getTeams() {
		return teams;
	}
	public void setTeams(List<String> teams) {
		this.teams = teams;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getScheduledTime() {
		return scheduledTime;
	}
	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}
