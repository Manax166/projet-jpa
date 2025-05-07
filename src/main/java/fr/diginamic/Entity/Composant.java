package fr.diginamic.Entity;

public class Composant {
    private int id;
    private String nom;

    public Composant(String nom) {
        this.nom = nom;
    }

    public Composant(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
