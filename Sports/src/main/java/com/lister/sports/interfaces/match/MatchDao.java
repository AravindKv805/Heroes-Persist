package com.lister.sports.interfaces.match;

import java.util.List;

import com.lister.sports.model.Game;
import com.lister.sports.model.Match;
import com.lister.sports.model.Team;

/**
 * @author sai_pranav
 *
 */
public interface MatchDao {

	/*you cannot change game for a match*/
	public int addMatch(int round, String time, String location, String status, String winner, String score, boolean show, List<Team> teams, Game game);
	public int modifyMatch(Match match, int round, String time, String location, String status, String winner, String score, boolean show);
	public int modifyMatchAddTeams(Match match, List<Team> teams);
	public int modifyMatchDeleteTeams(Match match, List<Team> teams);
	public int deleteMatch(Match match);
	public boolean checkNumberOfPlayers(Match match);
	public boolean checkTeamsMash(Match match);
	public int modifyMatchModifyShow(Match match, boolean toShow);
	public int modifyMatchFromAdmin(Match match, List<Team> teams,int round, String time, String location, String status, String winner, String score);
	public List<Match> allMatches(boolean showCriteria);
	public List<Match> getMatchesByGame(Game game);
	public List<Match> getMatchesByGame(Game game, int round);
	
}
