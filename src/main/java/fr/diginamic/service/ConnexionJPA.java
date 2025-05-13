package fr.diginamic.service;

import fr.diginamic.DAO.*;
import fr.diginamic.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ConnexionJPA {
    public static void addMultipleAllergene(List<Allergene> allergenes){
        for(Allergene Allergene : allergenes){
            addAllergene(Allergene);
        }
    }
    public static void addMultipleAdditif(List<Additif> additifs){
        for(Additif Additif : additifs){
            addAdditif(Additif);
        }
    }
    public static void addMultipleIngredient(List<Ingredient> ingredients){
        for(Ingredient ingredient : ingredients){
            addIngredient(ingredient);
        }
    }
    public static void addIngredient(Ingredient c){
        IngredientDAO ingredientDAO = new IngredientDAO();
        if (ingredientDAO.doesntExist(c)) {
            ingredientDAO.create(c);
        }
    }
    public static void addAllergene(Allergene c){
        AllergeneDAO allergeneDAO = new AllergeneDAO();
        if (allergeneDAO.doesntExist(c)) {
            allergeneDAO.create(c);
        }
    }
    public static void addAdditif(Additif c){
        AdditifDAO additifDAO = new AdditifDAO();
        if (additifDAO.doesntExist(c)) {
            additifDAO.create(c);
        }
    }
    public static void addMarque(Marque m){
        MarqueDAO marqueDAO = new MarqueDAO();
        if(marqueDAO.doesntExist(m)) marqueDAO.save(m);
    }
    public static void addCategorie(Categorie c){
        CategorieDAO categorieDAO = new CategorieDAO();
        if(categorieDAO.doesntExist(c)) categorieDAO.save(c);
    }
    public static void addProduit(Produit p){
        ProduitDAO produitDAO = new ProduitDAO();
        if(produitDAO.doesntExist(p)) produitDAO.save(p);
    }
    public static void addTeneurComposition(Teneur_Composition p){
        Teneur_CompositionDAO teneurCompositionDAO = new Teneur_CompositionDAO();
        if(teneurCompositionDAO.doesntExist(p)) teneurCompositionDAO.save(p);
    }
    public static void linkIngredientAndProduit(Produit p, List<Ingredient> list){
        for(Ingredient i : list){
            IngredientDAO idao = new IngredientDAO();

        }
    }
}
