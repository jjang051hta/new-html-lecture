package com.jjang051.service;

import java.util.List;

import com.jjang051.dto.BoardDto;

public interface BoardService {
	int write(BoardDto boardDto);
	List<BoardDto> list();
	int getMaxRegroup();
}
