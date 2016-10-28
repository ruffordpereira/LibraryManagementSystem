package p1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Transactioninfo extends JFrame implements ActionListener,ItemListener{
	JButton jb_new,jb_save,jb_search,jb_exit;
	JPanel jp_transactioninfo,jp_button,jp_main;
	JLabel jl_studentid,jl_name,jl_bookid,jl_bookname,jl_startdate,jl_enddate;
	JTextField jtf_name,jtf_bookname;
	static JTextField jtf_startdate;
	static JTextField jtf_enddate;
	public JComboBox jlt_studentid,jlt_bookid,jlt_studentname,jlt_bookname;
	public static Vector<Integer> stid=new Vector<Integer>();
	public static  Vector<String> stname=new Vector<String>();
	public static Vector<Integer> bookid=new Vector<Integer>();
	public static  Vector<String> bookname=new Vector<String>();
	
	



	
	Transactioninfo(){
		
		setTitle("Transaction information");
		
		jlt_studentid=new JComboBox(stid.toArray());
		

		jtf_name=new JTextField(15);

		
		jlt_bookid=new JComboBox(bookid.toArray());
		
		jtf_bookname=new JTextField(15);
		
		
		
		
		jb_new=new JButton("New");
		jb_save=new JButton("Save");
		jb_search=new JButton("Search");
		jb_exit=new JButton("Exit");
		
		jb_new.addActionListener(this);
		jb_save.addActionListener(this);
		jb_search.addActionListener(this);
		jb_exit.addActionListener(this);
		
		
		jl_studentid=new JLabel("Student Id");
		jl_name=new JLabel("Student name");
		jl_bookid=new JLabel("Book Id");
		jl_bookname=new JLabel("Book Name");
		jl_startdate=new JLabel("Start Date");
		jl_enddate=new JLabel("End date");
		
		
		jtf_name=new JTextField(15);
		
		jtf_bookname=new JTextField(15);
		jtf_startdate=new JTextField(15);
		jtf_enddate=new JTextField(15);
		
		jp_transactioninfo=new JPanel(new GridLayout(6,2,5,5));
		jp_button=new JPanel(new GridLayout(1,4,5,5));
		jp_main=new JPanel(new BorderLayout());
		
		jp_transactioninfo.add(jl_studentid);
		
		
					//make student id appear as jlist with scrool bar
		
		
		jp_transactioninfo.add(jlt_studentid);
		
		
		
		jp_transactioninfo.add(jl_name);
		jp_transactioninfo.add(jtf_name);

		
		
		
		
		
		jp_transactioninfo.add(jl_bookid);
		
				//make book id appear as jlist with scrool bar
		
		
		jp_transactioninfo.add(jlt_bookid);
		
		
		
		jp_transactioninfo.add(jl_bookname);
		jp_transactioninfo.add(jtf_bookname);
		
		jp_transactioninfo.add(jl_startdate);
		jp_transactioninfo.add(jtf_startdate);
		
		
		jp_transactioninfo.add(jl_enddate);
		jp_transactioninfo.add(jtf_enddate);
		
		
		jp_button.add(jb_new );
		jp_button.add(jb_save);
		jp_button.add(jb_search);
		jp_button.add(jb_exit);
		
		
		
		
		jp_main.add(jp_transactioninfo,BorderLayout.NORTH);
		jp_main.add(jp_button,BorderLayout.SOUTH);
		add(jp_main);
		
		jb_new.addActionListener(this);
		jb_save.addActionListener(this);
		jb_search.addActionListener(this);
		jb_exit.addActionListener(this);
		
		jlt_studentid.addItemListener(this);
		jlt_bookid.addItemListener(this);
		
		
		
		
		setSize(400,350);
		setLocation(500,280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		show();
		
		
		
		
		
		
	}

	public static void main(String[] args) throws ParseException  {
		
		getinformation();
		new Transactioninfo();
		getdate();
		// TODO Auto-generated method stub

	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String strAction=arg0.getActionCommand();
		
		if(strAction.equalsIgnoreCase("New"))
		{
			//jtf_studentid.setText("");
			jtf_name.setText("");
			//jtf_bookid.setText("");
			jtf_bookname.setText("");
			jtf_startdate.setText("");
			jtf_enddate.setText("");
		}
		
		if(strAction.equalsIgnoreCase("Exit"))
		{
			int read_jop_lrs=JOptionPane.showConfirmDialog(null,"Do you really want to exit","Exit confirmation",JOptionPane.YES_NO_OPTION);
			
			if(read_jop_lrs==JOptionPane.YES_OPTION);
			{
				 SecondMenu sm=new SecondMenu();
				 sm.setVisible(true);
				dispose();
				
			}
		}
		if(strAction.equalsIgnoreCase("Save"))
		{
			int read_jopp = JOptionPane.showConfirmDialog(null,"Do you really want to save this to db?","Save confirmation",JOptionPane.YES_NO_OPTION);
			if(read_jopp==JOptionPane.YES_OPTION);
			{
						
			  save();
			}
					
			SecondMenu smmm=new SecondMenu();
			smmm.setVisible(true);	
			dispose();
			
		}
		

		// TODO Auto-generated method stub
		
	}
	public static void getinformation()
	{
		try
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 Connection con=DriverManager.getConnection("jdbc:odbc:std");
			 Statement ss=con.createStatement();
			 Statement sss=con.createStatement();

			 String query = "SELECT * FROM studentinfo";
			 String query1 = "SELECT * FROM bookinfo";


			 ResultSet rs = ss.executeQuery(query);
			 ResultSet rss = sss.executeQuery(query1);
			 
			 while ((rs.next())&&(rss.next()))
			 {
				 stid.add(rs.getInt(1));
				 stname.add(rs.getString(2));
				 bookid.add(rss.getInt(1));
				 bookname.add(rss.getString(2));

				 
				 
			 }
			 JList st_id=new JList(stid);
			 JList st_name=new JList(stname);
			 JList bk_id=new JList(bookid);
			 JList bk_name=new JList(bookname);

		 }catch(Exception e)
		{
			 System.out.println(e.toString());
		}
	}
	public void save()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:std");   //Choose as per convience!!
			Statement sttt=con.createStatement();
			String sql="Insert into transactioninfo(STUDENTID,STUDENTNAME,BOOKID,BOOKNAME,STARTDATE,ENDDATE) values("+jlt_studentid.getSelectedItem()+",'"+jtf_name.getText()+"',"+jlt_bookid.getSelectedItem()+",'"+jtf_bookname.getText()+"','"+jtf_startdate.getText()+"','"+jtf_enddate.getText()+"')";
			sttt.executeUpdate(sql);
		}	catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void getdate() throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		jtf_startdate.setText(dateFormat.format(cal.getTime()));
	
		
		

		String dt = dateFormat.format(cal.getTime());  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		c.add(Calendar.DATE, 15);  // number of days to add
		dt = sdf.format(c.getTime());
		jtf_enddate.setText(dt);
		
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		jtf_name.setText(stname.get(jlt_studentid.getSelectedIndex()));
		jtf_bookname.setText(bookname.get(jlt_bookid.getSelectedIndex()));
		
	
		// TODO Auto-generated method stub
		
	}
}
	


