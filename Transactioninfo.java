package p1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transactioninfo extends JFrame implements ActionListener{
	JButton jb_new,jb_save,jb_search,jb_exit;
	JPanel jp_transactioninfo,jp_button,jp_main;
	JLabel jl_studentid,jl_name,jl_bookid,jl_bookname,jl_startdate,jl_enddate;
	JTextField jtf_studentid,jtf_name,jtf_bookid,jtf_bookname,jtf_startdate,jtf_enddate;
	
	Transactioninfo(){
		setTitle("Transaction information");
		
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
		
		jtf_studentid=new JTextField(15);
		jtf_name=new JTextField(15);
		jtf_bookid=new JTextField(15);
		jtf_bookname=new JTextField(15);
		jtf_startdate=new JTextField(15);
		jtf_enddate=new JTextField(15);
		
		jp_transactioninfo=new JPanel(new GridLayout(6,2,5,5));
		jp_button=new JPanel(new GridLayout(1,4,5,5));
		jp_main=new JPanel(new BorderLayout());
		
		jp_transactioninfo.add(jl_studentid);
		jp_transactioninfo.add(jtf_studentid);
		
		
		jp_transactioninfo.add(jl_name);
		jp_transactioninfo.add(jtf_name);
		
		
		jp_transactioninfo.add(jl_bookid);
		jp_transactioninfo.add(jtf_bookid);
		
		
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
		
		
		
		
		
		setSize(400,250);
		setLocation(500,280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		show();
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		new Transactioninfo();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String strAction=arg0.getActionCommand();
		
		if(strAction.equalsIgnoreCase("New"))
		{
			jtf_studentid.setText("");
			jtf_name.setText("");
			jtf_bookid.setText("");
			jtf_bookname.setText("");
			jtf_startdate.setText("");
			jtf_enddate.setText("");
		}
		
		if(strAction.equalsIgnoreCase("Exit"))
		{
			int read_jop_lrs=JOptionPane.showConfirmDialog(null,"Do you really want to exit","Exit confirmation",JOptionPane.YES_NO_OPTION);
			
			if(read_jop_lrs==JOptionPane.YES_OPTION);
			{
				dispose();
				
			}
		}

		// TODO Auto-generated method stub
		
	}

}
