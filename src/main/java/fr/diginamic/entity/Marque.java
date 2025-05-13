package fr.diginamic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MARQUE")
public class Marque {
    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 1,
            initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "marque_id")
    private int id;
    private String nom;

    public Marque(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    public Marque(String nom){
        this.nom = nom;
    }
    public Marque(){}

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
