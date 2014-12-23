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
package com.heroespersist.sports.implementation.artifact;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heroespersist.sports.exception.SportsException;
import com.heroespersist.sports.interfaces.artifact.ArtifactDao;
import com.heroespersist.sports.interfaces.utility.UtilityDao;
import com.heroespersist.sports.model.Artifact;
import com.heroespersist.sports.model.Player;

/**
 * @author Sai Pranav
 *
 */
@Repository
public class ArtifactDaoImpl implements ArtifactDao {

	@Autowired
	UtilityDao utilityDao;
	
	public List<Artifact> getArtifacts() {
		Session session = utilityDao.getSession();
		List<Artifact> artifacts;
		try{
			artifacts = session.createCriteria(Artifact.class).addOrder(Order.desc("points")).setCacheable(true).list();
			for(Artifact artifact : artifacts){
				artifact.getTeam().getGame();
				List<Player> players = artifact.getTeam().getPlayers();
				for(Player player: players){
					player.getGames().size();
				}
			}
		}
		catch(HibernateException e){
			throw new SportsException("OOPS! There seems to be a problem with database");
		}
		return artifacts;
	}

}
