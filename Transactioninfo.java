package p1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		jl_studentid.add(jp_transactioninfo);
		jtf_studentid.add(jp_transactioninfo);
		
		jl_name.add(jp_transactioninfo);
		jtf_name.add(jp_transactioninfo);
		
		jl_bookid.add(jp_transactioninfo);
		jtf_bookid.add(jp_transactioninfo);
		
		jl_bookname.add(jp_transactioninfo);
		jtf_bookname.add(jp_transactioninfo);
		
		jl_startdate.add(jp_transactioninfo);
		jtf_startdate.add(jp_transactioninfo);
		
		jl_enddate.add(jp_transactioninfo);
		jtf_enddate.add(jp_transactioninfo);
		
		jb_new.add(jp_button);
		jb_save.add(jp_button);
		
		
		
		
		
		jp_transactioninfo=new JPanel(new GridLayout(6,2,5,5));
		jp_button=new JPanel(new GridLayout(1,4,5,5));
		jp_main=new JPanel(new BorderLayout());
		
		jp_main.add(jp_transactioninfo,BorderLayout.NORTH);
		jp_main.add(jp_button,BorderLayout.SOUTH);
		add(jp_main);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
