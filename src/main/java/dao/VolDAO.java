package dao;

import model.*;
import Creation.Menu;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.metamodel.model.domain.spi.SetPersistentAttribute;

public class VolDAO extends GenericDAO<Vol> {

	public VolDAO() {
		super(Vol.class);
	}

	public static Vol findVolParNumero(String noVol) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		TypedQuery<Vol> query = em.createQuery("FROM Vol v WHERE v.noVol=:noVol", Vol.class);
		query.setParameter("noVol", noVol);
		Vol vol = query.getSingleResult();

		DatabaseHelper.commitTxAndClose(em);

		return vol;

	}

	public static void addVol(Vol vol) {

		try {
			EntityManager em = DatabaseHelper.createEntityManager();
			DatabaseHelper.beginTx(em);
			em.persist(vol);
			DatabaseHelper.commitTxAndClose(em);

			System.out.println("Vol ajouté avec succès");
		}

		catch (Exception e) {
			System.out.println("erreur lors de l'ajout");
		}

	}

	public static List<Vol> listeVols() {

		EntityManager em = DatabaseHelper.createEntityManager();

		TypedQuery<Vol> query = em.createQuery("FROM Vol v ORDER BY v.dateDepart", Vol.class);
		List<Vol> vols = query.getResultList();

		em.close();
		return vols;

	}

	public static int countPlaces(Vol vol) {

		EntityManager em = DatabaseHelper.createEntityManager();

		TypedQuery<Reservation> query = em.createQuery(
				"SELECT r FROM Reservation r " + "INNER JOIN fetch r.vol v WHERE v.id=:id", Reservation.class);
		query.setParameter("id", vol.getId());
		List<Reservation> reservations = query.getResultList();
		int nbPlacesOccupees = reservations.size();

		em.close();
		return nbPlacesOccupees;

	}

	public static List<Vol> findByVilles(String depart, String arrivee) {
		EntityManager em = DatabaseHelper.createEntityManager();

		TypedQuery<Vol> query = em.createQuery(
				"SELECT v FROM Vol v WHERE v.villeDepart=:depart AND v.villeArrivee=:arrivee", Vol.class);
		query.setParameter("depart", depart);
		query.setParameter("arrivee", arrivee);
		List<Vol> vols = query.getResultList();

		em.close();
		return vols;
		
		
	}
}
