package com.mycompany.gui;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	int un=0;
	int n=0;
	    public Register() {
	    	getContentPane().setLocation(new Point(100, 250));
	        setResizable(false);
	        initComponents();
	    }

	    private void initComponents() {
	    	
	        jPanel1 = new javax.swing.JPanel();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jPasswordField1 = new javax.swing.JPasswordField();
	        jPasswordField2 = new javax.swing.JPasswordField();
	        jButton1 = new javax.swing.JButton();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent evt) {
	        		jButton3ActionPerformed(evt);
	        		
	        	}
	        });
	        jSeparator1 = new javax.swing.JSeparator();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	        setResizable(false);
	        setLocation(new java.awt.Point(350, 150));

	        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N

	        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
	        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        jTextField1.setToolTipText("Email address");
	        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
	        jTextField1.setPreferredSize(new java.awt.Dimension(7, 34));

	        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
	        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("REGISTRATION");

	        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	        jLabel2.setText("UserName :");
	        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

	        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	        jLabel3.setText("Choose Password :");
	        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

	        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	        jLabel4.setText("Confirm Password :");
	        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

	        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
	        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        jPasswordField1.setToolTipText("Password Criteria: atleast one lowercase letter,"+"\n"
	        		+ "atleast one digit, atleast one special character [@#$%], atleast one capital letter, "+"\n"
	        		+ "length of password from minimum 8 letters to maximum 16 letters.");
	        jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
	        jPasswordField1.setPreferredSize(new java.awt.Dimension(7, 34));

	        jPasswordField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
	        jPasswordField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
	        jPasswordField2.setPreferredSize(new java.awt.Dimension(7, 34));
	        
	        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
	        jButton1.setText("SUBMIT");
	        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
	        jLabel5.setForeground(new java.awt.Color(51, 255, 51));
	        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
	        jLabel6.setForeground(java.awt.Color.red);
	        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
	        jButton2.setText("back");
	        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
	        jButton3.setText("LogIn");
	        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
	                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
	                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(10, 10, 10)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(20, 20, 20)))
	                .addContainerGap())
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(145, 145, 145)
	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(283, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel5)
	                .addGap(27, 27, 27)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(31, 31, 31)
	                .addComponent(jLabel6)
	                .addGap(53, 53, 53)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(46, 46, 46))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(108, Short.MAX_VALUE)
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(114, 114, 114))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	    }

	    private void jButton2ActionPerformed(ActionEvent evt) {
	    	//going back to home.java	
	       new Home().setVisible(true);
	        dispose();
	    }
	    private void jButton3ActionPerformed(ActionEvent evt) {
	    	//	  redirecting to login  
	       new SignIn(jTextField1.getText()).setVisible(true);
	        dispose();
	    }
	    private void jButton1ActionPerformed(ActionEvent evt) {
	    	// submitting for validation of details
	      new Validation(this);  
	    }
	    
	    
	    public javax.swing.JButton jButton1;
	    public javax.swing.JButton jButton2;
	    public javax.swing.JButton jButton3;
	    public javax.swing.JLabel jLabel1;
	    public javax.swing.JLabel jLabel2;
	    public javax.swing.JLabel jLabel3;
	    public javax.swing.JLabel jLabel4;
	    public javax.swing.JLabel jLabel5;
	    public javax.swing.JLabel jLabel6;
	    public javax.swing.JPanel jPanel1;
	    public javax.swing.JPasswordField jPasswordField1;
	    public javax.swing.JPasswordField jPasswordField2;
	    public javax.swing.JSeparator jSeparator1;
	    public javax.swing.JTextField jTextField1;
	    }
