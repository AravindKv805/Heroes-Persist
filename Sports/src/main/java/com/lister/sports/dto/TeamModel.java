package com.lister.sports.dto;

/**
 * @author sai_pranav
 *
 */
public class TeamModel {
	
	private int teamId;
	private String teamName;
	private String score;
	private int round;
	private boolean show;
	
	public TeamModel(TeamModelBuilder teamModelBuilder){
		this.teamId = teamModelBuilder.teamId;
		this.teamName = teamModelBuilder.teamName;
		this.score = teamModelBuilder.score;
		this.round = teamModelBuilder.round;
		this.show = teamModelBuilder.show;
	}
	
	public int getTeamId(){
		return teamId;
	}
	
	public void setTeamId(int teamId){
		this.teamId = teamId;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setEmployeeId(String teamName){
		this.teamName = teamName;
	}
	
	public String getScore(){
		return score;
	}
	
	public void setScore(String score){
		this.score = score;
	}
	
	public int getRound(){
		return round;
	}
	
	public void setRound(int round){
		this.round = round;
	}
	
	public boolean isShow(){
		return show;
	}
	
	public void setShow(boolean show){
		this.show = show;
	}
	
	public static class TeamModelBuilder{
		
		private int teamId;
		private String teamName;
		private String score;
		private int round;
		private boolean show;
		
		public TeamModelBuilder(int teamId, String teamName){
			this.teamId = teamId;
			this.teamName = teamName;
		}
		
		public TeamModelBuilder score(String score){
			this.score = score;
			return this;
		}
		
		public TeamModelBuilder round(int round){
			this.round = round;
			return this;
		}
		
		public TeamModelBuilder show(boolean show){
			this.show = show;
			return this;
		}
		
		public TeamModel build(){
			return new TeamModel(this);
		}
	}
}
