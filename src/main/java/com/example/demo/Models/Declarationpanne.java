package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Declarationpanne {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String status;
    private int solutionActuelle; // 1..4
    private String statut; 
    private Integer solutionFinale;

    @ManyToOne
    private Panne panne;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSolutionActuelle() {
		return solutionActuelle;
	}

	public void setSolutionActuelle(int solutionActuelle) {
		this.solutionActuelle = solutionActuelle;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Integer getSolutionFinale() {
		return solutionFinale;
	}

	public void setSolutionFinale(Integer solutionFinale) {
		this.solutionFinale = solutionFinale;
	}

	public Panne getPanne() {
		return panne;
	}

	public void setPanne(Panne panne) {
		this.panne = panne;
	}
    
    
    
    }
