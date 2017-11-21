package be.Denis.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Responsable;

public class ResponsableDAO extends DAO<Responsable>{
	public ResponsableDAO(Connection conn){
		super(conn);
	}

	@Override
	public boolean create(Responsable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Responsable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Responsable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Responsable> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsable find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
