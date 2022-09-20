package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import probono.model.dto.RecipientDTO;
import probono.model.util.DBUtil;

public class RecipientDAO {
	
	public static boolean addRecipient(RecipientDTO recipient) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into recipient values(?, ?, ?, ?)");
			pstmt.setString(1, recipient.getId());
			pstmt.setString(2, recipient.getName());
			pstmt.setString(3, recipient.getPassword());
			pstmt.setString(4, recipient.getReceiveContent());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//수정 로직
	// 프로젝트 명으로 내용 수정하기
	public static boolean updateRecipient(String recipientId, String receiveHopeContent) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update recipient set receiveHopeContent=? where recipient_id=?");
			pstmt.setString(1, receiveHopeContent);
			pstmt.setString(2, recipientId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}


	//삭제 로직
	public static boolean deleteRecipient(String recipientId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from recipient where recipient_id=?");
			pstmt.setString(1, recipientId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static RecipientDTO getRecipient(String recipientId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RecipientDTO recipient = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from recipient where recipient_id=?");
			pstmt.setString(1, recipientId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				recipient = new RecipientDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return recipient;
	}

	public static ArrayList<RecipientDTO> getAllRecipients() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RecipientDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from recipient");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<RecipientDTO>();
			while(rset.next()){
				list.add(new RecipientDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
