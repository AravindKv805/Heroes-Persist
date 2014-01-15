package com.lister.sports.implementation.team;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lister.sports.exception.SportsException;
import com.lister.sports.interfaces.player.PlayerDao;
import com.lister.sports.interfaces.team.TeamDao;
import com.lister.sports.interfaces.team.TeamService;
import com.lister.sports.interfaces.utility.UtilityDao;
import com.lister.sports.model.Game;
import com.lister.sports.model.Match;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;
import com.lister.sports.webservice.team.SimpleTeamForm;
import com.lister.sports.webservice.team.TeamForm;

/**
 * @author sai_pranav
 *
 */

@Component
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamDao teamDao;
	
	@Autowired
	PlayerDao playerDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	public int addTeam(TeamForm teamForm) throws SportsException, HibernateException{
		Game game = utilityDao.getGame(teamForm.getGame().getGameName(), teamForm.getGame().getGameCategory());
		if(game!=null){
			Team team = utilityDao.getTeam(teamForm.getName(), game);
			if(team==null){
				List<Player> playersList = utilityDao.getPlayerList(teamForm.getPlayers());
				if(playersList.size() == teamForm.getPlayers().size()){
					List<Team> teams = teamDao.getTeamsByGame(game,false);
					if(utilityDao.checkPlayers(teams,playersList)==true){
						for(Player player: playersList){
							boolean checkGameFlag = false;
							List<Game> games = player.getGames();
							for(Game checkGame: games){
								if(checkGame.getId() == game.getId()){
									checkGameFlag = true;
								}
							}
							if(checkGameFlag == false){
								playerDao.modifyPlayerAddGame(player, game);
							}
						}
						team = new Team();
						team.setGame(game);
						team.setName(teamForm.getName());
						team.setRating(teamForm.getRating());
						team.setPlayers(playersList);
						return teamDao.addTeam(team);
					}
					else{
						throw new SportsException("Player(s) is playing same game for another team");
					}
				}
				else{
					throw new SportsException("Player(s) does not exists");
				}
			}
			else{
				throw new SportsException("Team already exists");
			}
		}
		else{
			throw new SportsException("No such Game");
		}
	}

	public int modifyTeam(int id, TeamForm teamForm) throws SportsException, HibernateException {
		Team team = utilityDao.getTeam(id);
		if(team!=null){
			return teamDao.modifyTeam(team, teamForm.getName(), teamForm.getRating(), teamForm.getScore(), teamForm.getRound());
		}
		else{
			throw new SportsException("No such team");
		}
	}
	
	public int modifyTeam(int id, SimpleTeamForm teamFormSimple) throws SportsException, HibernateException {
		Team team = utilityDao.getTeam(id);
		if(team!=null){
			return teamDao.modifyTeam(team, teamFormSimple.getName(), teamFormSimple.getScore(), teamFormSimple.getRound());
		}
		else{
			throw new SportsException("No such team");
		}
	}

	public int modifyTeamAddPlayer(int id, String employeeId) throws SportsException, HibernateException {
		Team team = utilityDao.getTeam(id);
		if(team!=null){
			Player player = utilityDao.getPlayer(Integer.parseInt(employeeId));
			List<Player> playersList = new ArrayList<Player>(1);
			playersList.add(player);
			if(utilityDao.checkPlayers(teamDao.getTeamsByGame(team.getGame(),false), playersList)){
				return teamDao.modifyTeamAddPlayer(team, player);
			}
			else{
				throw new SportsException("Player is playing the same game in another team");
			}
		}
		else{
			throw new SportsException("No such team");
		}
	}

	public int modifyTeamDeletePlayer(int id, String employeeId) throws SportsException, HibernateException {
		Team team = utilityDao.getTeam(id);
		if(team!=null){
			Player player = utilityDao.getPlayer(Integer.parseInt(employeeId));
			if(player==null){
				throw new SportsException("No such Player");
			}
			if(!team.getPlayers().contains(player)){
				throw new SportsException("No such player in this team");
			}
			List<Player> playersList = new ArrayList<Player>(1);
			playersList.add(player);
			return teamDao.modifyTeamDeletePlayer(team, player);
		}
		else{
			throw new SportsException("No such team");
		}
	}

	public int deleteTeam(int id) throws SportsException, HibernateException {
		Team team = utilityDao.getTeam(id);
		if(team!=null){
			return teamDao.deleteTeam(team);
		}
		else{
			throw new SportsException("No such team");
		}
	}
	
	public int modifyTeamShow(int id, boolean toShow) throws SportsException, HibernateException {
		Team team = utilityDao.getTeam(id);
		if(team!=null){
			return teamDao.modifyShow(team, toShow);
		}
		else{
			throw new SportsException("No such team");
		}
	}
	
	public int modifyTeamFromAdmin(int id, TeamForm teamForm) throws SportsException, HibernateException {
		Team team = utilityDao.getTeam(id);
		if(team!=null){
			List<Player> playersList = utilityDao.getPlayerList(teamForm.getPlayers());
			if(playersList.size() == teamForm.getPlayers().size()){
				List<Team> teams = teamDao.getTeamsByGame(team.getGame(),false);
				teams.remove(team);
				if(utilityDao.checkTeamName(teams, teamForm.getName())==true){
					if(utilityDao.checkPlayers(teams,playersList)==true){
						return teamDao.modifyTeamFromAdmin(team, teamForm.getName(), teamForm.getRating(), teamForm.getScore(), teamForm.getRound(), playersList);						
					}
					else{
						throw new SportsException("Player(s) is playing the same game for another team");
					}
				}
				else{
					throw new SportsException("Team name already exists choose another");
				}
			}
			else{
				throw new SportsException("Player(s) does not exists");
			}
		}
		else{
			throw new SportsException("No such Team");
		}
	}
	
	public List<Team> getTeamsByGame(String gameName, String gameCategory, boolean showCriteria) throws SportsException, HibernateException{
		Game game = utilityDao.getGame(gameName, gameCategory);
		if(game!=null){
			return teamDao.getTeamsByGame(game,showCriteria);
		}
		else{
			throw new SportsException("Game does not exists");
		}
	}
	
	public List<Team> getTeamsByMatch(int matchId) throws SportsException, HibernateException{
		Match match = utilityDao.getMatch(matchId);
		if(match!=null){
			List<Team> teams = teamDao.getTeamsByMatch(match);
			return teams;
		}
		else{
			throw new SportsException("Match does not exists");
		}
	}

}
