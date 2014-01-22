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
package com.lister.sports.interfaces.match;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Match;
import com.lister.sports.webservice.match.MatchForm;
import com.lister.sports.webservice.match.SimpleMatchForm;

/**
 * @author Sai Pranav
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
