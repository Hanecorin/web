/*
CREATE TABLE probono_project (
	   probono_project_id     		NUMBER(5) PRIMARY KEY,
	   probono_project_name 		VARCHAR2(50) NOT NULL,
       probono_id           			VARCHAR2(50) NOT NULL,       
       activist_id          				VARCHAR2(20) NOT NULL,
       receive_id           				VARCHAR2(20) NOT NULL, 
       project_content      			VARCHAR2(100) NOT NULL
);   */
package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import probono.model.dto.ProbonoProjectDTO;
import probono.model.util.DBUtil;

public class ProbonoProjectDAO {
	 
	//프로보노 프로젝트 저장
	public static boolean addProbonoProject(ProbonoProjectDTO probonoProject) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into probono_project values(probono_project_id_seq.nextval, ? ?, ?, ?, ?)");
			pstmt.setString(1, probonoProject.getProbonoProjectName());
			pstmt.setString(2, probonoProject.getProbonoId());
			pstmt.setString(3, probonoProject.getActivistId());
			pstmt.setString(4, probonoProject.getReceiveId());
			pstmt.setString(5, probonoProject.getProjectContent());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//수정
	// 프로보노 프로젝트 ID로  재능기부자 수정
	public static boolean updateProbonoProjectActivist(int projectId, String activistId) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update probono_project set activist_id=? where probono_project_id=?");
			pstmt.setString(1, activistId);
			pstmt.setInt(2, projectId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//수정
	//프로보노 프로젝트 id로 수해자 정보 변경
	public static boolean updateProbonoProjectReceive(int probonoProjectId, String  receiveId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update probono_project set receive_id=? where probono_project_id=?");
			pstmt.setString(1, receiveId);
			pstmt.setInt(2, probonoProjectId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	//삭제 
	//프로보노 프로젝트 id로 프로보노 프로젝트 삭제
	public static boolean deleteProbonoProject(int probonoProjectId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from probono_project where probono_project_id=?");
			pstmt.setInt(1, probonoProjectId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//프로보노 프로젝트 id로 해당 프로보노프로젝트 검색
	public static ProbonoProjectDTO getProbonoProject(int probonoProjectId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProbonoProjectDTO probonoUser = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from probono_project where probono_project_id=?");
			pstmt.setInt(1, probonoProjectId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				probonoUser = new ProbonoProjectDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return probonoUser;
	}
	
	//모든 프로보노 프로젝트 검색 
	public static ArrayList<ProbonoProjectDTO> getAllProbonoProjects() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProbonoProjectDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from probono_project");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ProbonoProjectDTO>();
			while(rset.next()){
				list.add( new ProbonoProjectDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
