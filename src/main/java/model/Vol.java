package model;

import java.text.*;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import dao.VolDAO;

@Entity
public class Vol {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column  (unique = true)
	@NotBlank 
	private String noVol;
	
	@Column
	@Enumerated(EnumType.STRING)
	@NotBlank
	private Type type;
	
	@Column
	@NotNull
	private int nbPlaces;
	
	@Column
	@NotBlank
	private String villeDepart;
	
	@Column
	@NotBlank
	private String villeArrivee;
	
	@Column
	@NotNull
	private LocalDate dateDepart;
	
	@OneToMany (mappedBy = "vol")
	private List<Reservation> reservations;
	
	
	public Vol() {
		
	}

	public Vol(String noVol, Type type, int nbPlaces, String villeDepart, String villeArrivee, LocalDate dateDepart) {
		this.noVol = noVol;
		this.type = type;
		this.nbPlaces = nbPlaces;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.dateDepart = dateDepart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoVol() {
		return noVol;
	}

	public void setNoVol(String noVol) {
		this.noVol = noVol;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlace) {
		this.nbPlaces = nbPlace;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public String toString() {
		int count = VolDAO.countPlaces(this);
		return noVol + " | " + type + " | " +count+ "/"+ nbPlaces + " | "
				+ villeDepart + " | " +villeArrivee + " | " + dateDepart;
	}
	
	
	
}
