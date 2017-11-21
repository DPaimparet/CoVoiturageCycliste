package be.Denis.DAO;

import java.sql.Connection;
import java.sql.Date;
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
	 * Recherche de la personne à la création
	 */
		public Personne find(String login, String pass){
			Personne personne = null;
			try {
				PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Membre WHERE nomMembre = ? AND password = ?");
				prepare.setString (1, login);
				prepare.setString (2, pass);
				ResultSet resultat = prepare.executeQuery();
				if(resultat.next())
					personne = new Personne(resultat.getString("nomMembre"),resultat.getString("prenomMembre"),resultat.getDate("dateNaissance"),resultat.getString("sexe"),resultat.getString("categorieMembre"),resultat.getString("adresse"),resultat.getInt("numeroMaison"),resultat.getInt("codePostal"),resultat.getString("ville"),resultat.getInt("numTel"),resultat.getString("eMail"),resultat.getString("login"),resultat.getString("password"), resultat.getString("fonction"));
			}
			catch(SQLException e){
				System.out.println(e);
				System.out.println("Erreur de connection base de données");
			}
			return personne;
		}
		
	/***
	 * Création d'une nouvelle personne dans la base de données
	 */
	@Override
	public boolean create(Personne obj) {
		try{
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Membre VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
		    prepare.setString(12, obj.getLogin());
		    prepare.setString(13, obj.getPassword());
		    prepare.setString(14, obj.getFonction());
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
	public boolean delete(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
