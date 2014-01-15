package com.lister.sports;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		PrintWriter out = null;
		HttpSession session;
		try {
			out = res.getWriter();
			// log in check
			session = req.getSession(false);
			if (session == null) {
				out.print("false");
			}
			else{
				out.print("true");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("false");
		}
	}
}

