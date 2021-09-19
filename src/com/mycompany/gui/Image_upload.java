package com.mycompany.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Blob;

public class Image_upload {
	Blob a;
	public Image_upload() throws ClassNotFoundException, SQLException, IOException
	{
		String username="srikanthmuniganti7978@gmail.com";
		String password="Srikanth7977@";
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/myDairy";
		String un="root";
		String ps="srikanth7977@";
              //loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url,un,ps);
			System.out.println("connection established");
                       
			//String sql="select * from myDairy.registrations(user_name,password) where user_name=\""+username+"\"  password=\""+password+"\";";
			//System.out.println(sql);
			PreparedStatement ps1=cn.prepareStatement("insert into mydairy.images values(?,?);");
			File f=new File("C:\\Users\\srika\\javaprgms\\database_connection\\saikumar.jpg");
			System.out.println("file created");
			System.out.println(f.getAbsolutePath());
			FileInputStream fis=new FileInputStream(f);
			System.out.println("stream created");
			ps1.setString(1,username);
			ps1.setBinaryStream(2, fis);
			System.out.println("query execution");
		int rs=ps1.executeUpdate();
		System.out.println("file uploaded");
		//fis.close();
		try{
            if(fis != null) fis.close();
            if(ps1 != null) ps1.close();
            if( cn!= null) cn.close();
        } catch(Exception ex){}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
							new Image_upload();		 
	}
}
