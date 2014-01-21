package com.lister.sports.interfaces.utility;


import java.util.List;

import org.hibernate.classic.Session;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Game;
import com.lister.sports.model.Match;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;

/**
 * @author sai_pranav
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