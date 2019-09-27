package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.LivreDAO;

/**
 * Servlet implementation class UpdateLivreServlet
 */
@WebServlet("/reserver")
public class ReserverLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/Accueil";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserverLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") == null && request.getParameter("idUnReserve") != null) {
			Long id = Long.parseLong(request.getParameter("idUnReserve"));
			LivreDAO.unLockUserIDLivre(LivreDAO.findLivreById(id));
		}else if(request.getParameter("id") != null ) {
			Long id = Long.parseLong(request.getParameter("id"));
			Long idUser = Long.parseLong(request.getParameter("idUser"));
			String nomUser = request.getParameter("nom");
			LivreDAO.updateUserIDLivre(LivreDAO.findLivreById(id), idUser, nomUser);
		}
        request.getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
