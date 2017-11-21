package be.Denis.Model;

import be.Denis.DAO.AccesDB;
import be.Denis.Vue.VueAccueil;

public class Program {
	public static void main(String[] args) {
		AccesDB.getInstance();
		VueAccueil.init();
	}
}
