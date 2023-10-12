package com.jjang051.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.jjang051.dao.BoardDao;
import com.jjang051.dto.BoardDto;
import com.jjang051.util.ScriptWriter;


public class WriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//title , content
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("test/html;charset=utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		
		BoardDao boardDao = new BoardDao();
		BoardDto insertBoardDto = new BoardDto();
		insertBoardDto.setTitle(title);
		insertBoardDto.setContent(content);
		insertBoardDto.setUserID(userID);
		insertBoardDto.setName(name);
		// regroup, relevel,restep  
		int result = boardDao.write(insertBoardDto);
		
		if(result>0) {
			//ScriptWriter.alertAndNext(response, "글이 등록되었습니다.", "../board/list");
			String sendTitle = URLEncoder.encode("제목",StandardCharsets.UTF_8);
			String sendMsg = URLEncoder.encode("글이 등록되었습니다.",StandardCharsets.UTF_8);
			
			response.sendRedirect("../board/list?success=true&title="+sendTitle+"&msg="+sendMsg);
			
		} else {
			//ScriptWriter.alertAndBack(response, "알 수 없는 오류로 잠시 후 다시 시도해 주시기 바랍니다.");
		}
	}
}






