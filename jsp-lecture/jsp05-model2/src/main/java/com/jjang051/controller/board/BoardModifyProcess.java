package com.jjang051.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jjang051.dao.BoardDao;
import com.jjang051.dto.Board;
import com.jjang051.util.ScriptWriter;

@WebServlet("/board/modify-process")
public class BoardModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardModifyProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no=0;
		if(strNo!=null && !strNo.isEmpty()) {
			no= Integer.parseInt(strNo);
		}
		String password = request.getParameter("password");
		BoardDao boardDao = new BoardDao();
		Board modifyBoard = boardDao.modifyBoard(no,password);
		if(modifyBoard!=null) {
			request.setAttribute("modifyBoard", modifyBoard);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/modify-form.jsp");
			dispatcher.forward(request, response);
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요.");
		}
	}

}
