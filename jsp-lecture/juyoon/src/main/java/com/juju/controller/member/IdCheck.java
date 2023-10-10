package com.juju.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.juju.dao.MemberDao;

public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IdCheck() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		MemberDao memberDao = new MemberDao();
		
		int count = memberDao.idCheck(userID);
		Gson gson = new Gson();
		HashMap<String, Integer> map = new HashMap<>();
		map.put("count", count);
		String resultJson = gson.toJson(map);
		System.out.println(resultJson);
		request.setAttribute("resultJson", resultJson);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/id-check.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
