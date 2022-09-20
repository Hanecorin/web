package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.RentDTO;
import util.DBUtil;

public class RentDAO {

	public static boolean addRent(RentDTO rent) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into rent values(?,?,?,?,?,?)");
			pstmt2 = con.prepareStatement("update book set inventory=inventory-1 where bookno=?");
			pstmt.setInt(1, rent.getRentNo());
			pstmt.setString(2, rent.getRentDate());
			pstmt.setInt(3, rent.getBookNo());
			pstmt2.setInt(1, rent.getBookNo());
			pstmt.setString(4, rent.getBookName());
			pstmt.setInt(5, rent.getCustomerId());
			pstmt.setString(6, rent.getCustomerName());
			
			int result1 = pstmt.executeUpdate();
			int result2 = pstmt2.executeUpdate();
			if (result1 != 0 && result2 != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt, pstmt2);
		}
		return false;
	}

	public static RentDTO getRent(int rentNo) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		RentDTO rent = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from rent where rentno=?");
			pstmt.setInt(1, rentNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				rent = new RentDTO(rset.getInt("rentno"), rset.getString("rentdate"), rset.getInt("bookno"), rset.getString("bookname"), rset.getInt("customerid"), rset.getString("customername"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return rent;
	}
	
	public static ArrayList<RentDTO> getAllRents() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> all = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from rent");
			rset = pstmt.executeQuery();
			all = new ArrayList<RentDTO>();

			while (rset.next()) {
				all.add(RentDTO.RentDTOBuilder().rentNo(rset.getInt(1)).rentDate(rset.getString(2)).bookNo(rset.getInt(3)).bookName(rset.getString(4)).customerId(rset.getInt(5)).customerName(rset.getString(6)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}
	
	public static ArrayList<RentDTO> getBookNames(String bookName) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> all = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from rent where bookname=?");
			pstmt.setString(1, bookName);
			rset = pstmt.executeQuery();
			all = new ArrayList<RentDTO>();

			while (rset.next()) {
				all.add(RentDTO.RentDTOBuilder().rentNo(rset.getInt(1)).rentDate(rset.getString(2)).bookNo(rset.getInt(3)).bookName(rset.getString(4)).customerId(rset.getInt(5)).customerName(rset.getString(6)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}
	
	public static boolean checkRent(int bookNo) throws SQLException {
		
		if(BookDAO.getBook(bookNo).getInventory()>=1) {
			return true;
		}
		
		return false;		
	}
	
	// 대여번호로 해당 대여정보 지우기(Delete)
			public static boolean deleteRent(int rentNo) throws SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
				PreparedStatement pstmt2 = null;
				int num=getRent(rentNo).getBookNo();
				
				try {
					con = DBUtil.getConnection();
					pstmt = con.prepareStatement("delete from rent where rentno=?");
					pstmt.setInt(1, rentNo);
					pstmt2 = con.prepareStatement("update book set inventory = inventory+1 where bookno=?");
					pstmt2.setInt(1, num);
					
					
					int result1 = pstmt.executeUpdate();
					int result2 = pstmt2.executeUpdate();
					if (result1 != 0 && result2 != 0) {
						return true;
					}
				} finally {
					DBUtil.close(con, pstmt, pstmt2);
				}
				return false;
			}

}
