package com.juju.controller.board;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.juju.dao.BoardDao;
import com.juju.dto.Board;
import com.juju.util.ScriptWriter;

public class BoardWriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardWriteProcess() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(content);
		Board boardDto = new Board();
		HttpSession session = request.getSession();
		boardDto.setId((String)session.getAttribute("loggedID"));
		boardDto.setName((String)session.getAttribute("loggedName"));
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setPassword(password);
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.insertBoard(boardDto);
		if(result>0) {
			response.sendRedirect("../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "서버오류입니다.");
		}
	}
}