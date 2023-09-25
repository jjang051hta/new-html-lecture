package com.jjang051.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jjang051.common.JDBCConnect;
import com.jjang051.dto.Member;
import com.jjang051.service.MemberService;

public class MemberDao implements MemberService {

	@Override
	public int insertMember(Member member) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,sysdate)";
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getName());
			pstmt.setInt(4,member.getPostCode());
			pstmt.setString(5,member.getAddress());
			pstmt.setString(6,member.getDetailAddress());
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
		
		return null;
	}
}




