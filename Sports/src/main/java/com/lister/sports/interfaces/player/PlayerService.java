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
package com.lister.sports.interfaces.player;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.exception.SportsException;
import com.lister.sports.model.Player;
import com.lister.sports.webservice.game.GameFormWithoutNumberOfPlayers;
import com.lister.sports.webservice.player.PlayerForm;

/**
 * @author Sai Pranav
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
