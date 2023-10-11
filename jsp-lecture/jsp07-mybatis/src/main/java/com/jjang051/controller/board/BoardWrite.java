package com.jjang051.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jjang051.dao.BoardDao;
import com.jjang051.dto.BoardDto;


public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setUserID("jjang051");
		boardDto.setName("장성호");
		boardDto.setTitle("mybatis를 이용하고 있습니다.");
		boardDto.setContent("mybatis를 이용하고 있습니다. \r\n mybatis를 이용하고 있습니다. \r\n mybatis를 이용하고 있습니다.");
		boardDto.setRegroup(8);
		boardDto.setRelevel(1);
		boardDto.setRestep(1);
		
		int result = boardDao.writeBoard(boardDto);
		if(result>0) {
			System.err.println("글이 입력되었습니다.");
		} else {
			System.err.println("오류");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
