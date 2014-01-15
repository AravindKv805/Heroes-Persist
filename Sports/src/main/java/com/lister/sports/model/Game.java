package com.lister.sports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sai_pranav
 *
 */
@Entity
@Table(name="game")
public class Game {

	@Id
	@GenericGenerator(name="game_seq_gen" , strategy="increment")
	@GeneratedValue(generator="game_seq_gen")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "no_players")
	private int noPlayers;
	
	public Game(){}
	
	public Game(String name, String category, int noPlayers){
		this.name = name;
		this.category = category;
		this.noPlayers = noPlayers;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNoPlayers() {
		return noPlayers;
	}

	public void setNoPlayers(int noPlayers) {
		this.noPlayers = noPlayers;
	}
	
}
