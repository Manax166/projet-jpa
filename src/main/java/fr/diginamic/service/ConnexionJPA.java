package fr.diginamic.service;

import fr.diginamic.DAO.*;
import fr.diginamic.entity.*;

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
            int ingredient_id = idao.getIdByName(i);
            idao.linkIngredient(p.getId(), ingredient_id);
        }
    }
    public static void linkAllergeneAndProduit(Produit p, List<Allergene> list){
        for(Allergene i : list){
            AllergeneDAO idao = new AllergeneDAO();
            int allergene_id = idao.getIdByName(i);
            idao.linkAllergene(p.getId(), allergene_id);
        }
    }
    public static void linkAdditifAndProduit(Produit p, List<Additif> list){
        for(Additif i : list){
            AdditifDAO idao = new AdditifDAO();
            int additif_id = idao.getIdByName(i);
            idao.linkAdditif(p.getId(), additif_id);
        }
    }
    public static void linkMarqueAndProduit(Produit p, Marque m){
        MarqueDAO mdao = new MarqueDAO();
        int marque_id = mdao.getIdByName(m);
        mdao.linkMarque(p.getId(), marque_id);
    }
    public static void linkCategorieAndProduit(Produit p, Categorie c){
        CategorieDAO mdao = new CategorieDAO();
        int categorie_id = mdao.getIdByName(c);
        mdao.linkCategorie(p.getId(), categorie_id);
    }
}
