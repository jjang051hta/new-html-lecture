package com.jjang051.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jjang051.dto.BoardDto;
import com.jjang051.mybatis.MybatisConnectionFactory;

public class BoardDao {
	public List<BoardDto> getAllBoard(HashMap<String,Integer> pageMap) {
		List<BoardDto> boardList = null;
		// SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllReplyboard",pageMap);
		sqlSession.close();
		return boardList;
	}
	public BoardDto getOneBoard(int no) {
		BoardDto boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getOneBoard",no);
		sqlSession.close();
		return boardDto;
	}
}
