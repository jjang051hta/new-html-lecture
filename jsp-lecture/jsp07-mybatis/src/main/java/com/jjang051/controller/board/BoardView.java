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

@WebServlet("/board/view")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BoardView() {
		super();
	}
	protected String unscript(String data) {
	       if (data == null || data.trim().equals("")) {
	           return "";
	       }
	       
	       String unescapeTxt = data;
	       
	       unescapeTxt = unescapeTxt.replaceAll("<(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;script");
	       unescapeTxt = unescapeTxt.replaceAll("</(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;/script");
	       
	       unescapeTxt = unescapeTxt.replaceAll("<(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;object");
	       unescapeTxt = unescapeTxt.replaceAll("</(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;/object");
	       
	       unescapeTxt = unescapeTxt.replaceAll("<(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;applet");
	       unescapeTxt = unescapeTxt.replaceAll("</(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;/applet");
	       
	       unescapeTxt = unescapeTxt.replaceAll("<(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
	       unescapeTxt = unescapeTxt.replaceAll("</(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
	       
	       unescapeTxt = unescapeTxt.replaceAll("<(F|f)(O|o)(R|r)(M|m)", "&lt;form");
	       unescapeTxt = unescapeTxt.replaceAll("</(F|f)(O|o)(R|r)(M|m)", "&lt;form");

	       return unescapeTxt;
	   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no = 0;
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		System.out.println(no);
		BoardDao boardDao = new BoardDao();
		BoardDto viewBoard = boardDao.getOneBoard(no);
		
		String view = unscript(viewBoard.getContent());
		viewBoard.setContent(view);
		request.setAttribute("viewBoard", viewBoard);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/board/view.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
