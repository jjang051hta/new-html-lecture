package com.jjang051.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jjang051.dao.BoardDao;
import com.jjang051.dao.MemberDao;
import com.jjang051.dto.Member;
import com.jjang051.util.ScriptWriter;

@WebServlet("/board/modify-confirm-process")
public class BoardModifyConfirmProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyConfirmProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no=0;
		if(strNo!=null && !strNo.isEmpty()) {
			no= Integer.parseInt(strNo);
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.modifyConfirmProcess(no,title,content);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 수정되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "서버오류입니다. 잠시 후 다시 시도해 주세요.");
		}
		
	}

}




