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
package com.lister.sports.interfaces.team;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Team;
import com.lister.sports.webservice.team.SimpleTeamForm;
import com.lister.sports.webservice.team.TeamForm;

/**
 * @author Sai Pranav
 *
 */
public interface TeamService {
	
	/*Team Functions*/
	public int addTeam(TeamForm teamForm) throws SportsException, HibernateException;
	public int modifyTeam(int id, TeamForm teamForm) throws SportsException, HibernateException;
	public int modifyTeam(int id, SimpleTeamForm teamForm) throws SportsException, HibernateException;
	public int modifyTeamAddPlayer(int id, String employeeId) throws SportsException, HibernateException;
	public int modifyTeamDeletePlayer(int id, String employeeId) throws SportsException, HibernateException;
	/*you cannot change game for a team*/
	public int deleteTeam(int id) throws SportsException, HibernateException;
	public int modifyTeamShow(int id, boolean toShow) throws SportsException, HibernateException;
	public int modifyTeamFromAdmin(int id, TeamForm teamForm) throws SportsException, HibernateException;

	/*Utility functions*/
	public List<Team> getTeamsByGame(String gameName, String gameCategory, boolean showCriteria) throws SportsException, HibernateException;
	public List<Team> getTeamsByMatch(int matchId) throws SportsException, HibernateException;
}
