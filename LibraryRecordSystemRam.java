package p1;

import java.sql.*;
import java.util.Date.*;
public class LibraryRecordSystemRam {

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
			Connection con=DriverManager.getConnection("jdbc:odbc:std");   //Choose as per convience!!
			Statement st=con.createStatement();
			String sql="create Table logininfo([LOGINID] String(20)   PRIMARY KEY ,[PASSWORD]  String(20))";
			String sql1="create Table studentinfo(STUDENTID int  PRIMARY KEY,STUDENTNAME String(20),PHONENO int ,ADDRESS String(50),EMAIL String(30))"; 
			String sql2="create Table bookinfo(BOOKID int NOT NULL  PRIMARY KEY ,BOOKNAME String(30),BOOKAUTHOR String(30),PUBLISIONS String(30))";
			String sql3="create Table transactioninfo(STUDENTID int ,STUDENTNAME String(20),BOOKID int ,BOOKNAME String(30),STARTDATE String(20) ,ENDDATE String(20))";
			st.execute(sql);
			st.execute(sql1);
			st.execute(sql2);
			st.execute(sql3);
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
