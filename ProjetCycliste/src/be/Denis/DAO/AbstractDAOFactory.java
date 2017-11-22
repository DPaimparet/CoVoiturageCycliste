package be.Denis.DAO;

import be.Denis.Model.*;

public abstract class AbstractDAOFactory {

	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Membre> getMembreDAO();
	public abstract DAO<Personne> getPersonneDAO();
	public abstract DAO<Responsable> getResponsableDAO();
	public abstract DAO<Balade> getBaladeDAO();
	public abstract DAO<Reservation> getReservationDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
			case DAO_FACTORY: return new DAOFactory();
			default: return null;
		}
	}

}
