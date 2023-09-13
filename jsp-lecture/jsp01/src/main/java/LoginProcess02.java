

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-process02")
public class LoginProcess02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginProcess02() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		if(userID.equals("jjang051") && userPW.equals("1234")) {
//			out.println("""
//						<script>
//							alert('로그인 성공');
//							location.href="http://www.daum.net";
//						</script>
//					""");
			//  4개의 영역....  application, session, request, pageContext
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			response.sendRedirect("login-success");
		} else {
			out.println("""
						<script>
							alert('로그인 실패');
							history.back();
						</script>
					""");
		}
	}

}
