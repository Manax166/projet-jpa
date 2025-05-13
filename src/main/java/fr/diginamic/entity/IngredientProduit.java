package fr.diginamic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INGREDIENTPRODUIT")
public class IngredientProduit {
    @Id
    @Column(name = "ingredient_id")
    private int ingredientId;
    @Id
    @Column(name = "produit_id")
    private int produitId;

    public IngredientProduit(int ingredientId, int produitId) {
        this.ingredientId = ingredientId;
        this.produitId = produitId;
    }
    public IngredientProduit(){}

    public int getIngredientId() {
        return ingredientId;
    }

    public int getProduitId() {
        return produitId;
    }
}
