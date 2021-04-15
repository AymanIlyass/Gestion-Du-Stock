package com.stgest.beans;

import com.stgest.beans.BeanException;

public class Utilisateur {
	String prenom;
	String nom;
	String email;
	String pass;
	String tele;
	String adresse;
	String pays;
	String sexe;
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom){
		this.prenom = prenom;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
}
