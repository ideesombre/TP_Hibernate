package main;

import java.util.Scanner;

import javax.persistence.EntityManager;

import Creation.Menu;
import dao.DatabaseHelper;
import dao.GenericDAO;
import dao.VolDAO;
import model.Type;
import model.Vol;

public class Run {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Menu.lireEntree(sc);
		
//		Vol vol = VolDAO.findVolParNumero(0003);
//		System.out.println(vol.toString());
		
//		VolDAO.creationVol(sc);
		
//		String str1 = "2l35j";
		
//		if (str1.length() == 4) {
//		try {
//			int noVol = Integer.parseInt(str1);
//			System.out.println(noVol);
//			
//		} catch (Exception e) {
//				System.out.println("la valeur entree est erronee");
//		}
//		
//		}
//		else 
//			System.out.println("IF la valeur entree est erronee");

//		Vol vol = new Vol("1020", Type.A330, 5, "Montpellier", "Paris", "22/10/2019");
//		System.out.println(vol.getDateDepart());
//		
//		EntityManager em = DatabaseHelper.createEntityManager();
//		DatabaseHelper.beginTx(em);
//		
//		em.persist(vol);
//		
//		DatabaseHelper.commitTxAndClose(em);

	}

}
