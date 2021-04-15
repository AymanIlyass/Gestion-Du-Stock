package com.stgest.beans;

public class Produit {
	private int quantite;
	private String nom;
	private float prix_unit;
	private String description;
	private int achete_fois;
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix_unit() {
		return prix_unit;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws BeanException {
		if(nom.length()>10){
	       	throw new BeanException("Le nom est trop grand ! (10 caractères maximum)");
	        } else{
	        	this.nom = nom;
	        }
	}
	public void setPrix_unit(float prix_unit) {
		this.prix_unit = prix_unit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAchete_fois() {
		return achete_fois;
	}
	public void setAchete_fois(int achete_fois) {
		this.achete_fois = achete_fois;
	}
	
}
