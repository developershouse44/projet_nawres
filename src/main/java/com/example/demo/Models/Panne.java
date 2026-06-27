package com.example.demo.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Panne {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String titre;
    private String description;
    private String status;
    private String datedecreation;
    
    @JsonIgnore
    @OneToMany(mappedBy = "panne", cascade = CascadeType.ALL)
    private List<Solution> solutions;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;

    //getter&setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDatedecreation() {
		return datedecreation;
	}
	public void setDatedecreation(String datedecreation) {
		this.datedecreation = datedecreation;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
