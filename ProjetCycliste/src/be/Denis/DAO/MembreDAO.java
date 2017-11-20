package be.Denis.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Membre;

public class MembreDAO extends DAO<Membre>{
	
	public MembreDAO(Connection conn){
		super(conn);
	}

	// Recherche du membre à la connexion
	public Membre find(String login, String pass){
		Membre membre = null;
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Membre WHERE nomMembre = ? AND password = ?");
			prepare.setString (1, login);
			prepare.setString (2, pass);
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				membre = new Membre(resultat.getString("nomMembre"),resultat.getString("prenomMembre"),resultat.getDate("dateNaissance"),resultat.getString("sexe"),resultat.getString("categorieMembre"),resultat.getInt("rue"),resultat.getInt("codePostal"),resultat.getString("ville"),resultat.getInt("numTel"),resultat.getString("eMail"),resultat.getString("login"),resultat.getString("password"));
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return membre;
	}

	@Override
	public LinkedList<Membre> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Membre obj) {
		try{
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Membre VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)");
		    prepare.setString (1, obj.getNom());
		    prepare.setString (2, obj.getPrenom());
		    prepare.setDate (3, (Date) obj.getDate());
		    prepare.setString(4, obj.getSexe());
		    prepare.setString(5, obj.getCategorie());
		    prepare.setInt(6, obj.getRue());
		    prepare.setInt(7, obj.getCodePostal());
		    prepare.setString(8, obj.getVille());
		    prepare.setInt(9, obj.getNumTel());
		    prepare.setString(10, obj.geteMail());
		    prepare.setString(11, obj.getLogin());
		    prepare.setString(12, obj.getPassword());
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
	public boolean delete(Membre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Membre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Membre find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
