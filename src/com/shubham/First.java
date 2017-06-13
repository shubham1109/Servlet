package com.shubham;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class First implements Servlet {
	
    public First() {
    	
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
		String uname =(String) request.getParameter("uname");
		String pass =(String) request.getParameter("pass");
		
		PrintWriter pw = response.getWriter();
		System.out.println(uname+pass);
		String query = "select * from cebs WHERE USERNAME='"+uname+"' AND PASSWORD='"+pass+"'";
		System.out.println(query);
		DataBaseConnect db = new DataBaseConnect();
		boolean check = db.DataBaseConnect(query,true);
		System.out.print(check);
		if(check)
		{
			pw.println("Login SuccessFully");
		}
		else
		{
			pw.println("Invalid Credentials");
			
		}
		pw.close();
		
		
		
	}

}
