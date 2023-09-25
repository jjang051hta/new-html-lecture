package com.jjang051.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jjang051.common.JDBCConnect;
import com.jjang051.dao.MemberDao;
import com.jjang051.dto.Member;
import com.jjang051.service.MemberService;
import com.jjang051.util.ScriptWriter;


public class InsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService memberDao = new MemberDao();
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		if(request.getParameter("postCode")!=null) {
			postCode = Integer.parseInt(request.getParameter("postCode"));
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		Member insertMember = new Member();
		insertMember.setId(userID);
		insertMember.setName(userName);
		insertMember.setPassword(userPW);
		insertMember.setAddress(address);
		insertMember.setPostCode(postCode);
		insertMember.setDetailAddress(detailAddress);
		int result = memberDao.insertMember(insertMember);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입이 되었습니다.", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "서버 오류입니다. 다시 시도해주세요.");
		}
	}

}





