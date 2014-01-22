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
package com.lister.sports.webservice.team;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lister.sports.dto.PlayerWrapper;
import com.lister.sports.exception.RESTException;
import com.lister.sports.interfaces.player.PlayerService;
import com.lister.sports.interfaces.team.TeamService;
import com.lister.sports.utility.DTOUtility;

/**
 * @author Sai Pranav
 *
 */
@Component
@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamWebService {

	@Autowired
	TeamService teamService;
	
	@Autowired
	PlayerService playerService;
	
	@POST
	public Response addTeam(TeamForm teamForm) {
		int tempId;
		try{
/*			teamForm.getPlayers().remove(0);*/
			tempId = teamService.addTeam(teamForm);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response modifyTeam(@PathParam("id") int id, TeamForm teamForm){
		int tempId;
		try{
			tempId = teamService.modifyTeam(id,teamForm);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@PUT
	@Path("/livescores/{id}")
	public Response modifyTeamFromLivescores(@PathParam("id") int id, SimpleTeamForm teamFormSimple){
		int tempId;
		try{
			tempId = teamService.modifyTeam(id,teamFormSimple);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteTeam(@PathParam("id") int id){
		int tempId;
		try{
			tempId = teamService.deleteTeam(id);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@POST
	@Path("/{id}/players/{employeeId}")
	public Response modifyTeamAddPlayer(@PathParam("id") int id, @PathParam("employeeId") String employeeId) {
		int tempId;
		try{
			tempId = teamService.modifyTeamAddPlayer(id, employeeId);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@DELETE
	@Path("/{id}/players/{employeeId}")
	public Response modifyTeamDeletePlayer(@PathParam("id") int id, @PathParam("employeeId") String employeeId) {
		int tempId;
		try{
			tempId = teamService.modifyTeamDeletePlayer(id, employeeId);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@PUT
	@Path("/{id}/show/{toShow}")
	public Response modifyTeamShow(@PathParam("id") int id, @PathParam("toShow") boolean toShow) {
		int tempId;
		try{
			tempId = teamService.modifyTeamShow(id, toShow);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@POST
	@Path("/admin/{id}")
	public Response modifyTeamFromAdmin(@PathParam("id") int id, TeamForm teamForm) {
		int tempId;
		try{
			/*teamForm.getPlayers().remove(0);*/
			tempId = teamService.modifyTeamFromAdmin(id, teamForm);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@GET
	@Path("{teamid}/players")
	public PlayerWrapper getPlayersByTeam(@PathParam("teamid") int teamId) {
		try{
			return DTOUtility.createPlayerWrapper(playerService.getPlayersByTeam(teamId));
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
	}
	
}
