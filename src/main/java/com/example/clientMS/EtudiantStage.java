package com.example.clientMS;

public class EtudiantStage {
    private int id;
    private String num_etudiant;
    private String prenom;
    private String nom;
    private String nom_entreprise;

    public EtudiantStage(int id, String num_etudiant, String prenom, String nom, String nom_entreprise) {
        this.id = id;
        this.num_etudiant = num_etudiant;
        this.prenom = prenom;
        this.nom = nom;
        this.nom_entreprise = nom_entreprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum_etudiant() {
        return num_etudiant;
    }

    public void setNum_etudiant(String num_etudiant) {
        this.num_etudiant = num_etudiant;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }
}
