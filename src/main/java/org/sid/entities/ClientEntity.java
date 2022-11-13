package org.sid.entities;

import java.io.Serializable;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Data;
@Entity
@Data
public class ClientEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private  LocalDate dateDeNaissance;
	
	//@Column(unique = true)
	private String courriel;
	private String telephone;
	
	@OneToMany(mappedBy="client")
	private List<TicketEntity>tickets;
	
	
	
	
	
	public String getNomComplet() {
		return nom+" "+prenom;
	}
	public int getAge() {
		return (int) ChronoUnit.YEARS.between(getDateDeNaissance(),LocalDate.now());
	}
}
