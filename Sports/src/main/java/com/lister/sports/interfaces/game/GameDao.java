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
package com.lister.sports.interfaces.game;

import java.util.List;

import org.hibernate.HibernateException;

import com.lister.sports.model.Game;
import com.lister.sports.model.Player;

/**
 * @author Sai Pranav
 *
 */
public interface GameDao {

	public int addGame(Game game) throws HibernateException;
	public int modifyGame(Game game) throws HibernateException;
	public int deleteGame(Game game) throws HibernateException;
	public List<Game> getGames();
	public List<Game> getGamesByPlayer(Player player);
	
}
