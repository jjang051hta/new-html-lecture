

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-process")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginProcess() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		if(userID.equals("jjang051") && userPW.equals("1234")) {
			out.println("<script>alert('로그인 성공');</script>");
		} else {
			out.println("<script>alert('로그인 실패');</script>");
		}
	}
}
