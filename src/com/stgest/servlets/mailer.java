package com.stgest.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.stgest.beans.Utilisateur;
import com.stgest.dao.DaoFactory;
import com.stgest.dao.SendMail;
import com.stgest.dao.UtilisateurDao;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Servlet implementation class Mailer
 */
@WebServlet("/mailer")
public class mailer extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
		private UtilisateurDao utilisateurDao;
		protected List<Utilisateur> list_clients = new ArrayList<Utilisateur>();
		protected String password;
		protected String nom;
		protected String prenom;
		
	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.utilisateurDao = daoFactory.getUtilisateurDao();
	    }
	    
	    public mailer() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		   
			public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
				{
		   
		        
		        this.getServletContext().getRequestDispatcher("/WEB-INF/mailer.jsp").forward(request, response);
					}
		   
			public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        try {
		            String email = request.getParameter("email");
		            
		            
		            list_clients = utilisateurDao.lister();
		            
		            for(Utilisateur utilis : list_clients){
		            	if(utilis.getEmail().equals(email)){
		            		password = utilis.getPass();
		            		nom = utilis.getNom();
		            		prenom = utilis.getPrenom();
				            response.setContentType("text/html;charset=UTF-8");
				            PrintWriter out = response.getWriter();
				            
				            String to = email;
				            String subject = "Récupération du mot de passe";
				            String message =  "Bonjour "+prenom+" "+nom+"\n\nVotre Mot de passe est: "+password;
				            String user = "email";
				            String pass = "mot_de_passe";
				            SendMail.send(to,subject, message, user, pass);
				            out.println("Mail send successfully");
		            	}
		            }
		            

		           
		            
		        }
		        catch (Exception e) {
		            request.setAttribute("erreur", e.getMessage());
		        }
					this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
			}
}