package be.Denis.Model;

import java.sql.Date;

public class Membre extends Personne {
	
	
	public Membre(int numMembre, String nom, String prenom, Date dateNaiss, String sexe, String categorie,String adresse, int numeroMaison, int codePostal, String ville, long numTel, String eMail, String login, String password, String fonction){
		super(numMembre, nom, prenom,dateNaiss, sexe,categorie,adresse,numeroMaison,codePostal,ville,numTel,eMail,login,password,fonction);
	}
	

	/***
	 *  Méthode de la classe Membre
	 */
	public void updateCompte() {
		super.updateCompte();
	}
	
}
