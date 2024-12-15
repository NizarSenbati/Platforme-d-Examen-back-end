package com.application.exam.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ModuleElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToMany(mappedBy = "modules")
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "module")
    private List<Exam> exams;

    // Default Constructor
    public ModuleElement() {}

    // Parameterized Constructor
    public ModuleElement(String nom, Professeur professeur, List<Etudiant> etudiant) {
        this.nom = nom;
        this.professeur = professeur;
        this.etudiants = etudiant;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public List<Etudiant> getEtudiant() {
        return etudiants;
    }

    public void setEtudiant(List<Etudiant> etudiant) {
        this.etudiants = etudiant;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", professeur=" + professeur +
                ", etudiant=" + etudiants +
                '}';
    }
}
