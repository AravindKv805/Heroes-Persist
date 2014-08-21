package com.lister.sports;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginValidator extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		HttpSession session;
		String host = "10.106.50.32";
		String port = "8080";
		
		//get username and password
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		/*
		//Jersey Client
		Client client = Client.create();
		WebResource webresource = client.resource("http://"+host+":"+port+"/Sports/webservices/loginvalidate/"+username+"/"+password);
		ClientResponse response = webresource.accept("application/json").get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new RuntimeException("Failed to get webservice result. Status"+response.getStatus());
		}
		String result = response.getEntity(String.class);
		*/
		String result;
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			 result = "true";
		}
		else{
			result = "false";
		}
		//check
		if(result=="true"){
			session=req.getSession(true);
			session.setAttribute("role", "admin");
			session.setMaxInactiveInterval(60);
			req.getRequestDispatcher("administrator-livescores.html").forward(req, res);
		}
		else{
			req.getRequestDispatcher("loginerror.html").forward(req, res);
		}
	}
}
