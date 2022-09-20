package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.BookDTO;
import util.DBUtil;

public class BookDAO {

	// 새로운 책정보 입력(insert)
	public static boolean addBook(BookDTO book) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into book values(?,?,?,?,?)");
			pstmt.setInt(1, book.getBookNo());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getWriter());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getInventory());

			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// bookNo로 해당 책 정보 반환(Read)
	public static BookDTO getBook(int bookNo) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		BookDTO book = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from book where bookno=?");
			pstmt.setInt(1, bookNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {// String id, String name, String password, String major
				book = new BookDTO(rset.getInt("bookno"), rset.getString("bookname"), rset.getString("writer"),
						rset.getString("publisher"), rset.getInt("inventory"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return book;
	}

	// 모든 책정보 검색 반환 (Read)
	public static ArrayList<BookDTO> getAllBooks() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> all = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book");
			rset = pstmt.executeQuery();
			all = new ArrayList<BookDTO>();

			while (rset.next()) {
				all.add(BookDTO.BookDTOBuilder().bookNo(rset.getInt(1)).bookName(rset.getString(2))
						.writer(rset.getString(3)).publisher(rset.getString(4)).inventory(rset.getInt(5)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}

	// 책번호로 재고 수정하기(Update)
	public static boolean updateInventory(int bookno, int inventory) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update book set inventory=? where bookno=?");
			pstmt.setInt(1, inventory);
			pstmt.setInt(2, bookno);

			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 책번호로 해당 책정보 지우기(Delete)
	public static boolean deleteBook(int bookNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from book where bookno=?");
			pstmt.setInt(1, bookNo);

			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

}
