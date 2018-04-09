package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import repostories.IamUserRepository;
import repostories.UserRepository;

@WebServlet("/allUsersServlet")
public class AllUsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IamUserRepository repository = new UserRepository();
		
		List<User> users = repository.getUsers();
		
		PrintWriter out = response.getWriter();
		
		out.println("<h3>Tabela zarejestrowanych uzytkownikow serwisu</h3></br>");
		
		out.println("<table border='2'><tr><th>Nazwa uzytkownika</th><th>Email</th><th>Uprawnienia</th></tr>");
		for (User user : users) {
			out.println("<tr><td align='center'>" + user.getUsername() + "</td>"
			+ "<td align='center'>" + user.getEmail() + "</td>"
			+ "<td align='center'>" + user.getPermissions() + "</td>"
		    + "</tr>");
		}
		out.println("</table>");
		out.println("</br><a href='index.jsp'>Wroc na strone glowna</a>");
	}
	
}
