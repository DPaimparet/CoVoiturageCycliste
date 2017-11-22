package be.Denis.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Reservation;

public class ReservationDAO extends DAO<Reservation>{
	public ReservationDAO(Connection conn){
		super(conn);
	}

	@Override
	public boolean create(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Reservation> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
