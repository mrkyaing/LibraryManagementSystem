package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilitity {
  static  String url="jdbc:mysql://localhost:3306/libmgtdb";
   static String user="root";
   static String password="root@123"; 
  
	public static Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
