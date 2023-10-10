package com.jjang051.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.jjang051.dao.BoardDao;
import com.jjang051.dto.BoardDto;


public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardList = boardDao.getAllBoard();
		BoardDto boardDto = boardDao.getOneBoard(15);
		
		System.out.println(boardList.size());
		System.out.println(boardDto.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
