package com.jjang051.service;

import java.util.List;

import com.jjang051.dto.Board;

public interface BoardService {
	List<Board> list();
	int insertBoard(Board board); // ckeditor
	Board viewBoard(int no);
	int deleteBoard(int no,String password);
}

