package com.lister.sports.webservice.game;

/**
 * @author sai_pranav
 *
 */
public class GameForm {

	private String name;
	private String category;
	private int noPlayers;
	
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
