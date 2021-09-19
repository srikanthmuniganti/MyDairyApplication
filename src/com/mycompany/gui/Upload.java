package com.mycompany.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Upload {
	public Upload(Profile p)
	{
		String  text=p.btnNewButton_3.getText();
		
		String url="jdbc:mysql://localhost:3306/myDairy";
		String un="srikanth_muniganti";
		String ps="Sri7977kanth@";		
              //loading driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,un,ps);
			System.out.println("connection established");
			
			//PreparedStatement ps1=cn.prepareStatement("select * from user_details where user_name=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//ps1.setString(1,"");
			//ps1.setBlob(2, "");
			//ResultSet rs=ps1.executeQuery();
	
			/*if(rs.next())
			{

				p.lblNewLabel_1.setText("welcome "+rs.getString(2));
				p.lblNewLabel_2.setText(rs.getString(4));
				
			}*/
	}
		catch(Exception e)
		{
			
		}
		System.out.println("near if stmt");
	if (text.equals("Upload"))
	{
		p.btnNewButton_3.setText("Update");
	}
	else {
		
	}
	}

}
