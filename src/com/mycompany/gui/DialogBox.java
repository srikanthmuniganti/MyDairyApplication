package com.mycompany.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
	
public class DialogBox extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public DialogBox(String input,Register r) {
		
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Gmail validation");
		setBounds(100, 100, 450, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 204, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBackground(new Color(255, 255, 255));
			textField.setBounds(89, 95, 257, 35);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("please enter otp:");
		lblNewLabel.setBounds(89, 70, 132, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(input.equals(textField.getText()))
								{
							// on successful validation
							r.setVisible(true);
							r.jButton3.setEnabled(true);
							dispose();
								}
						else
						{
							textField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 3, true));
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		this.setVisible(true);
	}
}
