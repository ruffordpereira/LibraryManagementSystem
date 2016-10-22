package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class LoginInfo  extends JFrame implements ActionListener{
	 JLabel l1,l2;
	 JTextField t1,t2;
	 JButton b1,b2,b3;
	 JPanel p1,p2,p3;
	 LoginInfo()
	 {
		 try
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 
		 }catch(ClassNotFoundException e)
		 {
			 e.printStackTrace();
		 }
	 l1=new JLabel("LOGIN ID");
	 l2=new JLabel("PASSWORD");
	 t1=new JTextField(10);
	 t2=new JTextField(10);
	 b1=new JButton("LOGIN");
	 b2=new JButton("CREATE");
	 b3=new JButton("CANCLE");
	 p1=new JPanel(new GridLayout(2,2,5,5));
	 p1.add(l1);
	 p1.add(t1);
	 p1.add(l2);
	 p1.add(t2);
	 p2=new JPanel(new GridLayout(1,3));
	 p2.add(b1);
	 p2.add(b2);
	 p2.add(b3);
	 p3=new JPanel(new BorderLayout());
	 p3.add(p1,BorderLayout.BEFORE_FIRST_LINE);
	 p3.add(p2,BorderLayout.AFTER_LAST_LINE);
	 add(p3);
	 show();
	 setTitle("LoginInfo");
	 setSize(300,200);
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 public void actionPerformed(ActionEvent ae)
	 {
		 if(ae.getSource()==b1)
		 {
			 try
			 {
				 Connection con=DriverManager.getConnection("jdcb:odbc:lib");
				 Statement st=con.createStatement();
				 String sql="insert into logininfo values('"+t1.getText()+"','"+t2.getText()+"')";
				 st.executeUpdate(sql);
				 System.out.println("LOGIN");
				 t1.setText("");
				 t2.setText("");
				
				 
			 
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 }else if(ae.getSource()==b2)
		 {
			 
		 }
		 else if(ae.getSource()==b3)
		 {
			 System.exit(0);
		 }
	 }
	 
	 public static void main(String[] args) {
		 new  LoginInfo();
		// TODO Auto-generated method stub

	}

}
