

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Hi() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String name02 = request.getParameter("name02");
		Person person = new Person();
		person.setName("장성호");
		person.setNickName("장동건");
		person.setAge(30);
		person.setGender("male");
		
		
		Person person02 = new Person("유재석","메뚜기",40,"male");
		Person person03 = new Person("하하","꼬마",38,"male");
		Person person04 = new Person("미주","모르겠음",24,"female");
		Person person05 = new Person("진주","모르겠음",24,"female");
		Person person06 = new Person("이경","모르겠음",32,"male");
		Person person07 = new Person("우재","모르겠음",35,"male");
		
		
		
		
		List<Person> personList = new ArrayList<>();
		personList.add(person02);
		personList.add(person03);
		personList.add(person04);
		personList.add(person05);
		personList.add(person06);
		personList.add(person07);
		
		
		
		request.setAttribute("me", person);
		request.setAttribute("personList", personList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("hi.jsp");
		
		
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
