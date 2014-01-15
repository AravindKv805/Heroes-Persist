/**
 * 
 */
package com.lister.sports.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO Wrapper class for Match DO. It takes care of transferring the match details required for UI display.
 * 
 * @author sai_pranav
 *
 */
public class MatchWrapper {

	private List<MatchModel> matches;
	
	public MatchWrapper(){
		matches = new ArrayList<MatchModel>();
	}

	public List<MatchModel> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchModel> matches) {
		this.matches = matches;
	}
	
}
