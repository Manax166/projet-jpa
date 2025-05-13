package fr.diginamic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Teneur_Composition")
public class Teneur_Composition {
    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 1,
            initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "teneur_id")
    private int id;
    @Column(name = "produit_id")
    private int produit_id;
    private String type;
    @Column(name = "valeur")
    private String valeurPour100g;

    public Teneur_Composition(){}

    public Teneur_Composition(int produitId, String type, String valeurPour100g) {
        this.produit_id = produitId;
        this.type = type;
        this.valeurPour100g = valeurPour100g;
    }

    public Teneur_Composition(String type, String valeurPour100g) {
        this.type = type;
        this.valeurPour100g = valeurPour100g;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValeurPour100g() {
        return valeurPour100g;
    }

    public void setValeurPour100g(String valeurPour100g) {
        this.valeurPour100g = valeurPour100g;
    }
}
