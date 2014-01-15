package com.lister.sports.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Custom javax.ws.rs exception for throwing Sports Exceptions.
 * 
 * @author sai_pranav
 *
 */

public class RESTException extends WebApplicationException{
	
	public RESTException(){
		super(Response.status(Response.Status.BAD_REQUEST)
	             .entity("Sports Exception").type(MediaType.TEXT_PLAIN).build());
	}
	
	public RESTException(String message){
		super(Response.status(Response.Status.BAD_REQUEST)
	             .entity(message).type(MediaType.TEXT_PLAIN).build());
	}
	
}
