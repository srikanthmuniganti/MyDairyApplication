package com.mycompany.gui.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	
	public static void dbConnection(String username,String password) throws ClassNotFoundException, SQLException
	{
		
		try {
		
		String url="jdbc:mysql://localhost:3306/myDairy";
		String un="srikanth_muniganti";
		String ps="srikanth7977@";
             
		//loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,un,ps);
			username=username.toUpperCase();			
			String sql="insert into myDairy.registrations(user_name,password) values(\""+username+"\",\""+password+"\");";
		
		//System.out.println(sql);
			PreparedStatement ps1=cn.prepareStatement(sql);
			ps1.executeUpdate();
			ps1.close();
			cn.close();
			}
	
	catch(Exception e)
	{
		
	}
			
	}
}
	
	
