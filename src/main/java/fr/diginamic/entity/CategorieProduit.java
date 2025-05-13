package fr.diginamic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIEPRODUIT")
public class CategorieProduit {
    @Id
    @Column(name = "categorie_id")
    private int categorieId;
    @Id
    @Column(name = "produit_id")
    private int produitId;

    public CategorieProduit(int marqueId, int produitId) {
        this.categorieId = marqueId;
        this.produitId = produitId;
    }
    public CategorieProduit(){}

    public int getCategorieId() {
        return categorieId;
    }

    public int getProduitId() {
        return produitId;
    }
}
