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
import com.jjang051.util.ScriptWriter;


public class InsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//여기서 회원가입 처리....
		//PrintWriter out = response.getWriter();
		//out.println("test");
		JDBCConnect jdbcConn =  new JDBCConnect();

		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		if(request.getParameter("postCode")!=null) {
			postCode = Integer.parseInt(request.getParameter("postCode"));
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		MemberDao memberDao = new MemberDao();
		//memberDao.insertMember(new Member());
		
				
//		MemberDao memberDao = new MemberDao();
//		memberDao.insertMember(memberDto);
//		
//		MemberDao memberDao = new MemberDao();
//		memberDao.loginMember(memberDto);
//		
//		MemberDao memberDao = new MemberDao();
//		memberDao.deleteMember(memberDto);
		
		
		
		
	}

}





