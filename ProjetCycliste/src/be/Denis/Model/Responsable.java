package be.Denis.Model;

import java.sql.Date;
import java.util.LinkedList;

import be.Denis.Model.Balade;

public class Responsable extends Personne {
	private Balade balade;
	
	public Responsable(int numResponsable, String nom, String prenom, Date dateNaiss, String sexe, String categorie,String adresse, int numeroMaison, int codePostal, String ville, long numTel, String eMail, String login, String password, String fonction){
		super(numResponsable, nom,prenom,dateNaiss, sexe,categorie,adresse,numeroMaison,codePostal,ville,numTel,eMail,login,password,fonction);
	}
	
	public void updateCompte() {
		super.updateCompte();
	}
	
	public void creer(String categorieB, Date dateB, String titreB, String descriptionB, int prixTrajet) {
		balade = new Balade(categorieB, dateB, titreB, descriptionB, prixTrajet);
		balade.creeBalade(getNumPersonne());
	}
	public LinkedList<Balade> voirMesBalades() {
		balade = new Balade();
		return balade.allBalade(getNumPersonne());
	}
	
}
