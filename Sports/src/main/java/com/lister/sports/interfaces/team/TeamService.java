package com.lister.sports.interfaces.team;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Team;
import com.lister.sports.webservice.team.SimpleTeamForm;
import com.lister.sports.webservice.team.TeamForm;

/**
 * @author sai_pranav
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
