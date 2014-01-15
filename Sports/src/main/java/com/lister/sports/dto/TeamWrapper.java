/**
 * 
 */
package com.lister.sports.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO Wrapper class for Team DO. It takes care of transferring the team names only.
 * 
 * @author sai_pranav
 *
 */
public class TeamWrapper {

	private List<TeamModel> teams;
	
	public TeamWrapper(){
		teams = new ArrayList<TeamModel>();
	}
	
	public void setTeams(List<TeamModel> teams){
		this.teams = teams;
	}
	
	public List<TeamModel> getTeams(){
		return this.teams;
	}
	
}
