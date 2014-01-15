package com.lister.sports.exception;

/**
 * Custom Exception from Service Layer depending on DAO alterations.
 * 
 * @author sai_pranav
 *
 */
public class SportsException extends Exception{

	public SportsException(String message){
		super(message);
	}
	
}
