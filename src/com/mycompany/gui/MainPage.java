package com.mycompany.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class MainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnNewButton;
	JButton btnNewButton1;
	JLabel lblNewLabel;
	String username;
	public MainPage(String profile_complete,String username) throws SQLException, ClassNotFoundException {
					
		this.username=username;
		setTitle("profile");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 606, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 153, 51), new Color(255, 153, 153), new Color(51, 102, 204), new Color(204, 153, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(172, 84, 267, 57);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Complete");
		btnNewButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(194, 140, 101, 35);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton(evt);
            }
        });
							
		contentPane.add(btnNewButton);
		
		btnNewButton1 = new JButton("Continue");
		btnNewButton1.setBorder(UIManager.getBorder("ComboBox.border"));
		btnNewButton1.setForeground(new Color(0, 204, 51));
		btnNewButton1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton1.setBounds(321, 140, 101, 35);
		btnNewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton1(evt);
            }

			private void btnNewButton1(ActionEvent evt) {
				try {
					new Profile(username).setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
        });
		contentPane.add(btnNewButton1);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignIn("").setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(488, 11, 89, 23);
		contentPane.add(btnNewButton_1);	
		if(profile_complete.equals("incomplete"))
		{
			lblNewLabel.setText("please click on complete to complete profile...");
			btnNewButton1.setEnabled(false);
			//btnNewButton.setEnabled(true);// change
			
		}
		else
		{
			lblNewLabel.setText("please click on continue to profile...");
			btnNewButton.setEnabled(false);
			//btnNewButton1.setEnabled(true);// change
		}
		setVisible(true);
	}
	private void btnNewButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		btnNewButton1.setEnabled(false);
		new ProfileCompletion(this,username).setVisible(true); 
	    }
}
