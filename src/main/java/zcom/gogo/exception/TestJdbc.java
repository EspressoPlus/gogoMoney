package zcom.gogo.exception;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		<property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
//		<property name="user" value="gogo"></property>
//		<property name="password" value="gogo"></property>
//		<property name="jdbcUrl"
//			value="jdbc:mysql://localhost:3306/gogomoney03-02?
//					useSSL=false&amp;serverTimezone=UTC&amp;zeroDateTimeBehavior=convertToNull">
		
		
		//String jdbcUrl = "jdbc:mysql://localhost:3306/gogomoney03-02?useSSL=false";
		String jdbcUrl = "jdbc:mysql://localhost:3306/gogomoney03-02?"
				+ "useSSL=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull";
		String user = "gogo";
		String pass = "gogo";
		//String pass = "hbstudentzzz"; // test with bad password
		
		System.out.printf("Trying to connect to %s ...\n...\n\n", jdbcUrl.toString() );
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			//Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successfull!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
//		String jdbcUrl = "jdbc:mysql://localhost:3306/gogomoney03-02?useSSL=false";
//		String user = "root";
//		String pass="Simba8Appa";
//		try {
//			System.out.println("Connecting to database: "+jdbcUrl);
//			
//			Connection myConn =
//					DriverManager.getConnection(jdbcUrl, user, pass);
//			System.out.println("Connection successful");
//		}
//		catch (Exception exc) {
//			exc.printStackTrace();
//		}
		
	}

}
