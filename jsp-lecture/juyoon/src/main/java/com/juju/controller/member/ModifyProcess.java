package com.juju.controller.member;

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
		String userID = (String) session.getAttribute("loggedID");
		String userName = request.getParameter("userName");
		System.out.println("wow"+userID);
		int zipCode = 0;
		if (request.getParameter("zipCode") != null) {
			zipCode = Integer.parseInt(request.getParameter("zipCode"));
			
		}
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("detailAddress"); // 이게 안 넘어오고 있음
		System.out.println("세부주소:" + addressDetail);
		
		Member modifyMember = new Member();
		modifyMember.setId(userID);
		modifyMember.setName(userName);
		modifyMember.setZipCode(zipCode);
		modifyMember.setAddress(address);
		modifyMember.setAddressDetail(addressDetail);
		
		System.out.println(modifyMember);
		MemberDao memberDao = new MemberDao();
		
		int result = memberDao.modifyMember(modifyMember);
		System.out.println(result);
		if(result>0) {
			session.setAttribute("loggedName", userName);
			ScriptWriter.alertAndNext(response, "회원정보가 수정되었습니다.", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해 주세요");
		}
	}

}
