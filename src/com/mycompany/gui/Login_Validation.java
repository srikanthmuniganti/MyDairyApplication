package com.mycompany.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_Validation {
	public Login_Validation(String username,String password) throws SQLException, ClassNotFoundException
	{
		
		String url="jdbc:mysql://localhost:3306/myDairy";
		String un="srikanth_muniganti";
		String ps="Sri7977kanth@";
		
              //loading driver
		System.err.println("Login Validation......");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,un,ps);
			//if(cn!=null)
			System.err.println("connection established");
			PreparedStatement ps1=cn.prepareStatement("select * from registrations where user_name=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps1.setString(1,username);
			//ps1.setString(2, password);
			ResultSet rs=ps1.executeQuery();
			System.err.println("result set "+ rs.getFetchSize());
			if(rs.next())
			{
				System.err.println(rs.getString(1));
				if(password.equals(rs.getString(2))) {
					System.err.println("password verified");
					new MainPage(rs.getString(3),username).setVisible(true);
				}
				else 
				{
					SignIn s=new SignIn("");
					s.setVisible(true);
					System.err.println("password not verified");
					s.jTextField1.setText(rs.getString(1).toLowerCase());
					s.lblNewLabel_1.setText("Invalid username or password!");
					
				}
			}
			else 
			{
				SignIn s=new SignIn("");
				s.setVisible(true);
				s.lblNewLabel_1.setText("record not found!");
				
			}
		
			rs.close();
			ps1.close();
			cn.close();
			}
			
			public static void main(String []a) throws Exception
			{
				new Login_Validation("srikanthmuniganti7977@gmail.com","Srikanth7977@");
			}
	
	
}