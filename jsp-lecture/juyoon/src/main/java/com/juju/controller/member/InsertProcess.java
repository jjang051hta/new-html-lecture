package com.juju.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.juju.dao.MemberDao;
import com.juju.dto.Member;
import com.juju.service.MemberService;
import com.juju.util.ScriptWriter;

public class InsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertProcess() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//여기서 회원가입 처리를 함
		
		  PrintWriter out = response.getWriter();
		  //out.println("test line");
		  
		  MemberService memberDao = new MemberDao(); 
		  String userID = request.getParameter("userID"); 
		  String userPW = request.getParameter("userPW"); 
		  String userName = request.getParameter("userName"); 
		  String email = request.getParameter("email");
		  String tel = request.getParameter("tel"); 
		  int zipCode = 0; 
		  if (request.getParameter("zipCode") != null && request.getParameter("zipCode") != "") { 
			  zipCode = Integer.parseInt(request.getParameter("zipCode")); 
		  }
		  
		  String address = request.getParameter("address"); 
		  String detailAddress = request.getParameter("detailAddress");
		  Part profile = request.getPart("profile");//이미지 파일은 getPart로 받아야함
		
		  String uploadDirectory = "C:\\upload";
		
		  String newFileName = "";
		  
		  String partHeader = profile.getHeader("Content-disposition");
		  System.out.println(partHeader);
		  String[] partHeaderArray = partHeader.split("filename=");
		  System.out.println(partHeaderArray[0]);
		  System.out.println(partHeaderArray[1]);
		
		
		  String originalFileName = partHeaderArray[1].trim().replace("\"", "");
		 
		  System.out.println(originalFileName);
		
		  String realUploadPath = uploadDirectory;
		  System.out.println("realUploadPath==="+realUploadPath);
		  if (!originalFileName.isEmpty()) {
			  profile.write(realUploadPath+File.separator+originalFileName);
			  String ext = originalFileName.substring(originalFileName.lastIndexOf("."));

			  
			  
			  //if (ext.equals(".jpg")||ext.equals(".jpeg"))
			  String firstFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
			
			  Date now = new Date();				
			  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");		
			  String strNow = simpleDateFormat.format(now);
			  System.out.println(strNow);
			  newFileName = firstFileName + "_" + strNow + ext;
			  System.out.println(newFileName);
			
			  File oldFile = new File(realUploadPath+File.separator+originalFileName);
			  File newFile = new File(realUploadPath+File.separator+newFileName);
			
			  oldFile.renameTo(newFile);
			 
			   
			
		  }
			/*
			 * String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			 * 
			 * 
			 * 
			 * //if (ext.equals(".jpg")||ext.equals(".jpeg")) String firstFileName =
			 * originalFileName.substring(0, originalFileName.lastIndexOf("."));
			 * 
			 * Date now = new Date(); SimpleDateFormat simpleDateFormat = new
			 * SimpleDateFormat("yyyyMMdd-HHmmss"); String strNow =
			 * simpleDateFormat.format(now); System.out.println(strNow); String newFileName
			 * = firstFileName + "_" + strNow + ext; System.out.println(newFileName);
			 * 
			 * File oldFile = new File(realUploadPath+File.separator+originalFileName); File
			 * newFile = new File(realUploadPath+File.separator+newFileName);
			 * 
			 * oldFile.renameTo(newFile);
			 */
		  Member insertMember = new Member();
			 
		   insertMember.setId(userID); 
		   insertMember.setPassword(userPW);
		   insertMember.setName(userName); 
		   insertMember.setEmail(email); 
		   insertMember.setTel(tel); 
		   insertMember.setZipCode(zipCode);
		   insertMember.setAddress(address);
		   insertMember.setAddressDetail(detailAddress);
		   insertMember.setProfile(newFileName);
		   int result = memberDao.insertMember(insertMember);
		 
		   if (result>0) { 
			   ScriptWriter.alertAndNext(response, "회원가입이 완료되었습니다.", "../index/index"); 
		   } 
		   else { 
			   ScriptWriter.alertAndBack(response, "회원가입 실패"); 
		   }
		
		
	}

}
