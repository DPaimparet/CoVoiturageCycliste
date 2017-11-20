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
		// TODO Auto-generated method stub
		return false;
	}
	
}
