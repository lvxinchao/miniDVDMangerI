package dvd.manager.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {
	Connection conn=null;
	public Connection getConnect() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
        String url="jdbc:mysql://localhost:3306/minidvd?serverTimezone=UTC&useSSL=false";
        conn=DriverManager.getConnection(url,"root","0320");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
