package fr.diginamic.DTO;

import fr.diginamic.Entity.Composant;
import fr.diginamic.Entity.Teneur_Composition;

import java.util.ArrayList;
import java.util.List;

public class ProduitDTO {
    private int produitId;
    private List<Composant> listeIngredient = new ArrayList<>();
    private String nom;
    private String nutritionGrade;
    private List<Teneur_Composition> listeComposition = new ArrayList<>();
    private List<Composant> listeAdditif = new ArrayList<>();
    private List<Composant> listeAllergene = new ArrayList<>();
}
