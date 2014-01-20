package com.lister.sports.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author sai_pranav
 *
 */
@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="match")
public class Match {

	@Id
	@GenericGenerator(name="match_seq_gen" , strategy="increment")
	@GeneratedValue(generator="match_seq_gen")
	@Column(name = "id")
	private int id;
	
	@Column(name = "round")
	private int round;
	
	@Column(name = "scheduled_time")
	private String scheduledTime;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "winner")
	private String winner;
	
	@Column(name = "score")
	private String score;
	
	@Column(name = "show")
	private boolean show;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name="match_game",joinColumns={@JoinColumn(name="match_id")},inverseJoinColumns={@JoinColumn(name="game_id")})
	private Game game;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name="match_teams",joinColumns={@JoinColumn(name="match_id")},inverseJoinColumns={@JoinColumn(name="team_id")})
	private List<Team> teams = new ArrayList<Team>();
	
	public Match(){}
	
	public Match(int round, String time, String location, String status, String winner, String score, boolean show){
		this.round = round;
		this.scheduledTime = time;
		this.location = location;
		this.status = status;
		this.winner = winner;
		this.score = score;
		this.show = show;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

}
