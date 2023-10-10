package com.juju.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.juju.common.JDBCConnect;
import com.juju.dto.Member;
import com.juju.service.MemberService;
import com.juju.util.ScriptWriter;

public class MemberDao implements MemberService {
	

	@Override
	public int insertMember(Member member) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert into member values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getEmail());
			pstmt.setString(5,member.getTel());
			pstmt.setInt(6,member.getZipCode());
			pstmt.setString(7,member.getAddress());
			pstmt.setString(8,member.getAddressDetail());
			pstmt.setString(9,member.getProfile());
			result = pstmt.executeUpdate();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			jdbcConn.close();
		}
		
		return result;
	}
	
	@Override
	public Member loginMember(String userID, String userPW) {
		Member loggedMember = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select * from member where id =? and password = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				loggedMember = new Member();
				loggedMember.setId(rs.getString("id"));
				loggedMember.setName(rs.getString("name"));
				loggedMember.setProfile(rs.getString("profile"));
				
				System.out.println(rs.getString("profile"));
			
			}
		}
		catch (SQLException e) {
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
			
			if (rs.next()) {
				infoMember = new Member();
				infoMember.setPassword(rs.getString("password"));
				infoMember.setZipCode(rs.getInt("zipcode"));
				infoMember.setAddress(rs.getString("address"));
				infoMember.setAddressDetail(rs.getString("addressdetail"));
				infoMember.setRegDate(rs.getString("regdate"));
				infoMember.setEmail(rs.getString("email"));
				infoMember.setTel(rs.getString("tel"));
				infoMember.setProfile(rs.getString("profile"));
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
			String sql = "select count(*) as count from member where id= ?";
			PreparedStatement pstmt;
			pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1,  userID);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			jdbcConn.close();
		}
		
		
		return result;
		
	}

	@Override
	public int deleteMember(String userID, String userPW) {
		JDBCConnect jdbcConn = new JDBCConnect();
		
		int result = 0;
		try {
			String sql = "delete from member where id = ? and password = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			jdbcConn.close();
		}
		return result;
	}

	public Member modifyPasswordConfirm(String userID, String userPW) {
		
		JDBCConnect jdbcConn = new JDBCConnect();
		
		Member modifyMember = null;
		try {
			String sql = "select * from member where id = ? and password = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				modifyMember = new Member();
				modifyMember.setAddress(rs.getString("address"));
				modifyMember.setAddressDetail(rs.getString("addressdetail"));
				modifyMember.setZipCode(rs.getInt("zipcode"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			jdbcConn.close();
		}
		return modifyMember;
	}

	public int modifyMember(Member modifyMember) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "update member set name=?, address=?, addressdetail=?, zipcode=? where id=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, modifyMember.getName());
			pstmt.setString(2, modifyMember.getAddress());
			pstmt.setString(3, modifyMember.getAddressDetail());
			pstmt.setInt(4, modifyMember.getZipCode());
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
