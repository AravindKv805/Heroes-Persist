package com.lister.sports.interfaces.game;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.model.Game;
import com.lister.sports.model.Player;

/**
 * @author sai_pranav
 *
 */
public interface GameDao {

	public int addGame(Game game) throws HibernateException;
	public int modifyGame(Game game) throws HibernateException;
	public int deleteGame(Game game) throws HibernateException;
	public List<Game> getGames();
	public List<Game> getGamesByPlayer(Player player);
	
}
