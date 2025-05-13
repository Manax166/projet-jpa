package fr.diginamic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALLERGENE")
public class Allergene extends Composant {
    public Allergene(){}
    public Allergene(String nom) {
        super(nom);
    }
}
