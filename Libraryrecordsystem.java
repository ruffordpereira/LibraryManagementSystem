package p1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Libraryrecordsystem extends JFrame implements ActionListener {
	JButton jb_studentinfo,jb_bookinfo,jb_transactioninfo,jb_exit;
	JPanel libraryrecordsystem;
	
	Libraryrecordsystem()
	{
		
		setTitle("Library Record System");
		
		jb_studentinfo=new JButton("Student Information");
		jb_bookinfo=new JButton("Book Information");
		jb_transactioninfo=new JButton("Transaction info");
		jb_exit=new JButton("Exit");
		
		libraryrecordsystem=new JPanel(new GridLayout(1,4,5,5));
		
		libraryrecordsystem.add(jb_studentinfo);
		libraryrecordsystem.add(jb_bookinfo);
		libraryrecordsystem.add(jb_transactioninfo);
		libraryrecordsystem.add(jb_exit);
		
		add(libraryrecordsystem);
		
		jb_studentinfo.addActionListener(this);
		jb_bookinfo.addActionListener(this);
		jb_transactioninfo.addActionListener(this);
		jb_exit.addActionListener(this);
		
		
		
		setSize(600,200);
		setLocation(500,280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		show();
		
		
	}
	

	public static void main(String[] args) {
		new Libraryrecordsystem();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//String strAction=arg0.getActionCommand();
		
		//if(strAction.equalsIgnoreCase("Student Information"));
		if(ae.getSource()==jb_studentinfo)
		{
			Studentinfo sti=new Studentinfo();
			sti.setVisible(true);
			dispose();
		}
		
		
		
		if(ae.getSource()==jb_exit)
		{
			int read_jop_lrs=JOptionPane.showConfirmDialog(null,"Do you really want to exit","Exit confirmation",JOptionPane.YES_NO_OPTION);
		
			if(read_jop_lrs==JOptionPane.YES_OPTION);
			{
				dispose();
				
			}
		}
		
			
		
		
	}

}