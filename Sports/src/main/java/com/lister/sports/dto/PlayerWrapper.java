/**
 * 
 */
package com.lister.sports.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO Wrapper class for Player DO.
 * 
 * @author sai_pranav
 *
 */
public class PlayerWrapper {

	private List<PlayerModel> players;
	
	public List<PlayerModel> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerModel> players) {
		this.players = players;
	}
	
	public PlayerWrapper(){
		players = new ArrayList<PlayerModel>();
	}
}
