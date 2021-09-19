package com.mycompany.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Retrieve_Data {

	public static UserDetailsService retrieve_Data(String username) {
		String url="jdbc:mysql://localhost:3306/mydairy";
		String un="srikanth_muniganti";
		String ps="Sri7977kanth@";
		
		UserDetailsService uds=null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn=DriverManager.getConnection(url,un,ps);
				username=username.toLowerCase();
				System.out.println(username);
				PreparedStatement ps1=cn.prepareStatement("select * from mydairy.user_detail_store where user_name=?;",ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
				ps1.setString(1,username);
				System.out.println("after pepared");
				ResultSet rs=ps1.executeQuery();
				System.out.println("after query execution");
				//System.out.println("in if stmt");
				if(rs.next()) {
					uds=new UserDetailsService();
					System.err.println("Object created!!!!");	
					
					uds.setUser_name(rs.getString(1));
					System.err.println(rs.getString(1));
					
					uds.setName(rs.getString(2));
					System.err.println(rs.getString(2));
					
					uds.setGender(rs.getString(3));
					System.err.println(rs.getString(3));
					
					uds.setFile_name(rs.getString(4));
					System.err.println(rs.getString(4));
					
					uds.setEnc_file_name(rs.getString(5));
					System.err.println(rs.getString(5));
				}
						ps1.close();
						cn.close();
						return uds;						
			}
		catch(Exception e) {
			return uds;
		}
	}
}
