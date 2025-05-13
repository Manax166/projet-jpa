package fr.diginamic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient extends Composant {

    public Ingredient() {}

    public Ingredient(String nom) {
        super(nom);
    }
}
