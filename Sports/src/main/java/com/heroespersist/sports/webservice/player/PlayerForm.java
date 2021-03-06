/*	Heroes Persist
    Product which helps in organizing, broadcasting, celebrating events
    Copyright (C) 2014  Sai Pranav
    Email: rsaipranav92@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.heroespersist.sports.webservice.player;

import java.util.List;

import com.heroespersist.sports.webservice.game.GameFormWithoutNumberOfPlayers;

/**
 * @author Sai Pranav
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
