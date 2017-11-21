package be.Denis.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Membre;
import be.Denis.Model.Personne;

public class MembreDAO extends DAO<Membre>{
	
	public MembreDAO(Connection conn){
		super(conn);
	}

	@Override
	public Membre find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Membre> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Membre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Membre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Membre obj) {
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
	
}
