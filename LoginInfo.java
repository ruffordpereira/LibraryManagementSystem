package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class LoginInfo  extends JFrame implements ActionListener{
	 JLabel jl_logid,jl_password;
	 JTextField jtf_logid,jtf_password;
	 JButton jb_createuser,jb_login,jb_cancel;
	 JPanel jp_details,jp_button,jp_main;
	 LoginInfo()
	 {
		 try
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 
		 }catch(ClassNotFoundException e)
		 {
			 e.printStackTrace();
		 }
	 jl_logid=new JLabel("LOGIN ID");
	 jl_password=new JLabel("PASSWORD");
	 
	 jtf_logid=new JTextField(10);
	 jtf_password=new JTextField(10);
	 
	 jb_createuser=new JButton("LOGIN");
	 jb_login=new JButton("CREATE");
	 jb_cancel=new JButton("CANCLE");
	 
	 jp_details=new JPanel(new GridLayout(2,2,5,5));
	 
	 jp_details.add(jl_logid);
	 jp_details.add(jtf_logid);
	 jp_details.add(jl_password);
	 jp_details.add(jtf_password);
	 
	 jp_button=new JPanel(new GridLayout(1,3));
	 
	 jp_button.add(jb_createuser);
	 jp_button.add(jb_login);
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
			 try
			 {
				 Connection con=DriverManager.getConnection("jdcb:odbc:std");  //change per convience
				 Statement st=con.createStatement();
				 String sql="insert into logininfo values('"+jtf_logid.getText()+"','"+jtf_password.getText()+"')";
				 st.executeUpdate(sql);
				 System.out.println("LOGIN");
				 jtf_logid.setText("");
				 jtf_password.setText("");
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 }else if(ae.getSource()==jb_login)
		 {
			 
		 }
		 else if(ae.getSource()==jb_cancel)
		 {
			 System.exit(0);
		 }
	 }
	 
	 public static void main(String[] args) {
		 new  LoginInfo();
		// TODO Auto-generated method stub

	}

}
