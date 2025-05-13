package fr.diginamic.DAO;

import fr.diginamic.entity.*;
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
    public void linkMarque(int produit_id, int marque_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            MarqueProduit ap = new MarqueProduit(marque_id, produit_id);
            em.persist(ap);

            transaction.commit();
        } catch (Exception e){}
        em.close();
    }
    public int getIdByName(Marque m){
        int res = 0;
        EntityManager em = emf.createEntityManager();
        try {
                res = em.createQuery("select m from Marque m where m.nom like :nom", Marque.class)
                        .setParameter("nom", m.getNom())
                        .getResultList().get(0).getId();
            em.close();
            return res;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
