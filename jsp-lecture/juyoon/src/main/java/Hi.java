import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Hi() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out = response.getWriter();
		//out.println("<h1>Hi Servelet</h1>");
		
		Person person = new Person();
		person.setName("이주윤");
		person.setNickName("공주주");
		person.setAge(23);
		person.setGender("female");
		
		Person person02 = new Person("장원영", "갓기", 20, "female");
		Person person03 = new Person("패트릭", "존질", 23, "male");
		Person person04 = new Person("크리스토퍼", "퍼퍼", 26, "male");
		Person person05 = new Person("차은우", "만찢남", 27, "male");
		Person person06 = new Person("팜하니", "긴ㄴ금발", 20, "female");
		Person person07 = new Person("닝닝", "닝이", 22, "female");
		
		ArrayList<Person> personList = new ArrayList<>();
		personList.add(person02);
		personList.add(person03);
		personList.add(person04);
		personList.add(person05);
		personList.add(person06);
		personList.add(person07);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("hi.jsp");
		request.setAttribute("me", person);
		request.setAttribute("personList", personList);
		
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
