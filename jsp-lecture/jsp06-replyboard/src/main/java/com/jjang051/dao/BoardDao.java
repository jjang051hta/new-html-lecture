package com.jjang051.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jjang051.common.JDBCConnect;
import com.jjang051.dto.BoardDto;
import com.jjang051.service.BoardService;

public class BoardDao implements BoardService {
	@Override
	public int write(BoardDto boardDto) {
		int max = getMaxRegroup();
		System.out.println(boardDto.toString());
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "insert into replyboard values(seq_replyboard.nextval,?,?,?,?,sysdate,0,?,?,?,1)";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserID());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContent());
			pstmt.setInt(5, max+1);  // regroup 제일큰거 찾아서 1 증가
			pstmt.setInt(6, 1);  // 1
			pstmt.setInt(7, 1);   // 1
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	@Override
	public List<BoardDto> list() {
		List<BoardDto> boardList = null;
		ResultSet rs = null;
		
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "SELECT * FROM"
					+ "			(SELECT rownum  AS num , b.* from"
					+ "				(SELECT * FROM REPLYBOARD ORDER BY regroup DESC, RELEVEL ASC) b)";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<BoardDto>();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNum(rs.getInt("num"));
				boardDto.setNo(rs.getInt("no"));
				boardDto.setUserID(rs.getString("userID"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegroup(rs.getInt("regroup"));
				boardDto.setRelevel(rs.getInt("relevel"));
				boardDto.setRestep(rs.getInt("restep"));
				boardDto.setAvailable(rs.getInt("available"));
				boardList.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return boardList;
	}

	@Override
	public int getMaxRegroup() {
		int result = 0;
		ResultSet rs = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select nvl(max(regroup),0) as max from replyboard";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	public BoardDto view(int no) {
		BoardDto viewBoard = null; 
		ResultSet rs = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "SELECT * FROM"
					+ "			(SELECT rownum  AS num , b.* from"
					+ "				(SELECT * FROM REPLYBOARD ORDER BY regroup DESC, RELEVEL ASC) b)"
					+ "where no=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			rs = pstmt.executeQuery();
			viewBoard = new BoardDto();
			if(rs.next()) {
				viewBoard.setNum(rs.getInt("num"));
				viewBoard.setNo(rs.getInt("no"));
				viewBoard.setUserID(rs.getString("userID"));
				viewBoard.setName(rs.getString("name"));
				viewBoard.setTitle(rs.getString("title"));
				viewBoard.setContent(rs.getString("content"));
				viewBoard.setRegDate(rs.getString("regDate"));
				viewBoard.setHit(rs.getInt("hit"));
				viewBoard.setRegroup(rs.getInt("regroup"));
				viewBoard.setRelevel(rs.getInt("relevel"));
				viewBoard.setRestep(rs.getInt("restep"));
				viewBoard.setAvailable(rs.getInt("available"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return viewBoard;
	}

	public int updateRelevel(BoardDto boardDto) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			// 답글쓸때 그룹은 같은 그룹
			String sql = "update replyboard set relevel = relevel + 1 where regroup = ? and relevel > ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1,boardDto.getRegroup());
			pstmt.setInt(2,boardDto.getRelevel());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	public int reply(BoardDto boardDto) {
		System.out.println(boardDto.toString());
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "insert into replyboard values(seq_replyboard.nextval,?,?,?,?,sysdate,0,?,?,?,1)";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserID());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContent());
			pstmt.setInt(5, boardDto.getRegroup());  // regroup 제일큰거 찾아서 1 증가
			pstmt.setInt(6, boardDto.getRelevel());  // 1
			pstmt.setInt(7, boardDto.getRestep());   // 1
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	public int delete(int no) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			// 답글쓸때 그룹은 같은 그룹
			String sql = "update replyboard set available = 0 where no = ?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}
	public BoardDto prevSelect(int num) {
		BoardDto board = null; 
		ResultSet rs = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "SELECT * FROM"
					+ "	(SELECT rownum  AS num , b.* from"
					+ "		(SELECT * FROM REPLYBOARD ORDER BY regroup DESC, RELEVEL ASC) b)"
					+ "	WHERE num = ? - 1";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			board = new BoardDto();
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setNo(rs.getInt("no"));
				board.setUserID(rs.getString("userID"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("regDate"));
				board.setHit(rs.getInt("hit"));
				board.setRegroup(rs.getInt("regroup"));
				board.setRelevel(rs.getInt("relevel"));
				board.setRestep(rs.getInt("restep"));
				board.setAvailable(rs.getInt("available"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return board;
	}
	public BoardDto nextSelect(int num) {
		BoardDto board = null; 
		ResultSet rs = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "SELECT * FROM"
					+ "	(SELECT rownum  AS num , b.* from"
					+ "		(SELECT * FROM REPLYBOARD ORDER BY regroup DESC, RELEVEL ASC) b)"
					+ "	WHERE num = ? + 1";
			// 카톡 보내주세요... 제발...
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			board = new BoardDto();
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setNo(rs.getInt("no"));
				board.setUserID(rs.getString("userID"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("regDate"));
				board.setHit(rs.getInt("hit"));
				board.setRegroup(rs.getInt("regroup"));
				board.setRelevel(rs.getInt("relevel"));
				board.setRestep(rs.getInt("restep"));
				board.setAvailable(rs.getInt("available"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return board;
	}
}




