package fr.diginamic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDITIFPRODUIT")
public class AdditifProduit {
    @Id
    @Column(name = "additif_id")
    private int additifId;
    @Id
    @Column(name = "produit_id")
    private int produitId;

    public AdditifProduit(int additifId, int produitId) {
        this.additifId = additifId;
        this.produitId = produitId;
    }

    public int getAdditifId() {
        return additifId;
    }

    public int getProduitId() {
        return produitId;
    }
}
