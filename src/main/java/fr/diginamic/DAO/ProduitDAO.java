package fr.diginamic.DAO;

import fr.diginamic.entity.Marque;
import fr.diginamic.entity.Produit;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProduitDAO implements Dao{

    public void create(String nom) {
    }

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return List.of();
    }

    public Produit getByName(Produit produit){
        Produit result;
        EntityManager em = emf.createEntityManager();
        result = em.createQuery("select i from Produit i where i.nom like :nom", Produit.class)
                .setParameter("nom", produit.getNom())
                .getResultList().get(0);
        em.close();
        return result;
    }

    public boolean doesntExist(Produit produit){
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        result = em.createQuery("select i from Produit i where i.nom like :nom", Produit.class)
                .setParameter("nom", produit.getNom())
                .getResultList().isEmpty();
        em.close();
        return result;
    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
