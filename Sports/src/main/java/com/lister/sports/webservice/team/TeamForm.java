package com.lister.sports.webservice.team;

import java.util.List;

import com.lister.sports.webservice.game.GameFormWithoutNumberOfPlayers;

/**
 * @author sai_pranav
 *
 */
public class TeamForm {

	private String name;
	private String rating;
	private String score;
	private int round;
	private boolean show;
	private List<Integer> players;
	private GameFormWithoutNumberOfPlayers game;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	public List<Integer> getPlayers() {
		return players;
	}
	public void setPlayers(List<Integer> players) {
		this.players = players;
	}
	public GameFormWithoutNumberOfPlayers getGame() {
		return game;
	}
	public void setGame(GameFormWithoutNumberOfPlayers game) {
		this.game = game;
	}
	
}
