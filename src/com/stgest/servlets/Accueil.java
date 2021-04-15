package com.stgest.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stgest.dao.DaoFactory;
import com.stgest.dao.ProduitDao;
import com.stgest.dao.UtilisateurDao;

import com.stgest.beans.*;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurDao utilisateurDao;
    private ProduitDao produitDao;
    protected String resultat;
    protected String result;
    protected boolean Searched;
    protected boolean Found = false;
    protected boolean flag;
    protected List<Utilisateur> list_clients = new ArrayList<Utilisateur>();
    protected List<Produit> list_produits = new ArrayList<Produit>();
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
        this.produitDao = daoFactory.getProduitDao();
    }

    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
        try {
    		String nom = request.getParameter("nom");
            if(!nom.isEmpty()){
            	Searched = true;
            } else {
            	Searched = false;
            }
            
            
            list_produits = produitDao.lister();
            Found = false;
        	request.setAttribute("nomP", nom);
            for(Produit prod : list_produits){
            	if(prod.getNom().equals(nom)){
            		Found = true;
	            	request.setAttribute("quantite", prod.getQuantite());
	            	request.setAttribute("prix_unit", prod.getPrix_unit());
	            	request.setAttribute("description", prod.getDescription());
	            	request.setAttribute("achete_fois", prod.getAchete_fois());
            	}
            }
            
           
            
        }
        catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
        }

    	request.setAttribute("Found", Found);
    	request.setAttribute("Searched", Searched);
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            
            flag = false;
            list_clients = utilisateurDao.lister();
            
            for(Utilisateur utilis : list_clients){
            	if(utilis.getEmail().equals(email) && utilis.getPass().equals(password)){
            		session.setAttribute("email", utilis.getEmail());
            		session.setAttribute("tele", utilis.getTele());
            		session.setAttribute("adresse", utilis.getAdresse());
            		session.setAttribute("pays", utilis.getPays());
            		session.setAttribute("sexe", utilis.getSexe());
            		session.setAttribute("nom", utilis.getNom());
            		session.setAttribute("prenom", utilis.getPrenom());
            		session.setAttribute("flag", true);
            		flag = true;
            	}
            }
            
           
            
        }
        catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
        }
   
        request.setAttribute("flag", flag);
        
        if(flag == false){
        	this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {
        	this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }
        
        
	}

}
