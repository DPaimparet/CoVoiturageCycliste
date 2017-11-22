package be.Denis.Model;

import java.sql.Date;
import java.util.LinkedList;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;

public class Balade {
	private int numB;
	private String categorieB;
	private Date dateB;
	private String titreB;
	private String desciptionB;
	private int nbrVoiturDispo;
	private int prixTrajet;
	private int nbrReservation;
	private LinkedList<Balade> listBalade;

	////////////////////////////////////// Constructeur    //////////////////////////////////////
	public Balade() {}
	
	public Balade(int numB, String categorieB, Date dateB, String titreB, String descriptionB, int nbrVoitureDispo, int prixTrajet, int nbrReservation) {
		this.numB = numB;
		this.categorieB = categorieB;
		this.dateB = dateB;
		this.titreB = titreB;
		this.desciptionB = descriptionB;
		this.nbrVoiturDispo = nbrVoitureDispo;
		this.prixTrajet = prixTrajet;
		this.nbrReservation = nbrReservation;
	}
	
	public Balade(String categorieB, Date dateB, String titreB, String descriptionB, int prixTrajet) {
		this.categorieB = categorieB;
		this.dateB = dateB;
		this.titreB = titreB;
		this.desciptionB = descriptionB;
		this.prixTrajet = prixTrajet;
	}
	////////////////////////////////////// Getter & Setter //////////////////////////////////////
	public int getNumB() {
		return numB;
	}
	public void setNumB(int numB) {
		this.numB = numB;
	}
	public String getCategorieB() {
		return categorieB;
	}
	public void setCategorieB(String categorieB) {
		this.categorieB = categorieB;
	}
	public Date getDateB() {
		return dateB;
	}
	public void setDateB(Date dateB) {
		this.dateB = dateB;
	}
	public String getTitreB() {
		return titreB;
	}
	public void setTitreB(String titreB) {
		this.titreB = titreB;
	}
	public String getDesciptionB() {
		return desciptionB;
	}
	public void setDesciptionB(String desciptionB) {
		this.desciptionB = desciptionB;
	}
	public int getNbrVoiturDispo() {
		return nbrVoiturDispo;
	}
	public void setNbrVoiturDispo(int nbrVoiturDispo) {
		this.nbrVoiturDispo = nbrVoiturDispo;
	}
	public int getPrixTrajet() {
		return prixTrajet;
	}
	public void setPrixTrajet(int prixTrajet) {
		this.prixTrajet = prixTrajet;
	}
	public int getNbrReservation() {
		return nbrReservation;
	}
	public void setNbrReservation(int nbrReservation) {
		this.nbrReservation = nbrReservation;
	}
	public LinkedList<Balade> getListBalade() {
		return listBalade;
	}

	public void setListBalade(LinkedList<Balade> listBalade) {
		this.listBalade = listBalade;
	}
	////////////////////////////////////// Méthode de la classe Balade //////////////////////////////////////

	public void creeBalade(int numPersonne) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Balade> BaladeDAO = adf.getBaladeDAO();
		BaladeDAO.create(this, numPersonne);
	}
	
	public LinkedList<Balade> allBalade(int numPersonne) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Balade> BaladeDAO = adf.getBaladeDAO();
		return BaladeDAO.findAll(numPersonne);
	}
	
	public LinkedList<Balade> allBalade(String categorie) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Balade> BaladeDAO = adf.getBaladeDAO();
		return BaladeDAO.findAllBalade(categorie);
	}

	
}
