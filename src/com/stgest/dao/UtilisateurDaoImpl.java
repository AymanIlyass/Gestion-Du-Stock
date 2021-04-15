package com.stgest.dao;

import java.sql.*;
import com.stgest.beans.ConnectionForm;
import java.util.ArrayList;

import java.util.List;


import com.stgest.beans.BeanException;

import com.stgest.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
    private DaoFactory daoFactory;
    protected String isEx;
    protected ConnectionForm conForm = new ConnectionForm();
    protected boolean flag;
    protected int idd;

    UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    
    @Override
    public void ajouter(Utilisateur utilisateur) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO users(nom, prenom, email, password, tele, adresse, pays, sexe) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getEmail());
            preparedStatement.setString(4, utilisateur.getPass());
            preparedStatement.setString(5, utilisateur.getTele());
            preparedStatement.setString(6, utilisateur.getAdresse());
            preparedStatement.setString(7, utilisateur.getPays());
            preparedStatement.setString(8, utilisateur.getSexe());

            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }

    }

    @Override
    public List<Utilisateur> lister() throws DaoException {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT nom, prenom, email, password, tele, adresse, pays, sexe FROM users;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                String password = resultat.getString("password");
                String tele = resultat.getString("tele");
                String adresse = resultat.getString("adresse");
                String pays = resultat.getString("pays");
                String sexe = resultat.getString("sexe");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setEmail(email);
                utilisateur.setPass(password);
                utilisateur.setTele(tele);
                utilisateur.setAdresse(adresse);
                utilisateur.setPays(pays);
                utilisateur.setSexe(sexe);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        } catch (BeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return utilisateurs;
    }


}