package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Balade;


public class BaladeDAO extends DAO<Balade> {

	public BaladeDAO(Connection conn){
		super(conn);
	}

	@Override
	public boolean create(Balade obj, int numResponsable) {
		try{
			//String categorieB, Date dateB, String titreB, String descriptionB, int prixTrajet
			String creerBalade = "INSERT INTO Balade"
					+ "(categorieBalade, dateBalade, titre, description, prixTrajet ) "
					+ "VALUES"+ "(?,?,?,?,?)";
			PreparedStatement prepare = connect.prepareStatement(creerBalade);
		    prepare.setString (1, obj.getCategorieB());
		    prepare.setDate (2, obj.getDateB());
		    prepare.setString(3, obj.getTitreB());
		    prepare.setString(4, obj.getDesciptionB());
		    prepare.setInt(5, obj.getPrixTrajet());
		    prepare.executeUpdate();
		    
		    ResultSet id = prepare.getGeneratedKeys();
		    id.next();
		    
		    String creerLigneDetailBalade = "INSERT INTO creeBalade"
		    		+ "(idMembre, idBalade, dateCreation)"
		    		+ "VALUES" + "(?,?,now())";
		    PreparedStatement prepare2 = connect.prepareStatement(creerLigneDetailBalade);
		    prepare2.setInt(1, numResponsable);
		    prepare2.setInt(2, id.getInt(1));
		    prepare2.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return false;
		} 
		return true;
	}

	@Override
	public boolean delete(Balade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Balade obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Balade find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Balade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Balade> findAll(int id) {
		LinkedList<Balade> listBalade = new LinkedList<Balade>();
		try {
			String balade = "SELECT * FROM Balade B INNER JOIN CreeBalade C ON B.idBalade = C.idBalade WHERE idMembre = ?" ;
			PreparedStatement prepare = connect.prepareStatement(balade);
			prepare.setInt (1, id);
			ResultSet resultat = prepare.executeQuery();
			while(resultat.next())
				listBalade.add(new Balade(resultat.getString("idBalade"),resultat.getDate("dateBalade"),resultat.getString("titre"),resultat.getString("description"), resultat.getInt("prixTrajet")));
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return listBalade;
	}
	
	public LinkedList<Balade> findAllBalade(String categorie) {
		LinkedList<Balade> listBalade = new LinkedList<Balade>();
		try {
			String balade = "SELECT * FROM Balade WHERE categorieBalade = ?" ;
			PreparedStatement prepare = connect.prepareStatement(balade);
			prepare.setString (1, categorie);
			ResultSet resultat = prepare.executeQuery();
			while(resultat.next())
				listBalade.add(new Balade(resultat.getString("idBalade"),resultat.getDate("dateBalade"),resultat.getString("titre"),resultat.getString("description"), resultat.getInt("prixTrajet")));
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return listBalade;
	}

	
}
