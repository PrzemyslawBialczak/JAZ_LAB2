package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Permissions;
import domain.User;
import repostories.IamUserRepository;
import repostories.UserRepository;

@WebServlet("/signUp")
public class RegistartionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = retrieveUserFromRequest(request, response);
		IamUserRepository repository = new UserRepository();
		
		repository.add(user);
		response.sendRedirect("success.jsp");
	}
	
	private User retrieveUserFromRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
			response.sendRedirect("error2.jsp");
			return null;
		} else {
			User result = new User();
			result.setUsername(request.getParameter("username"));
			result.setPassword(request.getParameter("password"));
			result.setEmail(request.getParameter("email"));
			result.setPermissions(Permissions.NORMAL);
			return result;
		}
	}
}
