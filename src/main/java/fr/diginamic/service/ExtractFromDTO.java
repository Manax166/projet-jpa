package fr.diginamic.service;

import fr.diginamic.DTO.ProduitDTO;
import fr.diginamic.entity.*;

import java.util.List;

public class ExtractFromDTO {
    public static Produit extractProduitFromDTO(ProduitDTO produitDTO){
        return new Produit(produitDTO.getNom(), produitDTO.getNutritionGrade());
    }
    public static Marque extractMarqueFromDTO(ProduitDTO produitDTO){
        return new Marque(produitDTO.getMarque());
    }
    public static List<Teneur_Composition> extractTeneur_CompositionFromDTO(ProduitDTO produitDTO){
        return produitDTO.getListeComposition();
    }
    public static List<Ingredient> extractListeIngredientsFromDTO(ProduitDTO produitDTO){
        return produitDTO.getListeIngredient();
    }
    public static List<Allergene> extractListeAllergenesFromDTO(ProduitDTO produitDTO){
        return produitDTO.getListeAllergene();
    }
    public static List<Additif> extractListeAdditifsFromDTO(ProduitDTO produitDTO){
        return produitDTO.getListeAdditif();
    }
    public static Categorie extractCategorieFromDTO(ProduitDTO produitDTO){
        return new Categorie(produitDTO.getCategorie());
    }
}
