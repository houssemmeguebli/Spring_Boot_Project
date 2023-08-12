package com.stage.stage;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="formulaire")
public class Formulaire {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="message")
	private String message;
	@Column(name="option")
	private String option;
	 @ElementCollection
	    @CollectionTable(name = "formulaire_choix_multiples", joinColumns = @JoinColumn(name = "formulaire_id"))
	    @Column(name = "choix")
    private List<String> choix_multiple;
    public Formulaire() {
    	
    }

	

	public Formulaire(int id, String nom, String prenom, String message, String option, List<String> choix_multiple) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.message = message;
		this.option = option;
		this.choix_multiple = choix_multiple;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}


	public List<String> getChoix_multiple() {
		return choix_multiple;
	}

	public void setChoix_multiple(List<String> choix_multiple) {
		this.choix_multiple = choix_multiple;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	

}
