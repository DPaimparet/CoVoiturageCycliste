package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Personne;

public class PersonneDAO extends DAO<Personne>{
	public PersonneDAO(Connection conn){
		super(conn);
	}
	
	/***
	 * Recherche de la personne � la connexion
	 */
		public Personne find(String login, String pass){
			Personne personne = null;
			try {
				String membre = "SELECT * FROM Membre WHERE login = ? AND password = ?";
				PreparedStatement prepare = connect.prepareStatement(membre);
				prepare.setString (1, login);
				prepare.setString (2, pass);
				ResultSet resultat = prepare.executeQuery();
				if(resultat.next())
					personne = new Personne(resultat.getInt("idMembre"),resultat.getString("nomMembre"),resultat.getString("prenomMembre"),resultat.getDate("dateNaissance"),resultat.getString("sexe"),resultat.getString("categorieMembre"),resultat.getString("adresse"),resultat.getInt("numeroMaison"),resultat.getInt("codePostal"),resultat.getString("ville"),resultat.getInt("numTel"),resultat.getString("eMail"),resultat.getString("login"),resultat.getString("password"), resultat.getString("fonction"));
			}
			catch(SQLException e){
				System.out.println(e);
				System.out.println("Erreur de connection base de donn�es");
			}
			return personne;
		}
		
	/***
	 * Cr�ation d'une nouvelle personne dans la base de donn�es
	 */
	@Override
	public boolean create(Personne obj) {
		try{
			String creerMembre = "INSERT INTO Membre"
					+ "(nomMembre, prenomMembre, sexe, login, password, fonction, dateInscription ) "
					+ "VALUES"+ "(?,?,?,?,?,?,now())";
			PreparedStatement prepare = connect.prepareStatement(creerMembre);
		    prepare.setString (1, obj.getNom());
		    prepare.setString (2, obj.getPrenom());
		    prepare.setString(3, obj.getSexe());
		    prepare.setString(4, obj.getLogin());
		    prepare.setString(5, obj.getPassword());
		    prepare.setString(6, obj.getFonction());
		    prepare.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return false;
		} 
		return true;
	}
	
	/***
	 * V�rifie si un compte n'existe pas d�j� avec ce login
	 * @param login
	 * @return
	 */
	public boolean compteExist(String login) {
		try {
			String membre = "SELECT login FROM Membre WHERE login = ?";
			PreparedStatement prepare = connect.prepareStatement(membre);
			prepare.setString (1, login);
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				return true;
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
		}
		return false;
	}
	
	@Override
	public boolean delete(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Personne obj) {
		try{
			String updateMembre = "UPDATE membre " 
					+ "SET "
					+ "nomMembre = ?, prenomMembre = ?,dateNaissance = ?, sexe = ?, categorieMembre = ?, adresse = ?, numeroMaison = ?, codePostal = ?, ville = ?, numTel = ?, eMail = ?, password = ?, fonction = ?"
					+ " Where idMembre = " + obj.getNumPersonne();

			PreparedStatement prepare = connect.prepareStatement(updateMembre);
		    prepare.setString (1, obj.getNom());
		    prepare.setString (2, obj.getPrenom());
		    prepare.setDate (3, obj.getDate());
		    prepare.setString(4, obj.getSexe());
		    prepare.setString(5, obj.getCategorie());
		    prepare.setString(6, obj.getAdresse());
		    prepare.setInt(7, obj.getNumeroMaison());
		    prepare.setInt(8, obj.getCodePostal());
		    prepare.setString(9, obj.getVille());
		    prepare.setLong(10, obj.getNumTel());
		    prepare.setString(11, obj.geteMail());
		    prepare.setString(12, obj.getPassword());
		    prepare.setString(13, obj.getFonction());
		    prepare.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return false;
		} 
		return true;
	}


	@Override
	public Personne find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Personne> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
