package Creation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import dao.VolDAO;
import model.Type;
import model.Vol;

public class SaisiVol {

	public static void creationVol(Scanner sc) {
		System.out.println("veuillez saisir le numéro de vol au format XXXX : ");
		String str = sc.nextLine();

		boolean testNoVol = false;
		while (!testNoVol) {
			if (str.length() == 4) {
				try {
					int noVolInt = Integer.parseInt(str);
					System.out.println("numero " + str);
					String noVol = str;
					
					System.out.println("veuillez saisir le type d'avion : A330 / A340 / A380 / B747 : ");
					str = sc.nextLine();
					Type type = Type.valueOf(str);

					System.out.println("veuillez saisir le nombre de places : ");
					str = sc.nextLine();
					int nbPlaces = Integer.parseInt(str);

					System.out.println("veuillez saisir la ville de départ : ");
					str = sc.nextLine();
					String villeDepart = str;

					System.out.println("veuillez saisir la ville d'arrivée : ");
					str = sc.nextLine();
					String villeArrivee = str;

					boolean testDate = false;

					while (!testDate) {
						System.out.println("veuillez saisir la date de départ : ");
						str = sc.nextLine();

						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate dateDepart = LocalDate.parse(str, formatter);
						Vol vol = new Vol(noVol, type, nbPlaces, villeDepart, villeArrivee, dateDepart);
						VolDAO.addVol(vol);
						testDate = true;

					}
					
					testNoVol = true;

				} catch (Exception e) {
					System.out.println("catch numéro de vol incorrect, veuillez le resaisir au format XXXX :");
					str = sc.nextLine();
				}
			} else {
				System.out.println("else numéro de vol incorrect, veuillez le resaisir au format XXXX :");
				str = sc.nextLine();
			}
		}

		

	}

	public static void afficheListVols() {
		List<Vol> vols = VolDAO.listeVols();

		if (!vols.isEmpty()) {
			System.out.println("Numero | Type | Places | Départ | Arrivée | Date");

			for (Vol v : vols) {
				System.out.println(v.toString());
			}
			System.out.println("");
		}

	}
	
	public static void rechercheVolByVilles(Scanner sc) {
		System.out.println("veuillez saisir la ville de départ : ");
		String villeDepart = sc.nextLine();
		System.out.println("veuillez saisir la ville d'arrivée : ");
		String villeArrivee = sc.nextLine();
		
		List<Vol> vols = VolDAO.findByVilles(villeDepart,villeArrivee);
		System.out.println(vols.size());
		System.out.println("Numero | Type | Places | Départ | Arrivée | Date");
		for (Vol v : vols) {
			System.out.println(v.toString());
		}
		
		
	}

}
