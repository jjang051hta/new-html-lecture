import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Gugudan() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out = response.getWriter();
		//out.println("<h1>Hello Servelet</h1>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("gugudan.jsp");
		//request.setAttribute("name", "juju09");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
