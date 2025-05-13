package fr.diginamic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MARQUEPRODUIT")
public class MarqueProduit {
    @Id
    @Column(name = "marque_id")
    private int marqueId;
    @Id
    @Column(name = "produit_id")
    private int produitId;

    public MarqueProduit(int marqueId, int produitId) {
        this.marqueId = marqueId;
        this.produitId = produitId;
    }

    public MarqueProduit() {
    }

    public int getMarqueId() {
        return marqueId;
    }

    public int getProduitId() {
        return produitId;
    }
}
