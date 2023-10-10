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
import com.juju.dto.Member;
import com.juju.util.ScriptWriter;


public class ModifyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifyConfirm() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//여기로 받음
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		System.out.println((String)session.getAttribute("loggedID"));
		String userPW = request.getParameter("userPW");
		MemberDao memberDao = new MemberDao();
		Member modifyMember = memberDao.modifyPasswordConfirm(userID, userPW);
		
		System.out.println(modifyMember);
		if (modifyMember != null) {
			request.setAttribute("modifyMember", modifyMember);
			RequestDispatcher dispatcher  = request.getRequestDispatcher("/WEB-INF/member/modify-form.jsp");
			dispatcher.forward(request, response);
		}
		else {
			ScriptWriter.alertAndBack(response, "비밀번호 확인 바람");
		}
	}

}
