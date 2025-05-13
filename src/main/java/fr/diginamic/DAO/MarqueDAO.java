package fr.diginamic.DAO;

import fr.diginamic.entity.Marque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class MarqueDAO implements Dao{
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

    @Override
    public void save(Object o) {
        if(!(o instanceof Marque)) return;
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(o);

        transaction.commit();
        em.close();
    }
    public boolean doesntExist(Marque marque){
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        result = em.createQuery("select i from Marque i where i.nom like :nom", Marque.class)
            .setParameter("nom", marque.getNom())
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
