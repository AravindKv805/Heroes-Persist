package com.lister.sports.implementation.utility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lister.sports.exception.SportsException;
import com.lister.sports.interfaces.utility.UtilityDao;
import com.lister.sports.model.Game;
import com.lister.sports.model.Match;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;

/**
 * @author sai_pranav
 *
 */
@Repository
public class UtilityDaoImpl implements UtilityDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Game getGame(String name, String category){
		Session session = getSession();
		
		List<Game> gameList = session.createCriteria(Game.class).add(Restrictions.eq("name", name)).add(Restrictions.eq("category", category)).setCacheable(true).list();
		
		if(gameList.size()==1){
			return gameList.get(0);
		}
		return null;
	}
	
	public Game getGame(int id){
		Session session = getSession();
		return (Game) session.get(Game.class, id);
	}

	public Player getPlayer(int employeeId) {
		Session session = getSession();
		return (Player) session.get(Player.class, employeeId);
	}
	
	public Team getTeam(String name, Game game){
		Session session = getSession();
		List<Team> teamList = session.createCriteria(Team.class)
				.add(Restrictions.eq("name", name))
				.list();
		
		for(Team team: teamList){
			if(team.getGame().equals(game)){
				return team;
			}
		}
		return null;
	}
	
	public Team getTeam(int id){
		Session session = getSession();
		return (Team) session.get(Team.class, id);
	}
	
	public List<Player> getPlayerList(List<Integer> players) throws SportsException{
		Session session = getSession();
		List<Player> playerList = new ArrayList<Player>();
		for(int temp: players){
			Player player = (Player) session.get(Player.class, temp);
			if(player!=null){
				playerList.add(player);
			}
			else{
				throw new SportsException("No such player "+temp);
			}
		}
		return playerList;
	}
	
	public boolean checkPlayers(List<Team> teams, List<Player> players){
		for(Player player: players){
			for(Team team: teams){
				if(team.getPlayers().contains(player)){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkTeamName(List<Team> teams, String name){
		for(Team team: teams){
			if(team.getName().equals(name)){
				return false;
			}
		}
		return true;
	}

	public List<Team> getTeams(List<String> teamNames, List<Team> gameTeams) throws SportsException {
		List<Team> teams = new ArrayList<Team>();
		for(String teamName: teamNames){
			int i=0;
			for(i=0;i<gameTeams.size();i++){
				if(gameTeams.get(i).getName().equalsIgnoreCase(teamName)){
					teams.add(gameTeams.get(i));
					break;
				}
			}
			if(i==gameTeams.size()){
				throw new SportsException("Team "+teamName+" is not playing this game (OR) No such team");
			}
		}
		return teams;
	}

	public Match getMatch(Game game, List<Team> teams, List<Match> matches) {
		boolean teamDuplicate = false;
		for(Match match: matches){
			for(Team team: teams){
				if(checkTeam(team, matches)){
					teamDuplicate = true;
				}
			}
			if(teamDuplicate==true){
				return match;
			}
		}
		return null;
	}
	
	public boolean checkTeam(Team team, List<Match> matches){
		for(Match match: matches){
			if(match.getTeams().contains(team)){
				return true;
			}
		}
		return false;
	}
	
	public Match getMatch(int id) {
		Session session = getSession();
		return (Match) session.get(Match.class, id);	
	}
	
	public List<Integer> getGameIds(){
		Session session = getSession();
		List<Integer> ids = new ArrayList<Integer>();
		List<Game> gameList = session.createCriteria(Game.class).setCacheable(true).list();
		for(Game game: gameList){
			ids.add(game.getId());
		}
		
		return ids;
	}
	
}
