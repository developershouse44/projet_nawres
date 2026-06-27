package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Solution {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String description;
	    private int ordre; // 1..4

	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "panne_id")
	    private Panne panne;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getOrdre() {
			return ordre;
		}

		public void setOrdre(int ordre) {
			this.ordre = ordre;
		}

		public Panne getPanne() {
			return panne;
		}

		public void setPanne(Panne panne) {
			this.panne = panne;
		}
	    
	    
	    
	    
}
