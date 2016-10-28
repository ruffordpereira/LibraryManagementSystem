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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateUser extends JFrame implements ActionListener {
	
	JButton jb_ok=new JButton("Ok");
	JButton jb_cancel=new JButton("Cancel");
	JLabel jl_enteruserid=new JLabel("Enter userid");
	JLabel jl_enterpassword=new JLabel("Enter Password");
	JLabel jl_enterpassword_again=new JLabel("Enter Password Again");
	
	JPanel jp_details = new JPanel();
	JPanel jp_button = new JPanel();
	JPanel jp_main = new JPanel();
	
	JTextField  jtf_userid = new JTextField(15);
	JPasswordField jpf_password = new JPasswordField(15);
	JPasswordField jpf_password_again = new JPasswordField(15);
	
	CreateUser()
	{
		setTitle("Create a New User");
		
		
		jp_details=new JPanel(new GridLayout(3,2,5,5));			//seting panel constrains
		jp_button=new JPanel(new GridLayout(1,2,5,5));
		jp_main=new JPanel(new BorderLayout());
		
		jp_details.add(jl_enteruserid);
		jp_details.add(jtf_userid);
		
		jp_details.add(jl_enterpassword);
		jp_details.add(jpf_password);
		
		jp_details.add(jl_enterpassword_again);
		jp_details.add(jpf_password_again);
		
		jp_button.add(jb_ok );
		jp_button.add(jb_cancel);
		
		jb_ok.addActionListener(this);
		jb_cancel.addActionListener(this);
		
		setSize(300,200);
		setLocation(500,280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp_main.add(jp_details,BorderLayout.NORTH);
		jp_main.add(jp_button,BorderLayout.SOUTH);
		add(jp_main);
		
		show();
		
	}
	

	public static void main(String[] args) {
		new CreateUser();
		
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String strAction=arg0.getActionCommand();
		
		if(strAction.equalsIgnoreCase("Ok"))
		{
			String get_username = jtf_userid.getText();
			String get_password = jpf_password.getText();
			insertintotable();
			
			
		}
		
		if(strAction.equalsIgnoreCase("Cancel"))
		{
			int read_jop_lrs=JOptionPane.showConfirmDialog(null,"Do you really want to Cancel","Cancel confirmation",JOptionPane.YES_NO_OPTION);
			
			if(read_jop_lrs==JOptionPane.YES_OPTION);
			{
				Libraryrecordsystem lrs=new Libraryrecordsystem();
				lrs.setVisible(true);
				dispose();
				
				
			}
		}
		
	}
	public void insertintotable(){
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
			Connection con=DriverManager.getConnection("jdbc:odbc:std");  //chose as per convience
			Statement st=con.createStatement();
			@SuppressWarnings("deprecation")
			String sql="insert into logininfo(LOGINID,PASSWORD)values('"+jtf_userid.getText()+"',+'"+jpf_password.getText()+"')";
			st.executeUpdate(sql);
			dispose();
			
			LoginInfo li=new LoginInfo();
			li.setVisible(true);
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
}
