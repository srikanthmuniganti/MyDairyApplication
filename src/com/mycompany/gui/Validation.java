package com.mycompany.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation extends Thread {
	Register r;
	boolean b;
	public Validation(Register r)
	{
		this.r=r;
		// data base connection to submit and creating account
        String username=r.jTextField1.getText().trim();
        String choosePassword=String.valueOf(r.jPasswordField1.getPassword());
        String confirmPassword=String.valueOf(r.jPasswordField2.getPassword());
        String regex1="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern1=Pattern.compile(regex1);
        String regex2="^[6-9]{1}[0-9]{9}$";
        Pattern pattern2=Pattern.compile(regex2);
        Matcher matcher1= pattern1.matcher(username);
        Matcher matcher2= pattern2.matcher(username);    
        String regex3="^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        Pattern pattern3=Pattern.compile(regex3);
        Matcher matcher3= pattern3.matcher(choosePassword);
        
        	// user name validation        
	        if(username.length()>9 &&(matcher1.matches() || matcher2.matches()))
	        {
	        	r.jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,255,100), 1, true));
	            r.jLabel5.setText("");
	            r.jLabel6.setText("");
	            r.un=1;
	            if((choosePassword.equals(confirmPassword)) && (choosePassword.length()>=8) && matcher3.matches())
	            {
	            	r.jLabel6.setText("");
	            	r.jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,255,100), 1, true));
	            	r.jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,255,100), 1, true));
	            	r.jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,255,100), 1, true));
	                if(r.un==1)
	                {
	                	r. un=0;
	                    try {
	                          b=  dbConnection(username,choosePassword,r);
	    		              if(b)
	    		              {
	    		                r.jLabel5.setText("Registered successfully! please login to continue....");
	    		                r.jButton3.setEnabled(false);
	    		              }
	    		              else {
	    		            	  r.jLabel5.setText("");
	    		            	  r.jLabel6.setForeground(new java.awt.Color(255, 0, 0));
	    		            	  System.err.println("error validation --->  " + b);
	    		            	  r.jLabel6.setText("User already exists,please try changing username");
	    		                	
	    		              }
	                    }
	                    catch(Exception e){
	                    	  r.jLabel5.setText("");
	    	            	  r.jLabel6.setForeground(new java.awt.Color(255, 0, 0));
	    	            	  r.jLabel6.setText("problem in connecting with server please try after some time!");	                    	
	                         }
	                }
	            }
	            else
	            {
	                if((choosePassword.length()<=7)|| (confirmPassword.length()<=7))
	                {
	                	r. un=0;	                
	                    if((choosePassword.length()<=7))
	                    {
	                    	r. jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 3, true));
	                    	r.jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0), 1, true));
	                    	r. jLabel5.setText("");
	                    	r.jLabel6.setText("choose password is too short, please match criteria!");	                    		
	                    }
	                    else
	                    {
	                    	if((confirmPassword.length()<=7))
	                        {
	                        	 r.jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 3, true));
	                        	 r. jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,255,100), 1, true));
	                            //jLabel8.setText(" Password");
	                        	 r. jLabel5.setText("");
	                        	 r.jLabel6.setText("confirm password is too short, please match criteria!");	                        	
	                        }              	
	                    }                  	  
	                }
	                else{
	                	r.jLabel6.setText("Passwords didn't match   "+ r.jTextField1.getText());
	                	r. jLabel5.setText(""); 
	                	r.jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 2, true));
	                	r.jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 2, true));
	                	r.jButton3.setEnabled(false);
	                	r. un=0;
	                }

	            }
	        }
	        else// invalid user name
	        {
	        	r.jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0), 3, true));
	        	r. jLabel5.setText("");
	        	r.jLabel6.setText("please check username!");
	        	r.jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0), 1, true));
            	r.jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0), 1, true));
	        }
    }
	
	
	
	public static boolean dbConnection(String username,String password,Register r) throws InterruptedException  
	{		
					String url="jdbc:mysql://localhost:3306/myDairy";
					String un="srikanth_muniganti";
					String ps="Sri7977kanth@";
					r.jLabel6.setText("");
					String msg="";
					Email r2=new Email()
					{		
						public String sendEmail(Register r) {
							r.jLabel5.setForeground(new java.awt.Color(51, 255, 51));
							Random random = new Random();
			                int a=random.nextInt(9999);
			                String pin1=String.valueOf(a);
			                String msg2=SendEmail.sendEmail(username,pin1,r); // sending email  			                
			                r.setVisible(true);
			                new DialogBox(pin1, r);
			                return msg2;
						}
			        };
			        msg=r2.sendEmail(r);
					GmailValidation r1=new GmailValidation() 
					{		
						public void aftervalidation(Register r, String msg) {
						try {
							if(msg.equalsIgnoreCase("sent successfully")) {
							r.jLabel5.setText("Gmail validated sucessfully please login to continue...");		
							Class.forName("com.mysql.cj.jdbc.Driver");
							System.err.println("establishing connection......validation");
							Connection cn=DriverManager.getConnection(url,un,ps);
							System.err.println("Connection Established or not ... ---> " +cn);
							PreparedStatement ps11=cn.prepareStatement("select * from registrations where user_name=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							ps11.setString(1,username);
							ResultSet rs=ps11.executeQuery();
					
							if(rs.next())								
							{								
								throw new SQLException();							
							}
							else
								{																
									String sql="insert into myDairy.registrations(user_name,password) values(\""+username+"\",\""+password+"\");";
									PreparedStatement ps1=cn.prepareStatement(sql);
									ps1.executeUpdate();
									ps1.close();
									cn.close();
									r.n=0;
									r.jButton3.setEnabled(true);
								}
							}
										
						} 
						catch (ClassNotFoundException e) {}
						catch (SQLException e) {
							r.jLabel5.setText("");
							r.jLabel6.setText("username already exists!");
							r.n=1;
						}				
				}
					};
					
		r1.aftervalidation(r,msg);   
		if(r.n==0) {
			
			return true;
		}
		else
			return false;
		
	}

}


