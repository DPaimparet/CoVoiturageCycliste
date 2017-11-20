package be.Denis.Model;

import java.util.Date;
import java.sql.SQLException;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.MembreDAO;
import be.Denis.DAO.DAO;

import be.Denis.Vue.VueMembre;

public class Membre extends Personne {
	
	
	public Membre(String nom, String prenom, Date dateNaiss, String sexe, String categorie, int rue, int codePostal, String ville, int numTel, String eMail, String login, String password){
		super(nom,prenom,dateNaiss, sexe,categorie,rue,codePostal,ville,numTel,eMail,login,password);
	}
	
	public Membre(String login, String password){
		super(login,password);
	}

	/***
	 *  Méthode de la classe Membre
	 */
	
	public Boolean connexion() throws ClassNotFoundException, SQLException {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Membre> clientDAO = adf.getMembreDAO();
		Membre m = MembreDAO.find(login,password);
		if(m!=null)
		{
			VueMembre.init(m);		
			return true;
		}
		else return false;
	}
}
