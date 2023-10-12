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
import com.jjang051.dto.ModalState;

@WebServlet("/board/delete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no = 0;
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(no);
		if(result>0) {
			String msg = URLEncoder.encode("글이 삭제되었습니다.", StandardCharsets.UTF_8);
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show","글이 삭제되었습니다.");
			session.setAttribute("modalState", modalState);
			//session.setMaxInactiveInterval(1);
			response.sendRedirect("../board/list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


