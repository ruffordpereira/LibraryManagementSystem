import java.sql.*;
import java.util.Scanner;

public class Libary {

	public static void main(String[] args) {
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver is loaded");
		
	}catch(ClassNotFoundException e )
	{
		e.printStackTrace();
	}
	try
	{
		Connection con=DriverManager.getConnection("jdbc:odbc:lib");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("LOGIN ID:");
		int i=sc.nextInt();
		System.out.println("PASSWORD:");
		String p=sc.next();
		String sql="insert into logininfo values("+i+",'"+p+"')";
		System.out.print("STUDENT  ID:");
		int si=sc.nextInt();
		System.out.println("STUDENT NAME:");
		String sn=sc.next();
		System.out.println("PHONE NUMBER:");
		String  ph=sc.next();
		System.out.println("EMAIL:");
		String e=sc.next();
		e.endsWith("@gmail.com");
		System.out.println("ADDRESS:");
		String a=sc.next();
		String sql1="insert into studentinfo values("+si+",'"+sn+"',"+ph+"','"+e+"','"+a+"')";
		System.out.println("BOOK ID:");
		int bi=sc.nextInt();
		System.out.println("BOOK NAME:");
		String bn=sc.next();
		System.out.println("BOOK AUTHOR NAME:");
	    String ba=sc.next();
	    System.out.println("PUBLISIONS:");
	    String bp=sc.next();
	    String sql2="insert into bookinfo values("+bi+",'"+bn+"','"+ba+"','"+bp+"')";
	    String sql3="insert into transcationinfo values("+si+",'"+sn+"',"+bi+",'"+bn+"',)";
	    st.executeUpdate(sql);
	    st.executeUpdate(sql1);
	    st.executeUpdate(sql2);
	    st.executeUpdate(sql3);
	    System.out.println("VALUES ARE UBDATED");
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
		// TODO Auto-generated method stub

	}

}
