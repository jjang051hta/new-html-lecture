

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gugudan-form")
public class GugudanForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GugudanForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		out.println("""
				<form action="gugudan-result" method="get">
					<!--<input type="text" name="dan">-->
					<!--
					<label><input type="radio" name="dan" value="2"><span>2</span></label>
					<label><input type="radio" name="dan" value="3"><span>3</span></label>
					<label><input type="radio" name="dan" value="4"><span>4</span></label>
					-->
					<!--
					<select name="dan">
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
					-->
					<button>구구단 출력</button>
				</form>
				""");
		out.println("""
				<form action="item-result" method="get">
					<p>관심항목을 체크해 주세요.</p>
					<label><input type="checkbox" name="item" value="정치"><span>정치</span></label>
					<label><input type="checkbox" name="item" value="영화"><span>영화</span></label>
					<label><input type="checkbox" name="item" value="스포츠"><span>스포츠</span></label>
					<label><input type="checkbox" name="item" value="jsp"><span>jsp</span></label>
					<label><input type="checkbox" name="item" value="spring"><span>spring</span></label>
					<button>전송</button>
				</form>
				""");

	}
}








