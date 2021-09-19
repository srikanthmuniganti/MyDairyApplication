package com.mycompany.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MsgBox extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	JTextArea textArea;
	Profile p;
	public MsgBox(UserDetailsService uds,String s) 
			{
		//this.p=p;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 583, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 547, 355);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		 textArea = new JTextArea(500,500);
		textArea.setBorder(new LineBorder(Color.BLACK, 2, true));
		textArea.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(41, 26, 482, 300);
		panel.add(textArea);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(10, 377, 557, 51);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {						
						try {
							okButtonActionPerformed(e,s,uds);
						} catch (IOException e1) {}
		}
		});
		
		okButton.setBounds(451, 11, 96, 28);
		okButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);			
		setVisible(true);
		
	}
	private void okButtonActionPerformed(ActionEvent e,String s,UserDetailsService uds) throws IOException 
	{
		String a;
		switch(s)
		{
				case "Edit":	this.textArea.setEditable(true);
								a=this.textArea.getText();
								String filename=uds.getFile_name();
								File f=new File("C:\\Users\\srika\\javaprgms\\DocumentsDairy\\"+uds.getName()+"\\"+filename);
								f.setWritable(true);
								FileWriter fileWritter = new FileWriter(f,true);
						        BufferedWriter bw = new BufferedWriter(fileWritter);
						        bw.newLine();
						        bw.write(a);
					            bw.close();
					            fileWritter.close();
								try {
									new AESFileEncryption(filename,uds.getName());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								//p.setVisible(true);
								dispose();break;	
						
				case "Add":		this.textArea.setEditable(true);
								String b=this.textArea.getText();
								String filenames=uds.getFile_name();
								File f1=new File("C:\\Users\\srika\\javaprgms\\DocumentsDairy\\"+uds.getName()+"\\"+filenames);
								f1.setWritable(true);
								FileWriter fileWritter2 = new FileWriter(f1,true);
						        BufferedWriter pw = new BufferedWriter(fileWritter2);
						        pw.newLine();
						        pw.write(b);
						        pw.close();
						        fileWritter2.close();
						        try {
									new AESFileEncryption(filenames,uds.getName());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								dispose();
								//p.setVisible(true);
								break;
		}				
	}
}
