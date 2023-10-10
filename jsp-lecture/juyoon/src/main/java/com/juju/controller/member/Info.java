package com.juju.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.juju.dao.MemberDao;
import com.juju.dto.Member;
import com.juju.util.ScriptWriter;

public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Info() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		MemberDao memberDao = new MemberDao();
		
		Member infoMember = memberDao.infoMember(userID);
		if (infoMember==null) {
			ScriptWriter.alertAndBack(response, "실패");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/info.jsp");
			request.setAttribute("infoMember", infoMember);
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
