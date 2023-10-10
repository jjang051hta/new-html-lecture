package com.juju.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.juju.common.JDBCConnect;
import com.juju.dto.Board;
import com.juju.service.BoardService;

public class BoardDao implements BoardService {

	@Override
	public List<Board> list() {
		List<Board> boardList = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "select * from board";
		ResultSet rs =null;
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList= new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setId(rs.getString("id"));
				board.setPassword(rs.getString("password"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		return boardList;
	}

	@Override
	public int insertBoard(Board board) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert into board values(board_seq.nextval,?,?,?,?,?,sysdate,0)";
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1,board.getId());
			pstmt.setString(2,board.getPassword());
			pstmt.setString(3,board.getName());
			pstmt.setString(4,board.getTitle());
			pstmt.setString(5,board.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	@Override
	public Board viewBoard(int no) {
		Board board = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "select * from board where no = ?";
		ResultSet rs =null;
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				board.setNo(rs.getInt("no"));
				board.setId(rs.getString("id"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		return board;
	}
	public int deleteBoard(int no, String password) {
		JDBCConnect jdbcConn = new JDBCConnect();
		int result = 0;
		String sql = "delete from board where no = ? and password = ?";
		
		
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);
		
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			jdbcConn.close();
		}
		return result;
		
	}
	
	

	public Board modifyBoard(int no, String password) {
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "select * from board where no = ? and password = ?";
		ResultSet rs =null;
		Board modifyBoard = null;
		PreparedStatement pstmt;
		try {
			pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				modifyBoard = new Board();
				modifyBoard.setId(rs.getString("id"));
				modifyBoard.setTitle(rs.getString("title"));
				modifyBoard.setContent(rs.getString("content"));
				modifyBoard.setRegDate(rs.getString("regdate"));
				modifyBoard.setHit(rs.getInt("hit"));
				modifyBoard.setName(rs.getString("name"));
				modifyBoard.setNo(rs.getInt("no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			jdbcConn.close();
		}
		return modifyBoard;
	}

	public int modifyConfirmProcess(int no, String title, String content) {
		JDBCConnect jdbcConn = new JDBCConnect();
		int result = 0;
		String sql = "update board set title = ?, content = ? where no = ?";
		
		
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			jdbcConn.close();
		}
		return result;
		
	}

	
}
