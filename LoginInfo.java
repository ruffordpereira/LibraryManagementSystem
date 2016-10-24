package p1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class LoginInfo  extends JFrame implements ActionListener{
	 JLabel jl_logid,jl_password;
	 JTextField jtf_logid,jtf_password;
	 JButton jb_createuser,jb_login,jb_cancel;
	 JPanel jp_details,jp_button,jp_main;
	 LoginInfo()
	 {
		
	 jl_logid=new JLabel("LOGIN ID");
	 jl_password=new JLabel("PASSWORD");
	 
	 jtf_logid=new JTextField(10);
	 jtf_password=new JTextField(10);
	 
	 jb_login=new JButton("Login");
	 jb_createuser=new JButton("Create User");
	 jb_cancel=new JButton("Cancel");
	 
	 jp_details=new JPanel(new GridLayout(2,2,5,5));
	 
	 jp_details.add(jl_logid);
	 jp_details.add(jtf_logid);
	 jp_details.add(jl_password);
	 jp_details.add(jtf_password);
	 
	 jp_button=new JPanel(new GridLayout(1,3));
	 
	 jp_button.add(jb_login);
	 jp_button.add(jb_createuser);
	 jp_button.add(jb_cancel);
	 
	 jp_main=new JPanel(new BorderLayout());
	 
	 jp_main.add(jp_details,BorderLayout.NORTH);
	 jp_main.add(jp_button,BorderLayout.AFTER_LAST_LINE);				//needs some fine tuning!
	  add(jp_main);
	 
	 show();
	 
	 setTitle("LoginInfo");
	 setSize(300,200);
	setLocation(500,280);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 jb_createuser.addActionListener(this);
	 jb_login.addActionListener(this);
	 jb_cancel.addActionListener(this);
	 
	 
	 }
	 public void actionPerformed(ActionEvent ae)
	 {
		 if(ae.getSource()==jb_createuser)
		 {
			 CreateUser cu=new CreateUser();
			 cu.setVisible(true);
			 dispose();
			
		 }
		 if(ae.getSource()==jb_login)
		 {
			 try
			 {
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection con=DriverManager.getConnection("jdbc:odbc:std");
				 Statement ss=con.createStatement();
				 String query = "SELECT * FROM logininfo";
				 ResultSet rs = ss.executeQuery(query);
				 while (rs.next())
				 {
					 
					 String id = rs.getString(1);
				     String firstName = rs.getString(2);
				    // System.out.println(id);
				     if(id.equals(jtf_logid.getText()) && firstName.equals(jtf_password.getText()))
				     {
				    	 Studentinfo si=new Studentinfo();
				    	 dispose();
				    	 break;
				    	 
				    	 
				     }
				     else
				     {
				    	 JOptionPane.showMessageDialog(null, "Invalid username/password", "Error", JOptionPane.ERROR_MESSAGE);
				    	 
				     }
				 }
				}
			 	catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 
			 
			 
		 }
		 if(ae.getSource()==jb_cancel)
		 {
			 Libraryrecordsystem lrs=new Libraryrecordsystem();
			 lrs.setVisible(true);
			  System.exit(0);
		 }
	 }
	 
	 public static void main(String[] args) {
		 new  LoginInfo();
		// TODO Auto-generated method stub

	}

}
