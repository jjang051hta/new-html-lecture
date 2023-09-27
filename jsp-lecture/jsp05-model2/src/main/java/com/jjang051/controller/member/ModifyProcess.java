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
import com.jjang051.util.ScriptWriter;

public class ModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		String userName = request.getParameter("userName");
		int postCode = 0;
		if(request.getParameter("postCode")!=null && !request.getParameter("postCode").isEmpty()) {
			postCode = Integer.parseInt(request.getParameter("postCode"));
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		Member modifyMember = new Member();
		modifyMember.setId(userID);
		modifyMember.setName(userName);
		modifyMember.setAddress(address);
		modifyMember.setDetailAddress(detailAddress);
		modifyMember.setPostCode(postCode);
		MemberDao memberDao = new MemberDao();
		int result = memberDao.modifyMember(modifyMember);
		if(result>0) {
			session.setAttribute("loggedName", userName);
			ScriptWriter.alertAndNext(response, "회원정보가 수정되었습니다.", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해 주세요");
		}
	}

}






