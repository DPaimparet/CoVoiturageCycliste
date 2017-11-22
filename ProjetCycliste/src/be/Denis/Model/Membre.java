package be.Denis.Model;

import java.sql.Date;
import java.util.LinkedList;

public class Membre extends Personne {
	private Reservation reservation;
	private Balade balade;
	
	public Membre(int numMembre, String nom, String prenom, Date dateNaiss, String sexe, String categorie,String adresse, int numeroMaison, int codePostal, String ville, long numTel, String eMail, String login, String password, String fonction){
		super(numMembre, nom, prenom,dateNaiss, sexe,categorie,adresse,numeroMaison,codePostal,ville,numTel,eMail,login,password,fonction);
	}
	

	/***
	 *  Méthode de la classe Membre
	 */
	public void updateCompte() {
		super.updateCompte();
	}
	
	public void doReservation(int idMembre,int idBalade, int nbrVelo, int nbrPers) {
		Reservation res = new Reservation(nbrVelo,nbrPers);
		res.createRes(idMembre,idBalade);
	}
	
	public LinkedList<Balade> voirMesBalades() {
		balade = new Balade();
		return balade.allBalade(getCategorie());
	}
}
