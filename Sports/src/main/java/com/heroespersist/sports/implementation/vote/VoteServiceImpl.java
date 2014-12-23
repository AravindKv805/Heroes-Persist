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
package com.heroespersist.sports.implementation.vote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.heroespersist.sports.exception.SportsException;
import com.heroespersist.sports.interfaces.team.TeamDao;
import com.heroespersist.sports.interfaces.utility.UtilityDao;
import com.heroespersist.sports.interfaces.vote.VoteDao;
import com.heroespersist.sports.interfaces.vote.VoteService;
import com.heroespersist.sports.model.Artifact;
import com.heroespersist.sports.model.Team;
import com.heroespersist.sports.model.Vote;
import com.heroespersist.sports.webservice.vote.SubVoteForm;
import com.heroespersist.sports.webservice.vote.VoteForm;

/**
 * @author Sai Pranav
 *
 */

@Component
@Transactional
public class VoteServiceImpl implements VoteService{
	
	@Autowired
	VoteDao voteDao;
	
	@Autowired
	TeamDao teamDao;
	
	@Autowired
	UtilityDao utilityDao;
	
	
	/*Vote Functions*/
	@Override
	public int recordVotes(String ipAddress, VoteForm voteForm) {
		Vote vote = utilityDao.getVote(ipAddress);
		if(vote != null){
			throw new SportsException("Kalla Vote [ Don't vote again and again BOSS ]");
		}
		Artifact artifact;
		Team team;
		List<Artifact> artifacts = new ArrayList<Artifact>();
		
		for(SubVoteForm subVoteForm : voteForm.getSubVoteForms()){
			artifact = utilityDao.getArtifact(subVoteForm.getArtifactId());
			if(artifact != null){
				artifact.setPoints(artifact.getPoints()+subVoteForm.getPoints());
				team = artifact.getTeam();
				team.setScore((Integer.parseInt(team.getScore()) + subVoteForm.getPoints() )+"");
				teamDao.modifyShow(team, team.isShow());
				artifacts.add(artifact);
			}
			else{
				throw new SportsException("Artifact does not exist");
			}
		}
		vote = new Vote();
		vote.setIpAddress(ipAddress);
		vote.setArtifacts(artifacts);
		return voteDao.recordVotes(vote);
	}

}
