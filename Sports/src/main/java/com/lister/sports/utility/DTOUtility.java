/**
 * 
 */
package com.lister.sports.utility;

import java.util.List;

import com.lister.sports.dto.MatchWrapper;
import com.lister.sports.dto.MatchModel;
import com.lister.sports.dto.PlayerModel;
import com.lister.sports.dto.PlayerWrapper;
import com.lister.sports.dto.TeamModel;
import com.lister.sports.dto.TeamWrapper;
import com.lister.sports.model.Match;
import com.lister.sports.model.Player;
import com.lister.sports.model.Team;

/**
 * Utility Class for transfer of attributes from Data Object (DO) to Data Transfer Object (DTO)
 * 
 * @author sai_pranav
 *
 */

public class DTOUtility {

	public static MatchWrapper createMatchWrapper(List<Match> matches){
		MatchWrapper matchWrapper = new MatchWrapper();
		String teamName1 = "-";
		String teamName2 = "-";
		String teamRating1 = "-";
		String teamRating2 = "-";
		for(Match match: matches){
			if(match.getTeams().size()==1){
				teamName1 = match.getTeams().get(0).getName();
				teamRating1 = match.getTeams().get(0).getRating();
			}
			else if(match.getTeams().size()==2){
				teamName1 = match.getTeams().get(0).getName();
				teamRating1 = match.getTeams().get(0).getRating();
				teamName2 = match.getTeams().get(1).getName();
				teamRating2 = match.getTeams().get(1).getRating();
			}
			MatchModel model = new MatchModel.MatchModelBuilder(match.getId())
											 .gameName(match.getGame().getName())
											 .gameCategory(match.getGame().getCategory())
											 .teamName1(teamName1)
											 .teamRating1(teamRating1)
											 .score(match.getScore())
											 .teamName2(teamName2)
											 .teamRating2(teamRating2)
											 .round(match.getRound())
											 .scheduledTime(match.getScheduledTime())
											 .location(match.getLocation())
											 .status(match.getStatus())
											 .winner(match.getWinner())
											 .show(match.isShow())
											 .build();
			matchWrapper.getMatches().add(model);
		}
		return matchWrapper;
	}
	
	public static PlayerWrapper createPlayerWrapper(List<Player> players){
		PlayerWrapper playerWrapper = new PlayerWrapper();
		for(Player player: players){
			PlayerModel model= new PlayerModel.PlayerModelBuilder(player.getEmployeeId())
											  .build();
			playerWrapper.getPlayers().add(model);
		}
		return playerWrapper;
	}
	
	public static TeamWrapper createTeamWrapper(List<Team> teams){
		TeamWrapper teamWrapper = new TeamWrapper();
		String score = "-";
		for(Team team: teams){
			if(null != team.getScore()){
				score = team.getScore();
			}
			TeamModel model= new TeamModel.TeamModelBuilder(team.getId(), team.getName())
										  .score(score)
										  .show(team.isShow())
										  .round(team.getRound())
			  							  .build();
			teamWrapper.getTeams().add(model);
		}
		return teamWrapper;
	}
}