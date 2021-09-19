package com.mycompany.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Reading extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	Profile p;
	JTextArea textArea;
	UserDetailsService user;
	public Reading(Profile p,UserDetailsService user) {
		
		this.p=p;
		this.user=user;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 664, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GREEN);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(10, 11, 625, 467);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea(100,100);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(SystemColor.info);
		textArea.setEditable(false);
		textArea.setBounds(1, 1, 595, 2104);
		panel.add(textArea);
		
		   JScrollPane scrollableTextArea = new JScrollPane(textArea);  
			  
	        //scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

		//JScrollBar scrollBar_1 = new JScrollBar();
		//scrollBar_1.setValue(1);
		//scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollableTextArea.setBackground(Color.GRAY);
		scrollableTextArea.setForeground(Color.BLACK);
		scrollableTextArea.setBounds(10, 22, 593, 450);
		panel.add(scrollableTextArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(213, 499, 422, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			p.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(305, 11, 117, 23);
		panel_1.add(btnNewButton);
		setResizable(false);
		read_data(user,this);
		setVisible(true);
	}
	private void read_data(UserDetailsService user, Reading read) {
		// TODO Auto-generated method stub
		String filename1=user.getFile_name();
		File f3=new File("C:\\Users\\srika\\javaprgms\\DocumentsDairy\\"+user.getName()+"\\"+filename1);
		f3.setWritable(false);
		f3.setReadOnly();
		String Data="";
		Scanner myReader;
		try {
			myReader = new Scanner(f3);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Data=Data+data+"\n";
			}
		read.textArea.setText(Data);
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}	
		
	}
}
