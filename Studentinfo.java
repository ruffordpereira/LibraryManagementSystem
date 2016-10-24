package p1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Studentinfo extends JFrame implements ActionListener{
	JLabel jl_studentid=new JLabel("Student Id");
	JLabel jl_studentname=new JLabel("Name");
	JLabel jl_studentphone=new JLabel("Phone no");
	JLabel jl_studentaddon=new JLabel("Add on");		//need some claritiy here?
	JLabel jl_studentemail=new JLabel("Email id");
	
	JTextField jtf_studentid=new JTextField(15);
	JTextField jtf_studentname=new JTextField(15);
	JTextField jtf_studentphone=new JTextField(15);
	JTextField jtf_studentaddon=new JTextField(15);
	JTextField jtf_studentemail=new JTextField(15);
	
	JButton jb_new=new JButton("New");
	JButton jb_save=new JButton("Save");
	JButton jb_exit=new JButton("Exit");
	
	JPanel jp_details,jp_button,jp_main;
	
	Studentinfo()
	{
		setTitle("Student info");
		
		jp_details=new JPanel(new GridLayout(5,2,5,5));
		jp_button=new JPanel(new GridLayout(1,3,5,5));
		jp_main=new JPanel(new BorderLayout());
		
		
		//add item to jp_detrails
		
		jp_details.add(jl_studentid);
		jp_details.add(jtf_studentid);
		
		jp_details.add(jl_studentname);
		jp_details.add(jtf_studentname);
		
		jp_details.add(jl_studentphone);
		jp_details.add(jtf_studentphone);
		
		jp_details.add(jl_studentaddon);
		jp_details.add(jtf_studentaddon);
		
		jp_details.add(jl_studentemail);
		jp_details.add(jtf_studentemail);
		
		
		//add button to jp button
		jp_button.add(jb_new);
		jp_button.add(jb_save);
		jp_button.add(jb_exit);
		
		jb_new.addActionListener(this);
		jb_save.addActionListener(this);
		jb_exit.addActionListener(this);
		
		
		
		
		
		//add them to jp main
		
		jp_main.add(jp_details,BorderLayout.NORTH);
		jp_main.add(jp_button,BorderLayout.SOUTH);
		add(jp_main);
		
		
		
		setSize(300,200);
		setLocation(500,280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		show();	
	}
	 
	public static void main(String[] args) {
		new Studentinfo();
		
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String strAction=arg0.getActionCommand();
		
		if(strAction.equalsIgnoreCase("Exit"))
		{
			int read_jop_lrs=JOptionPane.showConfirmDialog(null,"Do you really want to exit","Exit confirmation",JOptionPane.YES_NO_OPTION);
			
			if(read_jop_lrs==JOptionPane.YES_OPTION);
			{
				dispose();
				
			}
		}
		

		if(strAction.equalsIgnoreCase("New"))
		{
			 jtf_studentid.setText(""); 
			 jtf_studentname.setText(""); 
			 jtf_studentphone.setText(""); 
			 jtf_studentaddon.setText(""); 
			 jtf_studentemail.setText(""); 
			
		}
			
			
			
				
		if(strAction.equalsIgnoreCase("Save"))
		{
			 int read_jop = JOptionPane.showConfirmDialog(null,"Do you really want to save this to db?","Save confirmation",JOptionPane.YES_NO_OPTION);
			
			 if(read_jop==JOptionPane.YES_OPTION);
			 {
				read_studentinfo_tf();
				dispose();
			 }
		
		}	
		
		// TODO Auto-generated method stub
		
	}
	
	public void read_studentinfo_tf()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.out.println("Driver is loaded");
			
		}catch(ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:std");   //Choose as per convience!!
			Statement st=con.createStatement();
			String sql="Insert into studentinfo(STUDENTID,STUDENTNAME,PHONENO,ADDRESS,EMAIL) values("+jtf_studentid.getText()+",'"+jtf_studentname.getText()+"',"+jtf_studentphone.getText()+",'"+jtf_studentaddon.getText()+"','"+jtf_studentemail.getText()+"')";
			st.executeUpdate(sql);
			dispose();
		}	catch(SQLException e)
		{
			e.printStackTrace();
		}

	
		// TODO Auto-generated method stub
		
	

	}
}