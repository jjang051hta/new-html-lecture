package com.jjang051.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.jjang051.dao.BoardDao;
import com.jjang051.dto.BoardDto;
import com.jjang051.dto.ModalState;

@WebServlet("/board/write-process")
public class BoardWriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boardDto.setUserID("jjang051");
		boardDto.setName("장성호");
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setRegroup(8);
		boardDto.setRelevel(1);
		boardDto.setRestep(1);
		
		int result = boardDao.writeBoard(boardDto);
		if(result>0) {
			//String msg = URLEncoder.encode("글이 등록되었습니다.", StandardCharsets.UTF_8);
			//response.sendRedirect("../board/list?state=show&msg="+msg);
			
			HttpSession session = request.getSession();
			
			ModalState modalState = new ModalState("show","글이 등록되었습니다.");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../board/list");
		} else {
			
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
