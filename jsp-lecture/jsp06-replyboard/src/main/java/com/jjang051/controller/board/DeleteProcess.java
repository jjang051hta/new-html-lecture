package com.jjang051.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jjang051.dao.BoardDao;
import com.jjang051.util.ScriptWriter;


public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no = 0;
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		BoardDao boardDao = new BoardDao();
		int result = boardDao.delete(no);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
