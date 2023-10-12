package com.jjang051.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.jjang051.dao.BoardDao;
import com.jjang051.dto.BoardDto;
import com.jjang051.dto.PageDto;

@WebServlet("/board/list")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int start = Integer.parseInt(request.getParameter("start"));
		//int end = Integer.parseInt(request.getParameter("end"));
		
		BoardDao boardDao = new BoardDao();
		HashMap <String,Integer> pageMap = new HashMap<>();
		pageMap.put("start", 1);
		pageMap.put("end", 10);
		PageDto pageDto = new PageDto();
		pageDto.setStart(1);
		pageDto.setEnd(7);
		List<BoardDto> boardList = boardDao.getAllBoard(pageDto);
		//System.out.println(boardList.size());
		request.setAttribute("boardList", boardList);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
			
		 HttpSession session = request.getSession();
		 if(session.getAttribute("modalState")!=null) {
			 session.removeAttribute("modalState");
		 }
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
