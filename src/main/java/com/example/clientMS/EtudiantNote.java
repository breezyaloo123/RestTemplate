package com.example.clientMS;

public class EtudiantNote {
    private int id;
    private String num_etudiant;
    private int note;
    private String nom_matiere;

    public EtudiantNote(int id, String num_etudiant, int note, String nom_matiere) {
        this.id = id;
        this.num_etudiant = num_etudiant;
        this.note = note;
        this.nom_matiere = nom_matiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_etudiant() {
        return num_etudiant;
    }

    public void setNum_etudiant(String num_etudiant) {
        this.num_etudiant = num_etudiant;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
}
