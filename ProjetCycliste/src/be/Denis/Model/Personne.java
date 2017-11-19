package be.Denis.Model;

import java.util.Date;

public class Personne {
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private String sexe;

	
	public Personne(String nom, String prenom, Date date, String sexe){
		this.nom= nom;
		this.prenom=prenom;
		this.dateNaiss=date;
		this.sexe=sexe;		
	}
	
	public Personne(String nom, String prenom){
		this.nom= nom;
		this.prenom=prenom;	
	}
	
	public Personne(){
		
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
}
