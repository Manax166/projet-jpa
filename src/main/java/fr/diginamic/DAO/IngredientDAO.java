package fr.diginamic.DAO;

import fr.diginamic.entity.Composant;
import fr.diginamic.entity.Ingredient;
import fr.diginamic.entity.IngredientProduit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class IngredientDAO implements ComposantDAO{

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return List.of();
    }

    @Override
    public void save(Object o) {

    }
    public void link(int produit_id, int ingredient_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        IngredientProduit ip = new IngredientProduit(produit_id, ingredient_id);
        transaction.begin();
        em.persist(ip);

        transaction.commit();
        em.close();
    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
