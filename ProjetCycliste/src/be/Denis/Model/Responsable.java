package be.Denis.Model;

import java.util.Date;

public class Responsable extends Personne {
	public Responsable(String nom, String prenom, Date dateNaiss, String sexe, String categorie,String adresse, int numeroMaison, int codePostal, String ville, int numTel, String eMail, String login, String password, String fonction){
		super(nom,prenom,dateNaiss, sexe,categorie,adresse,numeroMaison,codePostal,ville,numTel,eMail,login,password,fonction);
	}
}
