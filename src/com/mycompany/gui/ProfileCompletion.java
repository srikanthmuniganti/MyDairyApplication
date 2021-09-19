package com.mycompany.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ProfileCompletion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel lblNewLabel;
	File f;
	String name,selectedBook;
	MainPage m;
	public ProfileCompletion(MainPage m,String username) {
		this.m=m;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 556, 481);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Complete Profile", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(57, 28, 422, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "UserName", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(68, 20, 286, 53);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(username);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Full Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(68, 84, 286, 53);
		panel.add(textField_1);
		
		JLabel lblNewLabel1 = new JLabel("Gender  :");
		lblNewLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel1.setBounds(68, 156, 92, 37);
		panel.add(lblNewLabel1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
					@SuppressWarnings("unchecked")
					JComboBox<String> jcombobox=(JComboBox<String>) e.getSource();
			        selectedBook = (String) jcombobox.getSelectedItem();
			}
		});
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Male", "Female", "Others" }));
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel1.setLabelFor(comboBox);
		comboBox.setBounds(183, 156, 171, 37);
		panel.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setEditable(true);
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "File Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_2.setBounds(68, 214, 171, 53);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   if((textField_1.getText().trim()).equals(""))
			        {
			        	textField_2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 1, true));
			        	textField_2.setText("");
			        }
			        else
			        {
			        	name=textField_1.getText().trim();
			 	        Calendar cal = Calendar.getInstance();
			 	        int year=cal.get(Calendar.YEAR);
			 	        textField_2.setText(name+year+".txt");
			 	      /*  String address="C:/users/srika/javaprgms/DocumentsDairy/"+name+"/";
			 	        File f2=new File(address);
			 	        if(f2.mkdir())
			 	        {
			 	        	f=new File(f2.getAbsolutePath()+"/"+name+year+".txt");
							 	 try {
			 	        				f.createNewFile();
							 	       textField_2.setText(f.getName());
							 	       FileWriter f1;
						 	    	   f1=new FileWriter(f);
						 	    	   f1.write("Welcome "+name+" Hope great year a head...");
						 	    	   f1.close();
							 	 	 }
							 	 catch (IOException e1) {}
			 	        }*/
			 	       
					} 
			   }
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnNewButton.setBounds(249, 224, 105, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButton_1(e);
				} 
				catch (IOException e1) {}							
			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setForeground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(171, 294, 105, 37);
		panel.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(68, 334, 286, 24);
		panel.add(lblNewLabel);
	}
	public void btnNewButton_1(java.awt.event.ActionEvent evt) throws IOException
	{
		boolean b=validate_usersname(name,this,f);
		String username=textField.getText();
		if(b && textField_2.getText()!="")
		{
			boolean bool=db_connection(username,name,selectedBook,textField_2.getText(),name);
			if(bool)
			{
				m.lblNewLabel.setText("please click on continue to profile...");
				m.btnNewButton1.setEnabled(true);
				m.btnNewButton.setEnabled(false);
				name=textField_1.getText().trim();
	 	        Calendar cal = Calendar.getInstance();
	 	        int year=cal.get(Calendar.YEAR);
	 	        String address="C:/users/srika/javaprgms/DocumentsDairy/"+name+"/";
	 	        File f2=new File(address);
	 	        if(f2.mkdir())
	 	        {
	 	        	f=new File(f2.getAbsolutePath()+"/"+name+year+".txt");
					 	 try {
	 	        				f.createNewFile();
					 	       FileWriter f1;
				 	    	   f1=new FileWriter(f);
				 	    	   f1.write("Welcome "+name+" Hope great year a head...");
				 	    	   f1.close();
					 	 	 }
					 	 catch (IOException e1) {}
	 	        }
		
				dispose();
				
			}
			else
			{
				m.btnNewButton1.setEnabled(false);
				m.btnNewButton.setEnabled(true);
			}
			
		}
		
	}
	
	private boolean db_connection(String username, String name2, String selectedBook2, String name3,String name4) {
		try {
			
			String url="jdbc:mysql://localhost:3306/myDairy";
			String un="srikanth_muniganti";
			String ps="Sri7977kanth@";
	             
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn=DriverManager.getConnection(url,un,ps);
				username=username.toUpperCase();	
				name4=name4+".enc";
				String sql="insert into myDairy.user_detail_store(user_name,name,gender,file_name,enc_file_name) values(\""+username+"\",\""+name2+"\",\""+selectedBook2+"\",\""+name3+"\",\""+name4+"\");";
			
				System.err.println("first  "+sql);
				PreparedStatement ps1=cn.prepareStatement(sql);
				ps1.executeUpdate();
				System.err.println("query executed");
				String a="completed";
				String sql2="update mydairy.registrations set profile_complete=\""+a+"\" where user_name=\""+username+"\";";
				
				System.err.println("second  "+sql2);
					ps1=cn.prepareStatement(sql2);
					ps1.executeUpdate();
					
				ps1.close();
				//ps2.close();
				cn.close();
			}
		
		catch(Exception e)
		{
			this.lblNewLabel.setText("File name already exists! Try changing file name.");
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public static boolean validate_usersname(String usersname,ProfileCompletion p,File f)
	{
		String usernname=p.textField_1.getText().trim();
       
        String regex1="^[A-Za-z ]{4,50}$";
        Pattern pattern1=Pattern.compile(regex1);       
        Matcher matcher1= pattern1.matcher(usernname);
        if(!( (matcher1.matches())))
        {
        	p.textField_1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 1, true));
        	p.textField_2.setText("");
           return false;
           
        }
        else
        {
	       p.textField_1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,255,100), 3, true));
	       //p.textField_2.setText(f.getName());
	       return true;
        }
		
	}
}
