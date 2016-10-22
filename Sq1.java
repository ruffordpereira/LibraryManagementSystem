package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sq1 {

	public static void main(String[] args) {
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded");
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try{
			Connection con=DriverManager.getConnection("jdbc:odbc:std");
			System.out.println("Created Connection");
			Statement s1=con.createStatement();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
