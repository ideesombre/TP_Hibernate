package model;

import javax.persistence.*;
import javax.validation.constraints.*;

import dao.VolDAO;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (unique = true)
	@NotBlank
	private String noReservation;
	
	@Column
	@NotBlank
	private String nom;
	
	@Column
	@NotBlank
	private String prenom;
	
	@Column
	@NotNull
	private Integer age;
	
	@ManyToOne
	private Vol vol;
	
	public Reservation() {
		
	}

	public Reservation(String nom, String prenom, Integer age, Vol vol) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.vol = vol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoReservation() {
		return noReservation;
	}

	public void setNoReservation() {
		this.noReservation = vol.getNoVol()+"-"+this.id.toString();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	public String toString() {
		return noReservation + " | " + nom + " | " + prenom + " | "
				+ age;
	}

}
