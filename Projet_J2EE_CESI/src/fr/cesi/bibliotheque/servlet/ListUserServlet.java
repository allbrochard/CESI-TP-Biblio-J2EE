package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.LivreDAO;
import fr.cesi.bibliotheque.dao.UserDAO;
import fr.cesi.bibliotheque.entity.Livre;
import fr.cesi.bibliotheque.entity.User;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/ListUser")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/listUser.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("role") == "admin"){
			request.getSession().setAttribute("login",  request.getParameter("login"));
			request.getSession().setAttribute("role", "admin");
			request.setAttribute("login", request.getSession().getAttribute(("login")));
			request.setAttribute("role", request.getSession().getAttribute(("role")));
		}
		doGet(request, response);	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = UserDAO.getAllUsers();
        request.setAttribute("users", users);
        request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
