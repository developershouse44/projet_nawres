package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Quittance {
@Id 

@GeneratedValue(strategy = GenerationType.IDENTITY)

private long id;
private String nom;
private String matricule;
private String date;
private String quntite;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getQuntite() {
	return quntite;
}
public void setQuntite(String quntite) {
	this.quntite = quntite;
}



}
