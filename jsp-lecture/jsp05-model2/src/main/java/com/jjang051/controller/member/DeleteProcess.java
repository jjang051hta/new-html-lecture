package com.jjang051.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.PreparedStatement;

import com.jjang051.common.JDBCConnect;
import com.jjang051.dao.MemberDao;
import com.jjang051.util.ScriptWriter;

@WebServlet("/member/delete-process")
public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPW = request.getParameter("userPW");
		//String userID = request.getParameter("userID");
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		String userName = (String)session.getAttribute("loggedName");
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.deleteMember(userID, userPW);
		if(result>0) {
			ScriptWriter.alertAndNext(response, userName+"님 회원탈퇴되었습니다.", "../index/index");
			session.invalidate();
		} else {
			ScriptWriter.alertAndBack(response, "패스워드 확인해 주세요");
		}
	}
}









