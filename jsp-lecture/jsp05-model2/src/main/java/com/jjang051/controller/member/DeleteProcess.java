package com.jjang051.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;

import com.jjang051.common.JDBCConnect;
import com.jjang051.dao.MemberDao;
import com.jjang051.dto.Member;
import com.jjang051.util.ScriptWriter;

@WebServlet("/member/delete-process")
public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPW = request.getParameter("userPW");
		//String userID = request.getParameter("userID");
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		String userName = (String)session.getAttribute("loggedName");
		Member loggedMember = (Member)session.getAttribute("loggedMember");
		String profile  = loggedMember.getProfile();
		
		
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.deleteMember(userID, userPW);
		if(result>0) {
			//여기디가 삭제 코드 써야 할거 같죠?
			String uploadDirectory = "C:\\upload";
			String realUploadPath = uploadDirectory;
			System.out.println("realUploadPath+profile=="+realUploadPath+File.separator+profile);
			File profileFile = new File(realUploadPath+File.separator+profile);
			if(profileFile.exists()) {
				profileFile.delete();
			}
			ScriptWriter.alertAndNext(response, userName+"님 회원탈퇴되었습니다.", "../index/index");
			session.invalidate();
		} else {
			ScriptWriter.alertAndBack(response, "패스워드 확인해 주세요");
		}
		//패스워드 맞았을때 회원탍회 시키는데 업로드한 이미지 삭제...
	}
}









