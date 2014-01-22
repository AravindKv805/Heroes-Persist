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
package com.lister.sports.implementation.game;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lister.sports.interfaces.game.GameDao;
import com.lister.sports.interfaces.utility.UtilityDao;
import com.lister.sports.model.Game;
import com.lister.sports.model.Player;

/**
 * @author Sai Pranav
 *
 */
@Repository
public class GameDaoImpl implements GameDao {

	@Autowired
	UtilityDao utilityDao;
	
	public int addGame(Game game) throws HibernateException{
		Session session = utilityDao.getSession();
		try {
			session.save(game);
		} catch (HibernateException e) {
			throw e;
		}
		return game.getId();
	}

	public int modifyGame(Game game) throws HibernateException{
		Session session = utilityDao.getSession();
		try {
			session.saveOrUpdate(game);
		} catch (HibernateException e) {
			throw e;
		}
		return game.getId();
	}

	public int deleteGame(Game game) throws HibernateException{
		Session session = utilityDao.getSession();
		try {
			session.delete(game);
		} catch (HibernateException e) {
			throw e;
		}
		return game.getId();
	}

	public List<Game> getGames() {
		Session session = utilityDao.getSession();
		List<Game> games;
		try{
			games = session.createCriteria(Game.class).setCacheable(true).list();
		}
		catch(HibernateException e){
			throw e;
		}
		return games;
	}

	public List<Game> getGamesByPlayer(Player player) {
		List<Game> games = player.getGames();
		games.size();
		return games;
	}

}
