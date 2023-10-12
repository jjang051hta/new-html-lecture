package com.jjang051.controller.board;

import jakarta.servlet.RequestDispatcher;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String success = request.getParameter("success");
		String msg = request.getParameter("msg");
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardList = boardDao.list();
		request.setAttribute("boardList", boardList);
		request.setAttribute("success", success);
		request.setAttribute("msg", msg);
		request.setAttribute("title", "글쓰기");
		
		
		
		
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
