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
package com.lister.sports.interfaces.utility;


import java.util.List;

import org.hibernate.classic.Session;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Game;
import com.lister.sports.model.Match;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;

/**
 * @author Sai Pranav
 *
 */
public interface UtilityDao {

	public Session getSession();
	
	public Game getGame(String name, String category);
	public Game getGame(int id);
	public Player getPlayer(int employeeId);
	public Team getTeam(String name, Game game);
	public Team getTeam(int id);
	public List<Player> getPlayerList(List<Integer> players) throws SportsException;
	public boolean checkPlayers(List<Team> teams ,List<Player> playersList);
	public boolean checkTeamName(List<Team> teams, String name);
	public List<Team> getTeams(List<String> teams, List<Team> gameTeams) throws SportsException;
	public Match getMatch(Game game, List<Team> teams, List<Match> matches);
	public Match getMatch(int id);
	
	public List<Integer> getGameIds();

}