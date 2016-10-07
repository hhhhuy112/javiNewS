package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	public Connection connectDB(){
		Connection cnn=null;
		
		try {
			//nạp driver
			Class.forName("com.mysql.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhansu?useUnicode=true&characterEncoding=UTF-8", "root", "");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnn;
	}
}
