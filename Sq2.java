package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sq2 {

	public static void main(String[] args) {
		/*try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded");
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}*/
		try{
			Connection con=DriverManager.getConnection("jdbc:odbc:stdd");
			System.out.println("Created Connection");
			Statement ss=con.createStatement();
			//ss.execute("create table employee ( emp_id number,emp_name varchar(20),emp_address varchar(30) )");
			ss.execute("create table admission5(e_id integer ,name1 String,course String,fees double,paidfees double,Primary key (e_id))");
			//System.out.println("query="+sqlll);
			//ss.execute(sqlll);
			System.out.println("table created");
			ss.close();
			con.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
