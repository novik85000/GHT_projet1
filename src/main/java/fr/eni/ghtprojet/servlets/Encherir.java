package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ghtprojet.bll.ArticleManager;
import fr.eni.ghtprojet.bll.RetraitManager;
import fr.eni.ghtprojet.bll.UtilisateurManager;
import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;

/**
 * Servlet implementation class Encherir
 */
@WebServlet("/encherir")
public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encherir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Article_vendu article = null;
		Utilisateur user = null;
		Retrait rt = null;
		List<Article_vendu> listArticles = null;
		try {
			ArticleManager mger = new ArticleManager();
			UtilisateurManager mgerUser = new UtilisateurManager();
			RetraitManager mgerRetr = new RetraitManager();
			article = mger.selectById(4);
			user = mgerUser.selectById(4);
			rt = mgerRetr.selectById(11);
			listArticles = mger.selectAll();
		
			
			System.out.println(article);
			System.out.println(user);
			System.out.println(rt);
			System.out.println(listArticles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp").forward(request, response);
	}

}
