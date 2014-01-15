package com.lister.sports;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Logout extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		HttpSession session;

		// log out
		session = req.getSession(false);
		if(session.getId()!=null){
			session.removeAttribute("role");
			session.invalidate();
		}
		try {
			PrintWriter out = res.getWriter();
			out.print("<script>window.location.assign('index.html')</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
