package fr.diginamic.entity;

import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public class Composant {
    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 1,
            initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nom;

    public Composant(String nom) {
        this.nom = nom;
    }

    public Composant(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Composant() {

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
