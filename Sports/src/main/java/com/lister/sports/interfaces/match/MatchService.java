package com.lister.sports.interfaces.match;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Match;
import com.lister.sports.webservice.match.MatchForm;
import com.lister.sports.webservice.match.SimpleMatchForm;

/**
 * @author sai_pranav
 *
 */
public interface MatchService {
	
	/*Match Functions*/
	public int addMatch(MatchForm matchForm) throws SportsException, HibernateException;
	public int modifyMatch(int id, MatchForm matchForm) throws SportsException, HibernateException;
	public int modifyMatchAddTeams(int id, String teamName) throws SportsException, HibernateException;
	public int modifyMatchDeleteTeams(int id, String teamName) throws SportsException, HibernateException;
	/*you cannot change game for a match*/
	public int deleteMatch(int id) throws SportsException, HibernateException;
	public boolean checkMatch(int id) throws SportsException, HibernateException;
	public int modifyMatchmodifyShow(int id, boolean toShow) throws SportsException, HibernateException;
	public int modifyMatchFromAdmin(int id, MatchForm matchForm) throws SportsException, HibernateException;
	public int modifyMatchFromLivescores(int id, SimpleMatchForm simpleMatchForm) throws SportsException, HibernateException;
	
	/*List functions*/
	public List<Match> allMatches(boolean showCriteria);
	
	/*Utility functions*/
	public List<Match> getMatchesByGame(String gameName, String gameCategory) throws SportsException, HibernateException;

}
