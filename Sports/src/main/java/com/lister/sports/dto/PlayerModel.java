package com.lister.sports.dto;

/**
 * @author sai_pranav
 *
 */
public class PlayerModel {
	
	private int employeeId;
	
	public PlayerModel(PlayerModelBuilder playerModelBuilder){
		this.employeeId = playerModelBuilder.employeeId;
	}
	
	public int getEmployeeId(){
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId;
	}
	
	public static class PlayerModelBuilder{
		
		private int employeeId;
		
		public PlayerModelBuilder(int employeeId){
			this.employeeId = employeeId;
		}
		
		public PlayerModel build(){
			return new PlayerModel(this);
		}
	}
}
