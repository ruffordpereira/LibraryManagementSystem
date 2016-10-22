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

public class BookInformation extends JFrame implements ActionListener {
	
	JLabel jl_bookid,jl_bookname,jl_bookauthor,jl_bookpublisher;
	JTextField jtf_bookid,jtf_bookname,jtf_bookauthor,jtf_bookpublisher;
	JButton jb_new,jb_save,jb_exit;
	JPanel jp_details,jp_button,jp_main;
	
	BookInformation()
	{
		setTitle("Book Information ");
		
		jp_details=new JPanel(new GridLayout(4,2,5,5));			//seting panel constrains
		jp_button=new JPanel(new GridLayout(1,3,5,5));
		jp_main=new JPanel(new BorderLayout());
		
		jl_bookid=new JLabel("Book ID");
		jl_bookname=new JLabel("Book Name");
		jl_bookauthor=new JLabel("Book Author");
		jl_bookpublisher=new JLabel("Book Publisher");
		
		jtf_bookid=new JTextField(15);
		jtf_bookname=new JTextField(15);
		jtf_bookauthor=new JTextField(15);
		jtf_bookpublisher=new JTextField(15);
		
		jb_new=new JButton("New");
		jb_save=new JButton("Save");
		jb_exit=new JButton("Exit");
		
		//add label and textfield to panel_details
		
		jp_details.add(jl_bookid);
		jp_details.add(jtf_bookid);
		
		jp_details.add(jl_bookname);
		jp_details.add(jtf_bookname);
		
		jp_details.add(jl_bookauthor);
		jp_details.add(jtf_bookauthor);
		
		jp_details.add(jl_bookpublisher);
		jp_details.add(jtf_bookpublisher);
		
		//add button to panel_button
		
		jp_button.add(jb_new);
		jp_button.add(jb_save);
		jp_button.add(jb_exit);
		

		jb_new.addActionListener(this);
		jb_save.addActionListener(this);
		jb_exit.addActionListener(this);
		
		jp_main.add(jp_details,BorderLayout.NORTH);
		jp_main.add(jp_button,BorderLayout.SOUTH);
		add(jp_main);
		
		setSize(300,200);
		setLocation(500,280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		show();	
		
	}

	public static void main(String[] args) {
		new BookInformation();
		// TODO Auto-generated method stub

	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
