package be.Denis.DAO;

import java.sql.Connection;
import be.Denis.Model.Membre;

public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = AccesDB.getInstance();
	
	public DAO<Membre> getMembreDAO() {
		return new MembreDAO(conn);
	}
}
