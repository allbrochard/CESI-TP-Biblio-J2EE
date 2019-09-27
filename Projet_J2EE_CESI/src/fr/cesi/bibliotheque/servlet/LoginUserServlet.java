package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.UserDAO;
import fr.cesi.bibliotheque.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginUser")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/Accueil";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("deco").equals("1")) {
			request.getSession().removeAttribute("login");
			request.getSession().removeAttribute("role");
		}
		request.getRequestDispatcher(VUE).forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = UserDAO.getAllUsers();
		for (User user : users) {
			if ( request.getParameter("login").equals(user.getLogin()) &&  request.getParameter("password").equals(user.getPassword())) { 
				request.getSession().setAttribute("login", user.getLogin());
				request.getSession().setAttribute("nom", user.getNom());
				request.getSession().setAttribute("role", "user");
				request.getSession().setAttribute("id", user.getId());
				request.setAttribute("login", request.getSession().getAttribute(("login")));
				request.setAttribute("nom", request.getSession().getAttribute(("nom")));
				request.setAttribute("id", request.getSession().getAttribute(("id")));
				request.setAttribute("role", request.getSession().getAttribute(("role")));
			}
		}
		request.getRequestDispatcher(VUE).forward(request, response) ;
		
	}


}
