package com.jjang051.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.jjang051.common.JDBCConnect;
import com.jjang051.dao.MemberDao;
import com.jjang051.dto.Member;
import com.jjang051.service.MemberService;
import com.jjang051.util.ScriptWriter;

@WebServlet("/member/insert-process")
public class InsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberService memberDao = new MemberDao();
		System.out.print("isEmpty vs isBlank===");
		System.out.println("   ".isEmpty() + "====" + "  ".isBlank());

		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");

		int postCode = 0;
		if (request.getParameter("postCode") != null && !request.getParameter("postCode").isEmpty()) {
			postCode = Integer.parseInt(request.getParameter("postCode"));
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");

		
		String uploadDirectory = "C:\\upload";
		String realUploadPath = uploadDirectory;

		
		//만약 폴더를 모르고 안만들었을때 폴더 만들어 주세요...
		
//		String uploadDirectory = "upload";
//		String realUploadPath = getServletContext().getRealPath(uploadDirectory);
//		File dir = new File(realUploadPath);
//		if(!dir.exists()) {
//			dir.mkdir();
//		}
		
		
		Part profile = request.getPart("profile");
		String newFileName = "";
		String partHeader = profile.getHeader("Content-disposition");
		System.out.println("partHeader===" + partHeader);

		String partHeaderArray[] = partHeader.split("filename=");
		System.out.println("partHeaderArray[0]===" + partHeaderArray[0]);
		System.out.println("partHeaderArray[1]===" + partHeaderArray[1]);
		String originalFileName = partHeaderArray[1].trim().replace("\"", "");
		System.out.println(originalFileName);

		System.out.println("realUploadPath===" + realUploadPath);

		if (!originalFileName.isEmpty()) {
			// 실질적인 (믈리적인) 경로
			profile.write(realUploadPath + File.separator + originalFileName);

			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			if (ext.equals("jpg") || ext.equals("png") || ext.equals("gif") || ext.equals("jpeg")) {
				// 이미지만 받고 싶을때...
				ScriptWriter.alertAndBack(response, "이미지만 올릴 수 있습니다.");
			}
			String firstFilename = originalFileName.substring(0, originalFileName.lastIndexOf("."));
			System.out.println("firstFilename===" + firstFilename);

			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
			String strNow = simpleDateFormat.format(now);
			System.out.println(strNow);
			newFileName = firstFilename + strNow + ext; // 20230927132455.png
			System.out.println(newFileName);

			File oldFile = new File(realUploadPath + File.separator + originalFileName);
			File newFile = new File(realUploadPath + File.separator + newFileName);
			oldFile.renameTo(newFile);
		}

		Member insertMember = new Member();
		insertMember.setId(userID);
		insertMember.setName(userName);
		insertMember.setPassword(userPW);
		insertMember.setAddress(address);
		insertMember.setPostCode(postCode);
		insertMember.setDetailAddress(detailAddress);
		insertMember.setEmail(email);
		insertMember.setTel(tel);
		insertMember.setProfile(newFileName);

		int result = memberDao.insertMember(insertMember);
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "회원가입이 되었습니다.", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "서버 오류입니다. 다시 시도해주세요.");
		}

	}

}
