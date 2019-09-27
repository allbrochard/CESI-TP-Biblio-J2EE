package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.UserDAO;
import fr.cesi.bibliotheque.entity.User;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/InsertUser")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/ajoutUser.jsp";
	public static final String HOME = "/ListUser";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login", request.getSession().getAttribute(("login")));
		request.setAttribute("nom", request.getSession().getAttribute(("nom")));
		request.setAttribute("id", request.getSession().getAttribute(("id")));
		request.setAttribute("role", request.getSession().getAttribute(("role")));
		request.getRequestDispatcher(VUE).forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String nom = request.getParameter("nom");
        String password = request.getParameter("password");

		User user = new User(nom,login,password);
		UserDAO.addUser(user);

        this.getServletContext().getRequestDispatcher(HOME).forward(request, response);
	}

}
