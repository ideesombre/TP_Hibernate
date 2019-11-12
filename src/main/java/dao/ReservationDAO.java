package dao;

//import static dao.DatabaseHelper.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Reservation;
import model.Vol;

public class ReservationDAO {
	
	public ReservationDAO() {
	}
	
	public static void addReservation(Reservation reservation) {

		try {
			EntityManager em = DatabaseHelper.createEntityManager();
			DatabaseHelper.beginTx(em);
			em.persist(reservation);
			DatabaseHelper.commitTxAndClose(em);

			System.out.println("reservation ajoutée avec succès");
		}

		catch (Exception e) {
			System.out.println("erreur lors de l'ajout");
		}

	}
	
	public static void merge(Reservation res) {
		try {
			EntityManager em = DatabaseHelper.createEntityManager();
			DatabaseHelper.beginTx(em);
			em.merge(res);
			DatabaseHelper.commitTxAndClose(em);

			System.out.println("reservation ajoutée avec succès");
		}

		catch (Exception e) {
			System.out.println("erreur lors du merge");
		}
	}
	
	public static List<Reservation> listReservation(String noVol){

		EntityManager em = DatabaseHelper.createEntityManager();

		TypedQuery<Reservation> query = em.createQuery("FROM Reservation r "
				+ "INNER JOIN fetch r.vol v WHERE v.noVol=:noVol ORDER BY r.nom, r.prenom", Reservation.class);
		query.setParameter("noVol", noVol);
		List<Reservation> reservations = query.getResultList();
		em.close();
		return reservations;
		
		
	}
}
