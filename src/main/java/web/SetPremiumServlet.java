package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repostories.IamUserRepository;
import repostories.UserRepository;
import domain.User;

@WebServlet("/premium")
public class SetPremiumServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = retrieveUserFromRequest(request, response);
		IamUserRepository repository = new UserRepository();
		
		if(request.getParameter("premium").equals("add")) {
			repository.setPremium(user);
		} else {
			repository.removePremium(user);
		}
		
		response.sendRedirect("/allUsersServlet");
	}
	
	private User retrieveUserFromRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
		User result = new User();
		result.setUsername(request.getParameter("username"));
		return result;
	}

}
