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
package com.heroespersist.sports.interfaces.artifact;

import java.util.List;

import org.hibernate.HibernateException;

import com.heroespersist.sports.exception.SportsException;
import com.heroespersist.sports.model.Artifact;
import com.heroespersist.sports.model.Game;
import com.heroespersist.sports.webservice.game.GameForm;

/**
 * @author Sai Pranav
 *
 */
public interface ArtifactService {

	//Utility functions
	public List<Artifact> getArtifacts();
	public List<Artifact> getBestArtifacts(int numberOfElementsNeeded);
	
}
