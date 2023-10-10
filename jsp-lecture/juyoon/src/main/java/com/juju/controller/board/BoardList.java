package com.juju.controller.board;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.juju.dao.BoardDao;
import com.juju.dto.Board;


public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("wow");
		
		BoardDao boardDao = new BoardDao();
		List<Board> boardList = boardDao.list();
		request.setAttribute("boardList", boardList);
		request.setAttribute("boardSize", boardList.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}