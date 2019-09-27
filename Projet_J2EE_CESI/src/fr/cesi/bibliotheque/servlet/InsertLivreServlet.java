package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
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
 * Servlet implementation class InsertLivre
 */
@WebServlet("/InsertLivre")
public class InsertLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/ajoutLivre.jsp";
	public static final String HOME = "/Accueil";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLivreServlet() {
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

		String titre = request.getParameter("titre");
		String edition = request.getParameter("edition");
		String auteur = request.getParameter("auteur");

		Livre livre = new Livre(titre,edition,auteur);
		LivreDAO.addLivre(livre);

        this.getServletContext().getRequestDispatcher(HOME).forward(request, response);
	}

}
