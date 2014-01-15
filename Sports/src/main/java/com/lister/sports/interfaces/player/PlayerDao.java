package com.lister.sports.interfaces.player;

import java.util.List;

import com.lister.sports.model.Game;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;

/**
 * @author sai_pranav
 *
 */
public interface PlayerDao {

	public int addPlayer(Player player);
	public int modifyPlayer(Player player);
	public int modifyPlayerAddGame(Player player, Game game);
	public int modifyPlayerDeleteGame(Player player, Game game);
	public void modifyPlayerReloadGames(Player player, List<Game> games);
	public int deletePlayer(Player player);
	//public int modifyPlayerFromAdmin(int employeeId, String employeeName, String employeeEmail, String games) throws SportsException;
	public List<Player> getPlayers();
	public List<Player> getPlayersByGame(Game game);
	public List<Player> getPlayersByTeam(Team team);
	
}
