package Creation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import dao.GenericDAO;
import dao.ReservationDAO;
import dao.VolDAO;
import model.Reservation;
import model.Type;
import model.Vol;

public class SaisiReservation {

	public static void creationReservation(Scanner sc) {

		boolean test = false;
		System.out.println("veuillez saisir le numéro du vol au format 0001: ");
		String str = sc.nextLine();
		while (!test) {
			try {
				String noVol =str;

				Vol vol = VolDAO.findVolParNumero(noVol);

				System.out.println("veuillez saisir le Nom de famille : ");
				str = sc.nextLine();
				String nom = str;

				System.out.println("veuillez saisir le Prénom : ");
				str = sc.nextLine();
				String prenom = str;

				System.out.println("veuillez saisir l'age : ");
				str = sc.nextLine();
				int age = Integer.parseInt(str);

				Reservation res = new Reservation(nom, prenom, age, vol);
				ReservationDAO.addReservation(res);
				res.setNoReservation();

				ReservationDAO.merge(res);

				test = true;
			}

			catch (Exception e) {
				System.out.println("numéro de vol incorrect, veuillez le resaisir: ");
				str = sc.nextLine();
			}

		}

	}

	public static void afficheReservationVol(Scanner sc) {
		
		System.out.println("veuillez saisir le numéro du vol : ");
		String noVol = sc.nextLine();
		
		List<Reservation> reservations = ReservationDAO.listReservation(noVol);

		if (!reservations.isEmpty()) {
			System.out.println("Num Reservation | Nom | Prenom | Age");

			for (Reservation r : reservations) {
				System.out.println(r.toString());
			}
		}

	}

}
