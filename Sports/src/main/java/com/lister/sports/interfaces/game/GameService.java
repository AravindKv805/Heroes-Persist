package com.lister.sports.interfaces.game;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Game;
import com.lister.sports.webservice.game.GameForm;

/**
 * @author sai_pranav
 *
 */
public interface GameService {

	//Core Game functions
	public int addGame(GameForm gameForm) throws SportsException, HibernateException;
	public int modifyGame(int id, GameForm gameForm) throws SportsException, HibernateException;
	public int deleteGame(int id) throws SportsException, HibernateException;
	
	//Utility functions
	public List<Game> getGames();
	public List<Game> getGamesByPlayer(int employeeId) throws SportsException, HibernateException;
	
}
