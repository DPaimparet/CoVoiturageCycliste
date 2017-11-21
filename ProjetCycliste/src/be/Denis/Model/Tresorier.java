package be.Denis.Model;

import java.sql.Date;

public class Tresorier extends Personne {
	public Tresorier(int numTresorier, String nom, String prenom, Date dateNaiss, String sexe, String categorie,String adresse, int numeroMaison, int codePostal, String ville, long numTel, String eMail, String login, String password, String fonction){
		super(numTresorier, nom, prenom,dateNaiss, sexe,categorie,adresse,numeroMaison,codePostal,ville,numTel,eMail,login,password,fonction);
	}
	
	public void updateCompte() {
		super.updateCompte();
	}
}
