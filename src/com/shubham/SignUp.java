package com.shubham;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class SignUp implements Servlet {
	public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname =(String) request.getParameter("username");
		String pass =(String) request.getParameter("password");
		String fullname =(String) request.getParameter("fullname");
		System.out.println(uname+pass+fullname);
		String query = "INSERT INTO cebs(username,password,fullname) VALUES('"+uname+"','"+pass+"','"+fullname+"')";
		System.out.println(query);
		DataBaseConnect db = new DataBaseConnect();
		boolean c = db.DataBaseConnect(query,false);

		PrintWriter pw = response.getWriter();	
		
		if(c){
			pw.println("Write Successfully");
		}
		else
		{
			pw.println("Error Writting");
		}
		pw.close();
		
		
	}

}
