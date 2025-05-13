package fr.diginamic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUIT")
public class Produit {
    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 1,
            initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "produit_id")
    private int id;
    private String nom;
    @Column(name = "nutrition_grade")
    private String nutritionGrade;

    public Produit(){}

    public Produit(int id, String nom, String nutritionGrade) {
        this.id = id;
        this.nom = nom;
        this.nutritionGrade = nutritionGrade;
    }

    public Produit(String nom, String nutritionGrade) {
        this.nom = nom;
        this.nutritionGrade = nutritionGrade;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNutritionGrade() {
        return nutritionGrade;
    }

    public void setNutritionGrade(String nutritionGrade) {
        this.nutritionGrade = nutritionGrade;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
