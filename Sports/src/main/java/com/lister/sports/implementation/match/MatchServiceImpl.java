package com.lister.sports.implementation.match;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lister.sports.exception.SportsException;
import com.lister.sports.interfaces.match.MatchDao;
import com.lister.sports.interfaces.match.MatchService;
import com.lister.sports.interfaces.team.TeamDao;
import com.lister.sports.interfaces.utility.UtilityDao;
import com.lister.sports.model.Game;
import com.lister.sports.model.Match;
import com.lister.sports.model.Team;
import com.lister.sports.webservice.match.MatchForm;
import com.lister.sports.webservice.match.SimpleMatchForm;

/**
 * @author sai_pranav
 *
 */

@Component
@Transactional
public class MatchServiceImpl implements MatchService{
	
	@Autowired
	MatchDao matchDao;
	
	@Autowired
	TeamDao teamDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	public int addMatch(MatchForm matchForm) throws SportsException, HibernateException {
		Game game = utilityDao.getGame(matchForm.getGame().getGameName(), matchForm.getGame().getGameCategory());
		if(game == null){
			throw new SportsException("No such game");
		}
		List<Team> teams = utilityDao.getTeams(matchForm.getTeams(),teamDao.getTeamsByGame(game,false));
		List<Match> matches = matchDao.getMatchesByGame(game);
		for(Match tempMatch : matches){
			tempMatch.getTeams().size();
		}
		Match match = utilityDao.getMatch(game,teams,matchForm.getRound(),matches);
		if(match==null){
			return matchDao.addMatch(matchForm.getRound(), matchForm.getScheduledTime(), matchForm.getLocation(), matchForm.getStatus(), matchForm.getWinner(), matchForm.getScore(), matchForm.isShow(), teams, game);
		}
		else{
			throw new SportsException("Match already scheduled");
		}
	}

	public int modifyMatch(int id, MatchForm matchForm) throws SportsException, HibernateException {
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			if(matchForm.getGame().getGameName().equalsIgnoreCase(match.getGame().getName()) && matchForm.getGame().getGameCategory().equalsIgnoreCase(match.getGame().getCategory())){
				return matchDao.modifyMatch(match, matchForm.getRound(), matchForm.getScheduledTime(), matchForm.getLocation(), matchForm.getStatus(), matchForm.getWinner(), matchForm.getScore(), matchForm.isShow());
			}
			else{
				throw new SportsException("Cannot change Game Name, Category");
			}
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}

	public int modifyMatchAddTeams(int id, String teamName) throws SportsException, HibernateException{
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			List<String> teamNames = new ArrayList<String>(1);
			teamNames.add(teamName);
			List<Team> teams = utilityDao.getTeams(teamNames,teamDao.getTeamsByGame(match.getGame(),false));
			List<Match> matches = matchDao.getMatchesByGame(match.getGame());
			match = utilityDao.getMatch(match.getGame(),teams,match.getRound(),matches);
			if(match!=null){
				if(match.getTeams().size()==2){
					throw new SportsException("Cannot Add Team, Match already has 2 teams");
				}
				return matchDao.modifyMatchAddTeams(match, teams);
			}
			else{
				throw new SportsException("Team already playing same game in some other match");
			}
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}

	public int modifyMatchDeleteTeams(int id, String teamName) throws SportsException, HibernateException {
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			List<String> teamNames = new ArrayList<String>(1);
			teamNames.add(teamName);
			List<Team> teams = utilityDao.getTeams(teamNames,teamDao.getTeamsByGame(match.getGame(),false));
			if(match.getTeams().size()==0){
				throw new SportsException("Cannot Delete Team, Match has 0 teams");
			}
			if(teams.size()<=2){
				return matchDao.modifyMatchDeleteTeams(match, teams);
			}
			else{
				throw new SportsException("Cannot Delete more than 2 teams");
			}
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}

	public int deleteMatch(int id) throws SportsException, HibernateException{
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			return matchDao.deleteMatch(match);
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}

	public boolean checkMatch(int id) throws SportsException, HibernateException {
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			if(match.getTeams().size()==2){
				if(matchDao.checkNumberOfPlayers(match)){
					if(matchDao.checkTeamsMash(match)){
						return true;
					}
					else{
						throw new SportsException("Match between same Teams");
					}
				}
				else{
					throw new SportsException("Team(s) in Match "+id+" does not contain required number of players for this game");
				}
			}
			else{
				throw new SportsException("Match does not contain 2 teams");
			}
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}
	
	public int modifyMatchmodifyShow(int id, boolean toShow) throws SportsException, HibernateException {
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			return matchDao.modifyMatchModifyShow(match, toShow);
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}
	
	public int modifyMatchFromAdmin(int id, MatchForm matchForm) throws SportsException, HibernateException {
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			List<Team> teams = utilityDao.getTeams(matchForm.getTeams(),teamDao.getTeamsByGame(match.getGame(),false));
			return matchDao.modifyMatchFromAdmin(match, teams, matchForm.getRound(), matchForm.getScheduledTime(), matchForm.getLocation(), matchForm.getStatus(), matchForm.getWinner(), matchForm.getScore());
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}
	
	public int modifyMatchFromLivescores(int id, SimpleMatchForm simpleMatchForm) throws SportsException, HibernateException {
		Match match = utilityDao.getMatch(id);
		if(match!=null){
			List<Team> teams = utilityDao.getTeams(simpleMatchForm.getTeams(),teamDao.getTeamsByGame(match.getGame(),false));
			return matchDao.modifyMatchFromAdmin(match, teams, simpleMatchForm.getRound(), simpleMatchForm.getScheduledTime(), simpleMatchForm.getLocation(), simpleMatchForm.getStatus(), simpleMatchForm.getWinner(), simpleMatchForm.getScore());
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}

	public List<Match> allMatches(boolean showCriteria) {
		List<Match> matches = matchDao.allMatches(showCriteria);
		return matches;
	}
	
	public List<Match> getMatchesByGame(String gameName, String gameCategory) throws SportsException, HibernateException{
		Game game = utilityDao.getGame(gameName, gameCategory);
		if(game!=null){
			List<Match> matches = matchDao.getMatchesByGame(game);
			for(Match match: matches){
				match.getGame();
				List<Team> tempTeams = match.getTeams();
				tempTeams.size();
			}
			return matches;
		}
		else{
			throw new SportsException("Game does not exist");
		}
	}

}
