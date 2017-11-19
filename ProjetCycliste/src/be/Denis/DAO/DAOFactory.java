package be.Denis.DAO;

import java.sql.Connection;

public abstract class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = AccesDB.getInstance();
}
