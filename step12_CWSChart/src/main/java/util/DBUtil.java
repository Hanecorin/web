package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	static Properties prop = new Properties();

	static {
		try {
			prop.load(new FileInputStream("/Users/han-yechan/Desktop/99.encore/09.web/step12_CWSChart/db.properties"));
			Class.forName(prop.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("id"), prop.getProperty("pw"));
	}

	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public static void close(Connection con, PreparedStatement pstmt, PreparedStatement pstmt2) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (pstmt2 != null) {
				pstmt2.close();
				pstmt2 = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public static void close(Connection con, PreparedStatement pstmt, PreparedStatement pstmt2, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (pstmt2 != null) {
				pstmt2.close();
				pstmt2 = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}