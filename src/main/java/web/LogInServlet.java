package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import repostories.IamUserRepository;
import repostories.UserRepository;

@WebServlet("/logIn")
public class LogInServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		IamUserRepository repository = new UserRepository();
		
		User user = retrieveUserDataFromRequest(request, response);
		
		if (repository.logIn(user)) {
			session.setAttribute("username", user);
			response.sendRedirect("/profileServlet");
		} else {
			response.sendRedirect("error.jsp");
		}
	}
	
	private User retrieveUserDataFromRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			User result = new User();
			result.setUsername(request.getParameter("username"));
			result.setPassword(request.getParameter("password"));
			return result;
	}
}
