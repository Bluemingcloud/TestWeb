package com.testweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.testweb.util.JdbcUtil;

public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	private DataSource ds;
	
	private UserDAO() {
		try {
			InitialContext init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("커넥션 풀 에러");
		}
		
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	////////////////////////////////////////////////////////////////////
	public boolean isIdExists(String id) {
		
		String sql = "SELECT * FROM USERS WHERE ID = ?";
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			result = rs.next();
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
		
	}
	
	public void joinUser(UserDTO dto) {
		
		String sql = "INSERT INTO USERS(ID, PW, NAME, EMAIL, GENDER) VALUES(?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getGender());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	public boolean loginUser(String id, String pw) {
		
		String sql = "SELECT * FROM USERS WHERE ID = ? AND PW = ?";
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			result = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	

}
