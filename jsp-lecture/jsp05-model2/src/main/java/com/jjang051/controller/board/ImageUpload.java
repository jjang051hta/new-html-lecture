package com.jjang051.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.jjang051.util.ScriptWriter;

@WebServlet("/board/upload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageUpload() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadDirectory = "C:\\upload";
		String realUploadPath = uploadDirectory;
		
		Part ckupload = request.getPart("upload");  // <input type="file" name="profile">
		String newFileName = "";
		String partHeader = ckupload.getHeader("Content-disposition");
		System.out.println("partHeader===" + partHeader);

		String partHeaderArray[] = partHeader.split("filename=");
		System.out.println("partHeaderArray[0]===" + partHeaderArray[0]);
		System.out.println("partHeaderArray[1]===" + partHeaderArray[1]);
		String originalFileName = partHeaderArray[1].trim().replace("\"", "");
		System.out.println(originalFileName);

		System.out.println("realUploadPath===" + realUploadPath);

		if (!originalFileName.isEmpty()) {
			// 실질적인 (믈리적인) 경로
			ckupload.write(realUploadPath + File.separator + originalFileName);

			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			if (!(ext.equals("jpg") || ext.equals("png") || ext.equals("gif") || ext.equals("jpeg"))) {
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
		
		
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		map.put("uploaded", true);
		map.put("url", request.getContextPath()+"/upload/"+newFileName);
		String resultJson = gson.toJson(map);
		request.setAttribute("resultJson", resultJson);
		System.out.println(resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/image-uploaded.jsp");
		dispatcher.forward(request, response);

	}

}
