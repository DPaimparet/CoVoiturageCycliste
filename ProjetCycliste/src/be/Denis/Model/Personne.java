package be.Denis.Model;

import java.sql.SQLException;
import java.sql.Date;
import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;
import be.Denis.Vue.VueMembre;
import be.Denis.Vue.VueResponsable;
import be.Denis.Vue.VueTresorier;;

public class Personne {
	private int numPersonne;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private String sexe;
	private String categorie;
	private String adresse;
	private int numeroMaison;
	private int codePostal;
	private String ville;
	private long numTel;
	private String eMail;
	private Date dateInscr;
	private String login;
	private String password;
	private String fonction;
	
	
	/***
	 * Constructeur servant lors de la cr�ation d'une personne lors de la connexion
	 * @param numPersonne
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 * @param sexe
	 * @param categorie
	 * @param adresse
	 * @param numeroMaison
	 * @param codePostal
	 * @param ville
	 * @param numTel
	 * @param eMail
	 * @param login
	 * @param password
	 * @param fonction
	 */
	public Personne(int numPersonne, String nom, String prenom, Date dateNaiss, String sexe, String categorie, String adresse,int numeroMaison, int codePostal, String ville, long numTel, String eMail, String login, String password, String fonction){
		this.numPersonne = numPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.sexe = sexe;
		this.categorie = categorie;
		this.adresse = adresse;
		this.numeroMaison = numeroMaison;
		this.codePostal = codePostal;
		this.ville = ville;
		this.numTel = numTel;
		this.eMail = eMail;
		this.login = login;
		this.password = password;
		this.fonction = fonction;
	}

	/***
	 * Constructeur servant � la cr�ation d'un compte membre sur la DB
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param login
	 * @param password
	 * @param fonction
	 */
	public Personne (String nom, String prenom,String sexe,String login,String password,String fonction) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.login = login;
		this.password = password;
		this.fonction = fonction;
	}
	
	/***
	 * 
	 * @param login
	 * @param password
	 */
	public Personne(String login, String password){
		this.login= login;
		this.password=password;	
	}
	public Personne(){
		
	}
	
	public int getNumPersonne(){
		return numPersonne;
	}
	
	public String getNom(){
		return nom;
	}
	
	
	public String getPrenom(){
		return prenom;
	}
	
	
	public Date getDate(){	
		return dateNaiss;
	}
	
	
	public Date getNormalDate(){	
		return dateNaiss;
	}
	
	public String getSexe(){
		return sexe;
	}
	
	
	public void setNom(String n){
		nom=n;		
	}
	
	
	public void setPrenom(String n){
		prenom=n;		
	}
	
	
	public void setDate(Date d){
		dateNaiss=d;		
	}
	
	
	public void setSexe(String s){
		sexe=s;		
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getNumeroMaison() {
		return numeroMaison;
	}

	public void setNumeroMaison(int numeroMaison) {
		this.numeroMaison = numeroMaison;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public long getNumTel() {
		return numTel;
	}

	public void setNumTel(long numTel) {
		this.numTel = numTel;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getDateInscr() {
		return dateInscr;
	}

	public void setDateInscr(Date dateInscr) {
		this.dateInscr = dateInscr;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	///////////////////////////////////// M�thode de la classe Personne ////////////////////////////////////////////////
	
	/***
	 * M�thode de connexion qui permet de retourner l'utilisateur vers sa vue si il est pr�sent dans la base de donn�es
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Boolean connexion() throws ClassNotFoundException, SQLException {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Personne> PersonneDAO = adf.getPersonneDAO();
		Personne p = PersonneDAO.find(getLogin(),getPassword());
		if(p!=null)
		{
			// si membre categorie = responsable appel vue responsable
			if(p.fonction.equals("Responsable")) {
				Responsable r = new Responsable(p.numPersonne, p.nom,p.prenom,(java.sql.Date) p.dateNaiss,p.sexe,p.categorie,p.adresse,p.numeroMaison,p.codePostal,p.ville,p.numTel,p.eMail,p.login,p.password,p.fonction);
				VueResponsable.init(r);
				return true;
			}
			// sinon si categorie = tresorier appel vue tresorier
			else if(p.fonction.equals("Tresorier")) {
				Tresorier t = new Tresorier(p.numPersonne, p.nom,p.prenom,(java.sql.Date) p.dateNaiss,p.sexe,p.categorie,p.adresse,p.numeroMaison,p.codePostal,p.ville,p.numTel,p.eMail,p.login,p.password,p.fonction);
				VueTresorier.init(t);
				return true;
			}
			// sinon appel vue membre
			else {
				Membre m = new Membre(p.numPersonne,p.nom,p.prenom,(java.sql.Date) p.dateNaiss,p.sexe,p.categorie,p.adresse,p.numeroMaison,p.codePostal,p.ville,p.numTel,p.eMail,p.login,p.password,p.fonction);
				VueMembre.init(m);		
				return true;
			}
		}
		else return false;
	}
	
	/***
	 * M�thode qui permet d'inscrire une personne dans la base de donn�e
	 */
	public void inscription() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Personne> PersonneDAO = adf.getPersonneDAO();
		PersonneDAO.create(this);
	}
	
	/***
	 * M�thode qui permet de v�rifier si un compte existe d�j� avec ce login
	 */
	public boolean exist(String login) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Personne> PersonneDAO = adf.getPersonneDAO();
		boolean e = PersonneDAO.compteExist(login);
		return e;
	}
	
	/***
	 * M�thode update
	 */
	public void updateCompte() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Personne> PersonneDAO = adf.getPersonneDAO();
		PersonneDAO.update(this);
	}
}
