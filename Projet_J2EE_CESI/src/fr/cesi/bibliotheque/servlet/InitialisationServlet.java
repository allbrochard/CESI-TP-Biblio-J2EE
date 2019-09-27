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
 * Servlet implementation class InitialisationServlet
 */
@WebServlet("")
public class InitialisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Accueil";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitialisationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livre livre1 = new Livre("harry potter 1", "jeune", "J.K Rowling", (long)1);
		Livre livre2 = new Livre("Druss la Légende", "adulte", "David Gemmel", (long)2);
		Livre livre3 = new Livre("L'oeil du Loup", "jeune", "J.R.R", (long)3);
		Livre livre4 = new Livre("Le seigneur des anneaux", "adulte", "J.R.R Tolkien", (long)4);
		LivreDAO.addLivre(livre1);
		LivreDAO.addLivre(livre2);
		LivreDAO.addLivre(livre3);
		LivreDAO.addLivre(livre4);
		
		User user1 = new User("Allan Brochard", "Allan", "allan", (long)1);
		User user2 = new User("Ulrich Hassed", "Ulrich", "ulrich", (long)2);
		User user3 = new User("Romain Chretien", "Romain", "romain", (long)3);
		User admin = new User("Admin User", "admin", "admin", (long)3);
		UserDAO.addUser(user1);
		UserDAO.addUser(user2);
		UserDAO.addUser(user3);
		UserDAO.addUser(admin);
        request.getServletContext().getRequestDispatcher(VUE).forward(request, response);	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
