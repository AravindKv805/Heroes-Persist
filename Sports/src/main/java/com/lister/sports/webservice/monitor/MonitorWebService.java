package com.lister.sports.webservice.monitor;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lister.sports.exception.RESTException;
import com.lister.sports.interfaces.monitor.MonitorService;

/**
 * @author sai_pranav
 *
 */
@Component
@Path("/monitor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MonitorWebService {

	@Autowired
	MonitorService monitorService;
	
	@POST
	public Response recordPageHits(@Context HttpServletRequest req, MonitorForm monitorForm){
		int tempId;
		try{
			tempId = monitorService.recordPageHits(req.getRemoteAddr(), monitorForm);
		}
		catch(Exception e){
			throw new RESTException(e.getMessage());
		}
		return Response.status(200).entity(tempId).build();
	}
	
}
