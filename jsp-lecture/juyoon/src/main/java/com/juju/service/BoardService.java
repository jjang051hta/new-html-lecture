package com.juju.service;

import java.util.List;

import com.juju.dto.Board;

public interface BoardService {
	List<Board> list();
	int insertBoard(Board board);
	Board viewBoard(int no);
	
}
