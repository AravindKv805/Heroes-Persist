package com.lister.sports.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sai_pranav
 *
 */
@Entity
@Table(name="team")
public class Team {

	@Id
	@GenericGenerator(name="team_seq_gen" , strategy="increment")
	@GeneratedValue(generator="team_seq_gen")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "score")
	private String score;
	
	@Column(name = "round")
	private int round;
	
	@Column(name = "show")
	private boolean show;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="team_player",joinColumns={@JoinColumn(name="team_id")},inverseJoinColumns={@JoinColumn(name="employee_id")})
	private List<Player> players = new ArrayList<Player>();
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name="team_game",joinColumns={@JoinColumn(name="team_id")},inverseJoinColumns={@JoinColumn(name="game_id")})
	private Game game;

	public Team(){}
	
	public Team(String name,String rating, String score, int round){
		this.name = name;
		this.rating = rating;
		this.score = score;
		this.round = round;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
