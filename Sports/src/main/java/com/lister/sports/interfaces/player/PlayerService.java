package com.lister.sports.interfaces.player;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Player;
import com.lister.sports.webservice.game.GameFormWithoutNumberOfPlayers;
import com.lister.sports.webservice.player.PlayerForm;

/**
 * @author sai_pranav
 *
 */
public interface PlayerService {
	
	public int addPlayer(PlayerForm playerform) throws SportsException, HibernateException;
	public int modifyPlayer(int employeeId, PlayerForm playerForm) throws SportsException, HibernateException;
	public int modifyPlayerAddGame(int employeeId, GameFormWithoutNumberOfPlayers gameFormWithoutNumberOfPlayers) throws SportsException, HibernateException;
	public int modifyPlayerDeleteGame(int employeeId, GameFormWithoutNumberOfPlayers gameFormWithoutNumberOfPlayers) throws SportsException, HibernateException;
	public int deletePlayer(int employeeId) throws SportsException, HibernateException;
	public int modifyPlayerFromAdmin(int employeeId, PlayerForm playerForm) throws SportsException, HibernateException;

	public List<Player> getPlayers();
	public List<Player> getPlayersByTeam(int teamId) throws SportsException, HibernateException;
	public List<Player> getPlayersByGame(String gameName, String gameCategory) throws SportsException, HibernateException;
}
