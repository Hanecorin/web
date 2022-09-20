package book.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	//properties 파일의 내용을 보유하게되는 객체 생성
	static Properties pros = new Properties();
	
	//driver 로딩
	static {
		try {
			pros.load(new FileInputStream("/Users/han-yechan/Desktop/99.encore/09.web/freemission/src/db.properties"));
			Class.forName(pros.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

	//uri, id, pw등으로 접속하는 객체 반환
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(pros.getProperty("url"), 
										   pros.getProperty("id"), 
										   pros.getProperty("pw"));
	}
	
	//자원반환 : select
	public static void close(Connection conn, Statement stmt, ResultSet rset) {
		try {
			if(rset != null) {
				rset.close();
				rset = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}catch (SQLException e) {  
			e.printStackTrace();
		}
	}
	
	//자원반환 : insert.update.delete
	public static void close(Connection conn, Statement stmt) {
		try {			
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}catch (SQLException e) {  
			e.printStackTrace();
		}
	}
	
}
