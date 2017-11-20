package be.Denis.Model;

import java.util.Date;

public abstract class Personne {
	private int numPersonne;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private String sexe;
	private String categorie;
	private int rue;
	private int codePostal;
	private String ville;
	private int numTel;
	private String eMail;
	private Date dateInscr;
	private String login;
	private String password;
	
	public Personne(int numPersonne, String nom, String prenom, Date date, String sexe){
		this.numPersonne = numPersonne;
		this.nom= nom;
		this.prenom=prenom;
		this.dateNaiss=date;
		this.sexe=sexe;		
	}
	
	public Personne(String nom, String prenom, Date dateNaiss, String sexe, String categorie, int rue, int codePostal, String ville, int numTel, String eMail, String login, String password){
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.sexe = sexe;
		this.categorie = categorie;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.numTel = numTel;
		this.eMail = eMail;
		this.login = login;
		this.password = password;
	}
	
	public Personne(String nom, String prenom){
		this.nom= nom;
		this.prenom=prenom;	
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

	public int getRue() {
		return rue;
	}

	public void setRue(int rue) {
		this.rue = rue;
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

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
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
}
