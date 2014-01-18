package com.lister.sports.implementation.player;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lister.sports.exception.SportsException;
import com.lister.sports.interfaces.player.PlayerDao;
import com.lister.sports.interfaces.player.PlayerService;
import com.lister.sports.interfaces.utility.UtilityDao;
import com.lister.sports.model.Game;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;
import com.lister.sports.webservice.game.GameFormWithoutNumberOfPlayers;
import com.lister.sports.webservice.player.PlayerForm;

/**
 * @author sai_pranav
 *
 */

@Component
@Transactional
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	PlayerDao playerDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	/*Player functions*/
	/**
	 * Add player with (or) without game, but if no such player exists.
	 */
	public int addPlayer(PlayerForm playerForm) throws SportsException, HibernateException {
		Player player = utilityDao.getPlayer(playerForm.getEmployeeId());
		if(player != null){
			throw new SportsException("Player already exists");
		}
		if(playerForm.getGames().size()==0){
			player = new Player();
			player.setEmployeeId(playerForm.getEmployeeId());
			player.setEmployeeName(playerForm.getEmployeeName());
			player.setEmployeeEmail(playerForm.getEmployeeEmail());
			return playerDao.addPlayer(player);
		}
		if(playerForm.getGames().size()>=0){
			player = new Player();
			player.setEmployeeId(playerForm.getEmployeeId());
			player.setEmployeeName(playerForm.getEmployeeName());
			player.setEmployeeEmail(playerForm.getEmployeeEmail());
			int id = playerDao.addPlayer(player);
			player = utilityDao.getPlayer(id);
			for(GameFormWithoutNumberOfPlayers tempGame: playerForm.getGames()){
				Game game = utilityDao.getGame(tempGame.getGameName(), tempGame.getGameCategory());
				if(game == null){
					throw new SportsException("No such Game");
				}
				playerDao.modifyPlayerAddGame(player, game);
			}
		}
		return player.getEmployeeId();
	}

	public int modifyPlayer(int employeeId, PlayerForm playerForm) throws SportsException, HibernateException {
		Player player = utilityDao.getPlayer(employeeId);
		if(player == null){
			throw new SportsException("Player does not exist");
		}
		player.setEmployeeName(playerForm.getEmployeeName());
		player.setEmployeeEmail(playerForm.getEmployeeEmail());
		return playerDao.modifyPlayer(player);
	}

	public int modifyPlayerAddGame(int employeeId, GameFormWithoutNumberOfPlayers gameFormWithoutNumberOfPlayers) throws SportsException, HibernateException {
		Player player = utilityDao.getPlayer(employeeId);
		if(player == null){
			throw new SportsException("Player does not exist");
		}
		
		Game game = utilityDao.getGame(gameFormWithoutNumberOfPlayers.getGameName(), gameFormWithoutNumberOfPlayers.getGameCategory());
		if(game == null){
			throw new SportsException("No such Game");
		}
		
		boolean checkGameFlag = false;
		List<Game> games = player.getGames();
		for(Game checkGame: games){
			if(checkGame.getId() == game.getId()){
				checkGameFlag = true;
			}
		}
		if(checkGameFlag == true){
			throw new SportsException("Player already playing this Game");
		}
		
		return playerDao.modifyPlayerAddGame(player, game);
	}

	public int modifyPlayerDeleteGame(int employeeId, GameFormWithoutNumberOfPlayers gameFormWithoutNumberOfPlayers) throws SportsException, HibernateException {
		Player player = utilityDao.getPlayer(employeeId);
		if(player == null){
			throw new SportsException("Player does not exist");
		}
		
		Game game = utilityDao.getGame(gameFormWithoutNumberOfPlayers.getGameName(), gameFormWithoutNumberOfPlayers.getGameCategory());
		if(game == null){
			throw new SportsException("No such Game");
		}
		
		boolean checkGameFlag = false;
		List<Game> games = player.getGames();
		for(Game checkGame: games){
			if(checkGame.getId() == game.getId()){
				checkGameFlag = true;
			}
		}
		if(checkGameFlag == false){
			throw new SportsException("Player is not playing this Game");
		}
		
		return playerDao.modifyPlayerDeleteGame(player, game);
	}

	public int deletePlayer(int employeeId) throws SportsException, HibernateException {
		Player player = utilityDao.getPlayer(employeeId);
		if(player == null){
			throw new SportsException("Player does not exist");
		}
		return playerDao.deletePlayer(player);
	}
	
	public int modifyPlayerFromAdmin(int employeeId, PlayerForm playerForm) throws SportsException, HibernateException {
		Player player = utilityDao.getPlayer(playerForm.getEmployeeId());
		if(player == null){
			throw new SportsException("Player does not exists");
		}
		if(playerForm.getGames().size()==0){
			player.setEmployeeName(playerForm.getEmployeeName());
			player.setEmployeeEmail(playerForm.getEmployeeEmail());
			return playerDao.modifyPlayer(player);
		}
		if(playerForm.getGames().size()>=0){
			player.setEmployeeName(playerForm.getEmployeeName());
			player.setEmployeeEmail(playerForm.getEmployeeEmail());
			int id = playerDao.modifyPlayer(player);
			player = utilityDao.getPlayer(id);
			List<Game> games = new ArrayList<Game>(1);
			for(GameFormWithoutNumberOfPlayers tempGame: playerForm.getGames()){
				Game game = utilityDao.getGame(tempGame.getGameName(), tempGame.getGameCategory());
				if(game == null){
					throw new SportsException("No such Game");
				}
				games.add(game);
			}
			playerDao.modifyPlayerReloadGames(player, games);
		}
		return player.getEmployeeId();
	}
	
	public List<Player> getPlayers(){
		return playerDao.getPlayers();
	}

	public List<Player> getPlayersByTeam(int teamId) throws SportsException, HibernateException{
		Team team = utilityDao.getTeam(teamId);
		if(team!=null){
			return playerDao.getPlayersByTeam(team);
		}
		else{
			throw new SportsException("Team does not exist");
		}
	}
	
	public List<Player> getPlayersByGame(String gameName, String gameCategory) throws SportsException ,HibernateException{
		Game game = utilityDao.getGame(gameName, gameCategory);
		if(game!=null){
			return playerDao.getPlayersByGame(game);
		}
		else{
			throw new SportsException("Game does not exist");
		}
	}

}