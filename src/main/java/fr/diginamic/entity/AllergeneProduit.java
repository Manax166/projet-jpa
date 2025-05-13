package fr.diginamic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALLERGENEPRODUIT")
public class AllergeneProduit {
    @Id
    @Column(name = "allergene_id")
    private int allergeneId;
    @Id
    @Column(name = "produit_id")
    private int produitId;

    public AllergeneProduit(int allergeneId, int produitId) {
        this.allergeneId = allergeneId;
        this.produitId = produitId;
    }
    public AllergeneProduit(){}

    public int getAllergeneId() {
        return allergeneId;
    }

    public int getProduitId() {
        return produitId;
    }
}
