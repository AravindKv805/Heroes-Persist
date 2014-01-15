package com.lister.sports.implementation.game;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lister.sports.exception.SportsException;
import com.lister.sports.interfaces.game.GameDao;
import com.lister.sports.interfaces.game.GameService;
import com.lister.sports.interfaces.utility.UtilityDao;
import com.lister.sports.model.Game;
import com.lister.sports.model.Player;
import com.lister.sports.webservice.game.GameForm;

/**
 * @author sai_pranav
 *
 */

@Component
@Transactional
public class GameServiceImpl implements GameService {

	@Autowired
	GameDao gameDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	/**
	 * Add a game if it does not exists.
	 */
	public int addGame(GameForm gameForm) throws SportsException, HibernateException{
		if(utilityDao.getGame(gameForm.getName(), gameForm.getCategory()) != null){
			throw new SportsException("This Game Already Exists");
		}
		Game game = new Game(gameForm.getName(),gameForm.getCategory(),gameForm.getNoPlayers());
		return gameDao.addGame(game);
	}

	/**
	 * Modify game if it exists.
	 * Cannot modify Name and Category, delete and add new game.
	 */
	public int modifyGame(int id, GameForm gameForm) throws SportsException, HibernateException {
		Game game = utilityDao.getGame(id);
		if(game == null){
			throw new SportsException("No such Game");
		}
		if(game.getName().equalsIgnoreCase(gameForm.getName()) && game.getCategory().equalsIgnoreCase(gameForm.getCategory())){
			game.setNoPlayers(gameForm.getNoPlayers());
			return gameDao.modifyGame(game);
		}
		else{
			throw new SportsException("You cannot modify Name, Category");
		}
	}

	/**
	 * Delete game if exists.
	 */
	public int deleteGame(int id) throws SportsException, HibernateException {
		Game game = utilityDao.getGame(id);
		if(game == null){
			throw new SportsException("No such Game");
		}
		return gameDao.deleteGame(game);
	}

	public List<Game> getGames(){
		return gameDao.getGames();
	}
	
	public List<Game> getGamesByPlayer(int employeeId) throws SportsException, HibernateException{
		Player player = utilityDao.getPlayer(employeeId);
		if(player!=null){
			return gameDao.getGamesByPlayer(player);
		}
		else{
			throw new SportsException("Player does not exist");
		}
	}
	
}
