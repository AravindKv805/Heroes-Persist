package com.lister.sports.webservice.player;

import java.util.List;

import com.lister.sports.webservice.game.GameFormWithoutNumberOfPlayers;

/**
 * @author sai_pranav
 *
 */
public class PlayerForm {

	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private List<GameFormWithoutNumberOfPlayers> games;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public List<GameFormWithoutNumberOfPlayers> getGames() {
		return games;
	}
	public void setGames(List<GameFormWithoutNumberOfPlayers> games) {
		this.games = games;
	}
	
}
