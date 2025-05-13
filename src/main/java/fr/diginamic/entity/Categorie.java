package fr.diginamic.entity;

import jakarta.persistence.*;

@Entity
public class Categorie {
    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 1,
            initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "categorie_id")
    int id;
    String nom;

    public Categorie() {
    }

    public Categorie(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return this.id;
    }
}
