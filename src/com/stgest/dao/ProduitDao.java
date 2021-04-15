package com.stgest.dao;

import java.util.List;

import com.stgest.beans.Produit;

public interface ProduitDao {
    void ajouter( Produit produit ) throws DaoException;
    List<Produit> lister() throws DaoException;
}