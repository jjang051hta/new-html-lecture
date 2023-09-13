

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-form")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginForm() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		out.println("""
					<form action="/jsp01/login-process" method="post">
						<input type="text" name="userID">
						<input type="password" name="userPW">
						<button>로그인</button>
					</form>
				""");
	}

}



