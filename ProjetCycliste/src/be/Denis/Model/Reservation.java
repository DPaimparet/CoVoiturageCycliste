package be.Denis.Model;

public class Reservation {
	private int idReservation;
	private int nbrVelo;
	private int nbrPerso;
	
	public Reservation() {
		
	}
	
	public Reservation(int idReservation, int nbrVelo, int nbrPerso) {
		this.setIdReservation(idReservation);
		this.setNbrVelo(nbrVelo);
		this.setNbrPerso(nbrPerso);
	}
	
	public Reservation(int nbrVelo, int nbrPerso) {
		this.setNbrVelo(nbrVelo);
		this.setNbrPerso(nbrPerso);
	}
	
	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public int getNbrVelo() {
		return nbrVelo;
	}

	public void setNbrVelo(int nbrVelo) {
		this.nbrVelo = nbrVelo;
	}

	public int getNbrPerso() {
		return nbrPerso;
	}

	public void setNbrPerso(int nbrPerso) {
		this.nbrPerso = nbrPerso;
	}
	
	
	public void createRes(int idMembre, int idBalade) {
		
	}

}
