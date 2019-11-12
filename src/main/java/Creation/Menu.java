package Creation;

import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.VolDAO;
import model.Type;
import model.Vol;

public class Menu {

	public static String afficherMenuPrincipal(Scanner sc) {

		System.out.println("1) Gestion des vols \n2) Gestion des réservations \n3) Quitter");

		return sc.nextLine();

	}

	public static void lireEntree(Scanner sc) {

		String str = afficherMenuPrincipal(sc);
		switch (str) {

		case "1": {
			System.out.println("Vous avez choisi 'Gestion des vols'");
			menu1(sc);
			break;
		}

		case "2": {
			System.out.println("Vous avez choisi 'Gestion des réservations'");
			menu2(sc);
			break;
		}

		case "3": {
			System.out.println("Vous avez choisi 'Quitter'");
			break;
		}

		default: {
			System.out.println("saisie non valide, retour au menu");
			lireEntree(sc);
		}
		}
	}

	public static String afficherMenu1(Scanner sc) {

		System.out.println("1) Creation d'un vol \n2) Liste des vols \n" + "3) Rechercher un avion par numéro \n"
				+ "4) Rechercher un avion par ville de départ et d'arrivée\n"
				+ "5) Retour au menu principal");

		return sc.nextLine();

	}

	public static void menu1(Scanner sc) {
		String str = afficherMenu1(sc);

		switch (str) {

		case "1": {
			System.out.println("Vous avez choisi 'Creation d'un vol'");
			SaisiVol.creationVol(sc);
			menu1(sc);
			break;
		}

		case "2": {
			System.out.println("Vous avez choisi 'Liste des vols'");
			SaisiVol.afficheListVols();
			menu1(sc);
			break;
		}

		case "3": {
			System.out.println("Vous avez choisi 'Rechercher un avion par numéro'");
			
			break;
		}

		case "4": {
			System.out.println("Vous avez choisi 'Rechercher un avion par ville de départ et d'arrivée'");
			SaisiVol.rechercheVolByVilles(sc);
			menu1(sc);
			break;
		}

		case "5": {
			System.out.println("Vous avez choisi 'Retour au menu principal'");
			lireEntree(sc);
			break;
		}

		default: {
			System.out.println("saisie non valide, retour au menu");
			break;
		}
		}

	}

	public static String afficherMenu2(Scanner sc) {

		System.out.println(
				"1) Créer une réservation \n2) Voir les réservations d'un vol \n" + "3) Annuler une réservation \n"
						+ "4) Voir toutes les réservations d'une personne\n" + "5) Retour au menu principal");

		return sc.nextLine();

	}

	public static void menu2(Scanner sc) {
		String str = afficherMenu2(sc);

		switch (str) {

		case "1": {
			System.out.println("Vous avez choisi 'Créer une réservation'");
			SaisiReservation.creationReservation(sc);
			menu2(sc);
			break;
		}

		case "2": {
			System.out.println("Vous avez choisi 'Voir les réservations d'un vol'");
			SaisiReservation.afficheReservationVol(sc);
			menu2(sc);
			break;
		}

		case "3": {
			System.out.println("Vous avez choisi 'Annuler une réservation'");
			break;
		}

		case "4": {
			System.out.println("Vous avez choisi 'Voir toutes les réservations d'une personne'");
			break;
		}

		case "5": {
			System.out.println("Vous avez choisi 'Retour au menu principal'");
			lireEntree(sc);
			break;
		}

		default: {
			System.out.println("saisie non valide, retour au menu");
			menu2(sc);
		}
		}

	}

}
