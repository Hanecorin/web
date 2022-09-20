package book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dto.BookDTO;

import book.model.util.DBUtil;

public class BookDAO {
	// 책 정보 등록(insert)
		public static boolean addBook(BookDTO book) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into book values(?, ?, ?, ?, ?)");
				pstmt.setString(1, book.getBookNo());
				pstmt.setString(2, book.getBookName());
				pstmt.setString(3, book.getWriter());
				pstmt.setString(4, book.getPublisher());
				pstmt.setString(5, book.getInventory());

				int result = pstmt.executeUpdate();

				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 수정
		//book id로 책 재고 수정하기
		public static boolean updateBook(String bookNo,String inventory) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("update book set inventory=? where book_no=?");
				pstmt.setString(1,	inventory);
				pstmt.setString(2, bookNo);

				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 책 번호로 삭제
		// sql - delete from book where book_no=?
		public static boolean deleteBook(String bookNo) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from book where book_no=?");

				pstmt.setString(1, bookNo);

				int result = pstmt.executeUpdate();

				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 책번호로 해당 책의 모든 정보 반환
		public static BookDTO getBook(String bookNo) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			BookDTO book = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from book where book_no=?");
				pstmt.setString(1, bookNo);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					// @Builder(builderMethodName = "BookDTOBuilder")
					book = new BookDTO(rset.getString("book_no"), rset.getString("book_name"), rset.getString("writer"), rset.getString("publisher"), rset.getString("inventory"));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return book;
		}

		
		// sql - select * from book
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
				while(rset.next()) {
					// @Builder(builderMethodName = "BookDTOBuilder")
					all.add(new BookDTO(rset.getString("book_no"), rset.getString("book_name"), rset.getString("writer"), rset.getString("publisher"), rset.getString("inventory")));		
					} 
			}finally {
				DBUtil.close(con, pstmt, rset);
			}
			return all;
		}
		
//		@Test
	//	
//		public void m() throws SQLException {
//			addBook(new BookDTO(9,"asdfsf","adsasd","asasd",3));
//		}
	}

