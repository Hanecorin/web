package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.CustomerDTO;
import util.DBUtil;

public class CustomerDAO {
	// 새로운 고객정보 입력(insert)
		public static boolean addCustomer(CustomerDTO customer) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into customer values(?,?,?)");
				pstmt.setInt(1, customer.getCustomerId());
				pstmt.setString(2, customer.getCustomerName());
				pstmt.setString(3, customer.getPhoneNumber());

				int result = pstmt.executeUpdate();
				if (result != 0) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// customerId로 해당 고객 정보 반환(Read)
		public static CustomerDTO getCustomer(int customerId) throws SQLException {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			CustomerDTO customer = null;

			try {
				conn = DBUtil.getConnection();
				pstmt = conn.prepareStatement("select * from customer where customerid=?");
				pstmt.setInt(1, customerId);
				rset = pstmt.executeQuery();

				if (rset.next()) {
					customer = new CustomerDTO(rset.getInt("customerid"), rset.getString("customername"), rset.getString("phonenumber"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				DBUtil.close(conn, pstmt, rset);
			}
			return customer;
		}

		// 모든 고객정보 검색 반환 (Read)
		public static ArrayList<CustomerDTO> getAllCustomers() throws SQLException {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<CustomerDTO> all = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from customer");
				rset = pstmt.executeQuery();
				all = new ArrayList<CustomerDTO>();

				while (rset.next()) {
					all.add(CustomerDTO.CustomerDTOBuilder().customerId(rset.getInt(1)).customerName(rset.getString(2))
							.phoneNumber(rset.getString(3)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return all;
		}

		// 고객아이디로 연락처 수정하기(Update)
		public static boolean updateCustomerPhoneNumber(int customerId, String phoneNumber) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("update customer set phonenumber=? where customerid=?");
				pstmt.setInt(2, customerId);
				pstmt.setString(1, phoneNumber);

				int result = pstmt.executeUpdate();
				if (result != 0) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 고객아이디로 해당 고객정보 지우기(Delete)
		public static boolean deleteCustomer(int customerId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from customer where customerid=?");
				pstmt.setInt(1, customerId);

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
