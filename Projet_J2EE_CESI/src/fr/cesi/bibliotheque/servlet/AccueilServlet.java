package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.cesi.bibliotheque.dao.LivreDAO;
import fr.cesi.bibliotheque.entity.Livre;

/**
 * Servlet implementation class Accueil4
 */
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/accueil.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
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
		List<Livre> livres = LivreDAO.getAllLivres();
        request.setAttribute("livres", livres);
        request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
