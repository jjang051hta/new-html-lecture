package com.jjang051.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jjang051.dao.MemberDao;
import com.jjang051.dto.Member;
import com.jjang051.util.CookieManager;
import com.jjang051.util.ScriptWriter;

public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String saveID = request.getParameter("saveID");
		MemberDao memberDao = new MemberDao();
		Member loggedMember = memberDao.loginMember(userID, userPW);
		if (loggedMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedID", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			session.setAttribute("loggedMember", loggedMember);

			if (saveID != null) {
				if (saveID.equals("rememberMe")) {
					CookieManager.createCookie(response, "saveIDCookie", userID, 60 * 60 * 24 * 365);
				} else {
					CookieManager.deleteCookie(response, "saveIDCookie");
				}
			} else {
				CookieManager.deleteCookie(response, "saveIDCookie");
			}

			response.sendRedirect("../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해 주세요");
		}
	}
}
