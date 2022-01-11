package KYUTES;


import java.sql.Connection;
import java.sql.DriverManager;

public class UseDatabase {

	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/useraccount"; //需更改成自己的本地端資料庫連結
			String username = "";//MySQL本地端user name
			String password = "";//MySQL本地端password
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/*public static void main(String[] args) throws Exception {
		getConnection();
	}*/

}
