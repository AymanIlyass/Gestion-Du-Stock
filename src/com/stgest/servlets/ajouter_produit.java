package com.stgest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stgest.beans.Produit;
import com.stgest.dao.DaoFactory;
import com.stgest.dao.ProduitDao;

/**
 * Servlet implementation class ajouter_produit
 */
@WebServlet("/ajouter_produit")
public class ajouter_produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProduitDao produitDao;
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.produitDao = daoFactory.getProduitDao();
    }
    
    public ajouter_produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_produit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
            Produit produit = new Produit();
            produit.setNom(request.getParameter("nom"));
            produit.setQuantite(Integer.parseInt(request.getParameter("quantite")));
            produit.setPrix_unit(Float.parseFloat(request.getParameter("prix_unit")));
            produit.setDescription(request.getParameter("description"));
            produit.setAchete_fois(Integer.parseInt(request.getParameter("achete_fois")));
            
            
            
			produitDao.ajouter(produit);
            request.setAttribute("produits", produitDao.lister());
        }
        catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
        }
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_produit.jsp").forward(request, response);
	}
}
