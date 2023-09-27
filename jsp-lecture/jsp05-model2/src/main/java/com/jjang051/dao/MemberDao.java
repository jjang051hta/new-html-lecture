package com.jjang051.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jjang051.common.JDBCConnect;
import com.jjang051.dto.Member;
import com.jjang051.service.MemberService;

public class MemberDao implements MemberService {

	@Override
	public int insertMember(Member member) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,sysdate,?)";
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getEmail());
			pstmt.setString(5,member.getTel());
			pstmt.setInt(6,member.getPostCode());
			pstmt.setString(7,member.getAddress());
			pstmt.setString(8,member.getDetailAddress());
			pstmt.setString(9,member.getProfile());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	@Override
	public Member loginMember(String userID, String userPW) {
		//1 연결
		//2 쿼리
		//3 실행
		//4 결과받기
		Member loggedMember = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select * from  member where id=? and password=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				loggedMember = new Member();
				loggedMember.setId(rs.getString("id"));
				loggedMember.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		return loggedMember;
	}

	@Override
	public Member infoMember(String userID) {
		JDBCConnect jdbcConn = new JDBCConnect();
		Member infoMember = null;
		try {
			String sql = "select * from member where id = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				infoMember = new Member();
				infoMember.setPassword(rs.getString("password"));
				infoMember.setAddress(rs.getString("address"));
				infoMember.setDetailAddress(rs.getString("addressdetail"));
				infoMember.setPostCode(rs.getInt("postcode"));
				infoMember.setRegDate(rs.getString("regDate"));
				infoMember.setProfile(rs.getString("profile"));
				infoMember.setEmail(rs.getString("email"));
				infoMember.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infoMember;
	}

	public int idCheck(String userID) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select count(*) as count from member where id = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result= rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
		
	}

	@Override
	public int deleteMember(String userID, String userPW) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "delete from member where id=? and password = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	public Member modifyPasswordConfirm(String userID, String userPW) {
		Member modifyMember = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select * from member where id = ? and password = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				modifyMember = new Member();
				modifyMember.setAddress(rs.getString("address"));
				modifyMember.setDetailAddress(rs.getString("addressDetail"));
				modifyMember.setPostCode(rs.getInt("postcode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return modifyMember;
	}

	public int modifyMember(Member modifyMember) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "update member set name=?, address=?, addressdetail=?, postcode=? where id=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, modifyMember.getName());
			pstmt.setString(2, modifyMember.getAddress());
			pstmt.setString(3, modifyMember.getDetailAddress());
			pstmt.setInt(4, modifyMember.getPostCode());
			pstmt.setString(5, modifyMember.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}
}







