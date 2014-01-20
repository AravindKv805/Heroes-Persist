package com.lister.sports.implementation.team;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lister.sports.interfaces.team.TeamDao;
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
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	UtilityDao utilityDao;

	public int addTeam(Team team) {
		Session session = utilityDao.getSession();
		try{
			session.save(team);
		}
		catch(HibernateException e){
			throw e;
		}
		return team.getId();
	}

	public int modifyTeam(Team team, String name, String rating, String score, int round) {
		Session session = utilityDao.getSession();
		try{
			team.setName(name);
			team.setRating(rating);
			team.setScore(score);
			team.setRound(round);
			session.save(team);
		}
		catch(HibernateException e){
			throw e;
		}
		return team.getId();
	}
	
	public int modifyTeam(Team team, String name, String score, int round) {
		Session session = utilityDao.getSession();
		try{
			team.setName(name);
			team.setScore(score);
			team.setRound(round);
			session.save(team);
		}
		catch(HibernateException e){
			throw e;
		}
		return team.getId();
	}

	public int modifyTeamAddPlayer(Team team, Player player) {
		Session session = utilityDao.getSession();
		try{
			team.getPlayers().add(player);
			session.save(team);
		}
		catch(HibernateException e){
			throw e;
		}
		return team.getId();
	}

	public int modifyTeamDeletePlayer(Team team, Player player) {
		Session session = utilityDao.getSession();
		try{
			team.getPlayers().remove(player);
			session.save(team);
		}
		catch(HibernateException e){
			throw e;
		}
		return team.getId();
	}
	
	public int modifyShow(Team team, boolean toShow) {
		Session session = utilityDao.getSession();
		try{
			team.setShow(toShow);
			session.update(team);
		}
		catch(HibernateException e)		{
			throw e;
		}
		return team.getId();
	}

	public int deleteTeam(Team team) {
		Session session = utilityDao.getSession();
		try{
			session.delete(team);
		}
		catch(HibernateException e)		{
			throw e;
		}
		return team.getId();
	}

	public int modifyTeamFromAdmin(Team team, String name, String rating, String score, int round, List<Player> playersList) {
		Session session = utilityDao.getSession();
		try{
			team.setName(name);
			team.setRating(rating);
			team.setScore(score);
			team.setRound(round);
			team.setPlayers(playersList);
			session.update(team);
		}
		catch(HibernateException e){
			throw e;
		}
		return team.getId();
	}

	public List<Team> getTeamsByGame(Game game, boolean showCriteria) {
		Session session = utilityDao.getSession();
		List<Team> teams;
		try{
			if(showCriteria){
				teams = session.createCriteria(Team.class).add(Restrictions.eq("game.id", game.getId())).add(Restrictions.eq("show", true)).addOrder(Order.desc("score")).setCacheable(true).list();
			}
			else{
				teams = session.createCriteria(Team.class).add(Restrictions.eq("game.id", game.getId())).addOrder(Order.desc("score")).setCacheable(true).list();
			}
		}
		catch(HibernateException e){
			throw e;
		}
		return teams;
	}

	public List<Team> getTeamsByMatch(Match match) {
		List<Team> teams = match.getTeams();
		teams.size();
		return teams;
	}

}
