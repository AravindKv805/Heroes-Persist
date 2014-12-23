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
package com.heroespersist.sports.webservice.artifact;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.heroespersist.sports.exception.RESTException;
import com.heroespersist.sports.interfaces.artifact.ArtifactService;
import com.heroespersist.sports.model.Artifact;

/**
 * @author Sai Pranav
 *
 */
@Component
@Path("/artifact")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArifactWebService {

	@Autowired
	ArtifactService artifactService;
	
	@GET
	public List<Artifact> getArtifacts() {
		try{
			return artifactService.getArtifacts();
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
	}
	
	@GET
	@Path("/best")
	public List<Artifact> getBestArtifacts(@QueryParam("numberOfElementsNeeded") int numberOfElementsNeeded) {
		try{
			return artifactService.getBestArtifacts(numberOfElementsNeeded);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
	}
	
}
