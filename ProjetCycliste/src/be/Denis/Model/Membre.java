package be.Denis.Model;

import java.util.Date;
import java.sql.SQLException;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;

import be.Denis.Vue.VueMembre;

public class Membre extends Personne {
	
	
	public Membre(String nom, String prenom, Date dateNaiss, String sexe, String categorie,String adresse, int numeroMaison, int codePostal, String ville, int numTel, String eMail, String login, String password, String fonction){
		super(nom,prenom,dateNaiss, sexe,categorie,adresse,numeroMaison,codePostal,ville,numTel,eMail,login,password,fonction);
	}
	

	/***
	 *  Méthode de la classe Membre
	 */
	
	
}
