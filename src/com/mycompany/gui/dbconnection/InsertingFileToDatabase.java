package com.mycompany.gui.dbconnection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertingFileToDatabase {
   public static void main(String args[]) throws Exception {
      //Registering the Driver
	   String url="jdbc:mysql://localhost:3306/myDairy";
		String un="root";
		String ps="srikanth7977@";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,un,ps);
				if(con!=null)
					System.out.println("connection established");
      System.out.println("Connection established......");
      //Inserting values
      String query = "INSERT INTO mydairy.Articles(Name, Article) VALUES (?, ?)";
      System.out.println("afetr query");
      PreparedStatement pstmt = con.prepareStatement(query);
      pstmt.setString(1, "article1");
      FileReader reader = new FileReader("C:\\Users\\srika\\javaprgms\\D_Stream.java");
      pstmt.setCharacterStream(2, reader);
      pstmt.execute();
      pstmt.setString(1, "article2");
      reader = new FileReader("C:\\Users\\srika\\javaprgms\\D_Stream.java");
      pstmt.setCharacterStream(2, reader);
      pstmt.execute();
      pstmt.setString(1, "article3");
      reader = new FileReader("C:\\Users\\srika\\javaprgms\\D_Stream.java");
      pstmt.setCharacterStream(2, reader);
      pstmt.execute();
      System.out.println("Data inserted......");
   }
}