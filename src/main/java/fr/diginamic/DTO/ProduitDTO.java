package fr.diginamic.DTO;

import fr.diginamic.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ProduitDTO {
    private int produitId;
    private String categorie;
    private String marque;
    private List<Ingredient> listeIngredient = new ArrayList<>();
    private String nom;
    private String nutritionGrade;
    private List<Teneur_Composition> listeComposition = new ArrayList<>();
    private List<Additif> listeAdditif = new ArrayList<>();
    private List<Allergene> listeAllergene = new ArrayList<>();

    public int getProduitId() {
        return produitId;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public List<Ingredient> getListeIngredient() {
        return listeIngredient;
    }

    public void addToListeIngredient(Ingredient ingredient) {
        this.listeIngredient.add(ingredient);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNutritionGrade() {
        return nutritionGrade;
    }

    public void setNutritionGrade(String nutritionGrade) {
        this.nutritionGrade = nutritionGrade;
    }

    public List<Teneur_Composition> getListeComposition() {
        return listeComposition;
    }

    public void addToListeComposition(Teneur_Composition composition) {
        this.listeComposition.add(composition);
    }

    public List<Additif> getListeAdditif() {
        return listeAdditif;
    }

    public void addToListeAdditif(Additif additif) {
        this.listeAdditif.add(additif);
    }

    public List<Allergene> getListeAllergene() {
        return listeAllergene;
    }

    public void addToListeAllergene(Allergene allergene) {
        this.listeAllergene.add(allergene);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProduitDTO{");
        sb.append("produitId=").append(produitId);
        sb.append(", categorie='").append(categorie).append('\'');
        sb.append(", marque='").append(marque).append('\'');
        sb.append(", listeIngredient=");
        for(Composant ingredient :listeIngredient){
            sb.append(ingredient.getNom());
        }
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", nutritionGrade='").append(nutritionGrade).append('\'');
        sb.append(", listeComposition=");
        for(Teneur_Composition teneur : listeComposition){
            sb.append(teneur.getType() + "|" + teneur.getValeurPour100g());
        }
        sb.append(", listeAdditif=").append(listeAdditif);
        sb.append(", listeAllergene=").append(listeAllergene);
        sb.append('}');
        return sb.toString();
    }
}
