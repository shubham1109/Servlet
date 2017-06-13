package com.shubham;

import java.sql.*;

public class DataBaseConnect {

	public boolean DataBaseConnect(String query,boolean commandType)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Shubham","root","");
			Statement stmt=con.createStatement();  
			if(commandType){
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			}
			else
			{
				boolean a= stmt.execute(query);
				if(a)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
