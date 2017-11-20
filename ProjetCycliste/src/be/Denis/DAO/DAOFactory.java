package be.Denis.DAO;

import java.sql.Connection;
import be.Denis.Model.Membre;
import be.Denis.Model.Personne;

public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = AccesDB.getInstance();
	
	public DAO<Personne> getPersonneDAO() {
		return new PersonneDAO(conn);
	}
	
	public DAO<Membre> getMembreDAO() {
		return new MembreDAO(conn);
	}
}
