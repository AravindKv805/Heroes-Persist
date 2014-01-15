package com.lister.sports.webservice.game;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lister.sports.dto.MatchWrapper;
import com.lister.sports.dto.PlayerWrapper;
import com.lister.sports.dto.TeamWrapper;
import com.lister.sports.exception.RESTException;
import com.lister.sports.interfaces.game.GameService;
import com.lister.sports.interfaces.match.MatchService;
import com.lister.sports.interfaces.player.PlayerService;
import com.lister.sports.interfaces.team.TeamService;
import com.lister.sports.model.Game;
import com.lister.sports.utility.DTOUtility;

/**
 * @author sai_pranav
 *
 */
@Component
@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameWebService {

	@Autowired
	GameService gameService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	MatchService matchService;
	
	@POST
	public Response addGame(GameForm gameForm) {
		int tempId;
		try{
			tempId = gameService.addGame(gameForm);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response modifyGame(@PathParam("id") int id, GameForm gameForm) {
		int tempId;
		try{
			tempId = gameService.modifyGame(id, gameForm);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteGame(@PathParam("id") int id) {
		int tempId;
		try{
			tempId = gameService.deleteGame(id);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
	@GET
	public List<Game> getGameList() {
		return gameService.getGames();
	}
	
	@GET
	@Path("/players")
	public PlayerWrapper getPlayersByGame(@QueryParam("gameName") String gameName, @QueryParam("gameCategory") String gameCategory) {
		try{
			return DTOUtility.createPlayerWrapper(playerService.getPlayersByGame(gameName, gameCategory));
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
	}
	
	@GET
	@Path("/teams")
	public TeamWrapper getTeamsByGame(@QueryParam("gameName") String gameName, @QueryParam("gameCategory") String gameCategory, @QueryParam("showCriteria") boolean showCriteria) {
		try{
			return DTOUtility.createTeamWrapper(teamService.getTeamsByGame(gameName, gameCategory,showCriteria));
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
	}
	
	@GET
	@Path("/matches")
	public MatchWrapper getMatchesByGame(@QueryParam("gameName") String gameName, @QueryParam("gameCategory") String gameCategory) {
		try{
			return DTOUtility.createMatchWrapper(matchService.getMatchesByGame(gameName, gameCategory));
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
	}
	
}
