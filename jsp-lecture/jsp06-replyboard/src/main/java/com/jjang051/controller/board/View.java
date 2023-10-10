package com.jjang051.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jjang051.dao.BoardDao;
import com.jjang051.dto.BoardDto;


public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public View() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		String strNum = request.getParameter("num");
		
		
		
		int no=0;
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		
		int num=0;
		if(strNum!=null && !strNum.isEmpty()) {
			num = Integer.parseInt(strNum);
		}
		
		
		BoardDao boardDao = new BoardDao();
		BoardDto viewBoard = boardDao.view(no);
		
		BoardDto prevBoard = boardDao.prevSelect(num);
		prevBoard = boardDao.prevSelect(num);		
		BoardDto nextBoard = boardDao.nextSelect(num);
		
		
		System.out.println("num=="+num);
		
		System.out.println("prevBoard.getNum()=="+prevBoard.getNum());
		
		request.setAttribute("viewBoard", viewBoard);
		request.setAttribute("prevBoard", prevBoard);
		request.setAttribute("nextBoard", nextBoard);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/view.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





