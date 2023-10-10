package com.juju.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.juju.dao.MemberDao;
import com.juju.util.ScriptWriter;

public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteProcess() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userID = (String) session.getAttribute("loggedID");
		String userPW = request.getParameter("userPW");
		String userName = (String) session.getAttribute("loggedName");
		MemberDao memberDao = new MemberDao();
		int result = memberDao.deleteMember(userID, userPW);
		if(result>0) {
			ScriptWriter.alertAndNext(response, userName+"님 안녕히 가세요", "../index/index");
			session.invalidate();
		}
		else {
			ScriptWriter.alertAndBack(response, "패스워드를 다시 확인해주세요.");
		}
		
	}

}
