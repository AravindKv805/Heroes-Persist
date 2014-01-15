package com.lister.sports.interfaces.team;

import java.util.List;

import com.lister.sports.model.Game;
import com.lister.sports.model.Match;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;

/**
 * @author sai_pranav
 *
 */
public interface TeamDao {

	/*you cannot change game for a team*/
	public int addTeam(Team team);
	public int modifyTeam(Team team, String name, String rating, String score, int round);
	public int modifyTeam(Team team, String name, String score, int round);
	public int modifyTeamAddPlayer(Team team, Player player);
	public int modifyTeamDeletePlayer(Team team, Player player);
	public int deleteTeam(Team team);
	public int modifyShow(Team team, boolean toShow);
	public int modifyTeamFromAdmin(Team team, String name, String rating, String score, int round, List<Player> playersList);
	public List<Team> getTeamsByGame(Game game, boolean showCriteria);
	public List<Team> getTeamsByMatch(Match match);
	
}
