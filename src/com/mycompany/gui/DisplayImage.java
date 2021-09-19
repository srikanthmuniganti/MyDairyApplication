package com.mycompany.gui;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class DisplayImage extends JFrame {


private static final long serialVersionUID = 1L;
Connection connection = null;
PreparedStatement statement = null;

ResultSet result;

public DisplayImage() {
   // super("Image Display");
    setSize(600, 600);
    connection = getConnection();
    System.out.println("outside try");
    try { // table name:image and second image is field name
    	System.out.println("inside try");
        statement = connection.prepareStatement("select image from mydairy.images where user_name=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        statement.setString(1, "srikanthmuniganti7977@gmail.com");
        System.out.println("query created");
        result = statement.executeQuery();
        System.out.println("query executed");

        byte[] image = null;
        while (result.next()) {
            image = result.getBytes("image");

        }
        System.out.println("while completed");
        Image img = Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon = new ImageIcon(img);
        JLabel lPhoto = new JLabel();
        lPhoto.setIcon(icon);
        add(lPhoto);

        
    } catch (Exception e) {
        // TODO Auto-generated catch block
       // e.printStackTrace();
    }

    setVisible(true);
}

public Connection getConnection() {
    Connection connection = null;

    try {
    	String url="jdbc:mysql://localhost:3306/myDairy";
		String un="srikanth_muniganti";
		String ps="srikanth7977@";
              //loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(url,un,ps);
			System.out.println("connection established");


    } catch (Exception e) {
        System.out.println("Error Occured While Getting the Connection: - "
                + e);
    }
    return connection;
}
public static void main(String []a) throws NullPointerException
{
	new DisplayImage().setVisible(true);
}
}
