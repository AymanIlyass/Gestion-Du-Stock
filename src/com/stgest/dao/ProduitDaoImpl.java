package com.stgest.dao;

import java.sql.*;
import com.stgest.beans.ConnectionForm;
import com.stgest.beans.Produit;

import java.util.ArrayList;

import java.util.List;


import com.stgest.beans.BeanException;


public class ProduitDaoImpl implements ProduitDao {
    private DaoFactory daoFactory;
    protected String isEx;
    protected ConnectionForm conForm = new ConnectionForm();
    protected boolean flag;
    protected int idd;

    ProduitDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    
    @Override
    public void ajouter(Produit produit) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO products(nom, quantite, prix_unit, description, achete_fois) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setString(1, produit.getNom());
            preparedStatement.setInt(2, produit.getQuantite());
            preparedStatement.setFloat(3, produit.getPrix_unit());
            preparedStatement.setString(4, produit.getDescription());
            preparedStatement.setInt(5, produit.getAchete_fois());
            
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
    public List<Produit> lister() throws DaoException {
        List<Produit> produits = new ArrayList<Produit>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT nom, quantite, prix_unit, description, achete_fois FROM products;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                int quantite = resultat.getInt("quantite");
                float prix_unit = resultat.getFloat("prix_unit");
                String description = resultat.getString("description");
                int achete_fois = resultat.getInt("achete_fois");

                Produit produit = new Produit();
                produit.setNom(nom);
                produit.setQuantite(quantite);
                produit.setPrix_unit(prix_unit);
                produit.setDescription(description);
                produit.setAchete_fois(achete_fois);

                produits.add(produit);
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
        return produits;
    }


}