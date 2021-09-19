package com.mycompany.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Profile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblNewLabel_1,lblNewLabel_2,lblNewLabel_3, lblNewLabel;
	public String msg,username,names;
	JButton btnNewButton_3;
	PreparedStatement ps1;
	Connection cn;
	public Profile(String username) throws Exception {
		this.username=username;
		UserDetailsService user = Retrieve_Data.retrieve_Data(username);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Profile");
		setBounds(100, 100, 652, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 22, 583, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new SignIn("").setVisible(true);
				dispose();				
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(484, 11, 89, 23);
		panel.add(btnNewButton);
		
		lblNewLabel = new JLabel("photo");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 11, 101, 112);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(username);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(142, 34, 250, 30);
		//lblNewLabel_1.setB
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 204), 2, true));
		panel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.setBounds(31, 185, 542, 159);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgdialog(e,user);
			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(102, 204, 102), 2, true));
		btnNewButton_1.setBounds(287, 47, 106, 42);
		panel_1.add(btnNewButton_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBorder(new LineBorder(new Color(153, 204, 204), 1, true));
		btnAdd.setBounds(414, 47, 106, 42);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgdialog1(e,user);
			}
		});
		panel_1.add(btnAdd);
		
		System.err.println("username "+username);
		//UserDetailsService user = Retrieve_Data.retrieve_Data(username);
		
		lblNewLabel_2 = new JLabel(user.getEnc_file_name());
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_2.setBounds(30, 47, 247, 42);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Read");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgdialog2(e,user);
			}
		});
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(362, 106, 106, 42);
		panel_1.add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 150, 542, 12);
		panel.add(separator);
		
		btnNewButton_3 = new JButton("Upload");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button3ActionPerformed(e,user.getUser_name());				
			}
		});
		btnNewButton_3.setBackground(new Color(255, 204, 255));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_3.setBounds(165, 86, 89, 23);
		panel.add(btnNewButton_3);
		//retrieving_data(username);
		
		
		
		
		
		
		
	}

		protected void button3ActionPerformed(ActionEvent e, String user_name) {
						
			JFileChooser fileChooser=new JFileChooser();
			//fileChooser.accept(new File(""));
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int path = fileChooser.showOpenDialog(null);
			System.out.println(path);
			System.err.println(fileChooser.getSelectedFile().getAbsolutePath());
			if(e.getSource() == btnNewButton_3)
			{
				if(JFileChooser.APPROVE_OPTION == path)
				{
					String url="jdbc:mysql://localhost:3306/mydairy";
					String un="srikanth_muniganti";
					String ps="Sri7977kanth@";
					
					UserDetailsService uds=null;
					try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection cn=DriverManager.getConnection(url,un,ps);
							InputStream in = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());	
							System.err.println(fileChooser.getSelectedFile().getAbsolutePath());
							String sql="insert into myDairy.images(user_name, image) values(?,?);";
							PreparedStatement ps1=cn.prepareStatement(sql);
							ps1.setString(1,user_name);
							ps1.setBlob(2, in);
							System.out.println("after pepared");
							ps1.executeUpdate();
							String path2 = fileChooser.getSelectedFile().getAbsolutePath();
							lblNewLabel.setIcon(setIcon(path2, null));
							cn.close();			
							
				}
					catch (Exception ee)
					{
						ee.printStackTrace();
					}
			}
			
			
			
			}
			
			
			new Upload(this);
		}

		/*
		 * public void retrieving_data(String username) throws Exception { new
		 * Retrieve_Data(username,this); }
		 */	
		public void msgdialog2(ActionEvent e,UserDetailsService uds ) {// reading
			new Reading(this,uds);
			//this.setVisible(false);
		}
		public void msgdialog(ActionEvent e, UserDetailsService uds) {//editing
			new MsgBox(uds,"Edit");
			//this.setVisible(false);
		}
		protected void msgdialog1(ActionEvent e, UserDetailsService uds) {// add
			 Calendar cal = Calendar.getInstance();
			 	int date=cal.get(Calendar.DATE);
	 	        int year=cal.get(Calendar.YEAR);
			 	int month=cal.get(Calendar.MONTH)+1;
			new MsgBox(uds,"Add").textArea.setText(date+"/"+month+"/"+year+"     ");	
			//this.setVisible(false);
		}
		
		ImageIcon imageIcon;
		public ImageIcon setIcon(String path, byte[] bytes)
		{
			if(path!=null)
			{
				imageIcon=new ImageIcon(path);
			}
			else {
				imageIcon=new ImageIcon(bytes);
			}
			
			Image img=imageIcon.getImage();
			Image img2=img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
			return new ImageIcon(img2);
			
			
			
		}
}




