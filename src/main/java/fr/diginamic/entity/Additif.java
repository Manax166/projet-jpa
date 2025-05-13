package fr.diginamic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDITIF")
public class Additif extends Composant{
    public Additif(){}
    public Additif(String nom) {
        super(nom);
    }
}
