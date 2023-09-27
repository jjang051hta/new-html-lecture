package com.jjang051.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jjang051.dao.MemberDao;
import com.jjang051.dto.Member;
import com.jjang051.util.ScriptWriter;


public class ModifyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyConfirm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPW = request.getParameter("userPW");
		MemberDao memberDao = new MemberDao();
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		Member modifyMember = memberDao.modifyPasswordConfirm(userID,userPW);
		if(modifyMember!=null) {
			request.setAttribute("modifyMember", modifyMember);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/modify-form.jsp");
			dispatcher.forward(request, response);
		} else {
			ScriptWriter.alertAndBack(response, "패스워드 확인해 주세요");
		}
	}

}
