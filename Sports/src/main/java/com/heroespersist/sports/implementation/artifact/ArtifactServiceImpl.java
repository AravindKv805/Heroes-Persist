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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.heroespersist.sports.interfaces.artifact.ArtifactDao;
import com.heroespersist.sports.interfaces.artifact.ArtifactService;
import com.heroespersist.sports.interfaces.utility.UtilityDao;
import com.heroespersist.sports.model.Artifact;

/**
 * @author Sai Pranav
 *
 */

@Component
@Transactional
public class ArtifactServiceImpl implements ArtifactService {

	@Autowired
	ArtifactDao artifactDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	public List<Artifact> getArtifacts(){
		return artifactDao.getArtifacts();
	}
	
	public List<Artifact> getBestArtifacts(int numberOfElementsNeeded){
		List<Artifact> artifacts =  artifactDao.getArtifacts();
		if(artifacts.size() >= numberOfElementsNeeded){
			artifacts = artifacts.subList(0, numberOfElementsNeeded);
		}
		return artifacts;
	}
	
}
