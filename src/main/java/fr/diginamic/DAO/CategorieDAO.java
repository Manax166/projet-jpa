package fr.diginamic.DAO;

import fr.diginamic.entity.Categorie;
import fr.diginamic.entity.CategorieProduit;
import fr.diginamic.entity.Marque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CategorieDAO implements Dao{
    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return List.of();
    }
    public boolean doesntExist(Categorie categorie){
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        result = em.createQuery("select i from Categorie i where i.nom like :nom", Categorie.class)
                .setParameter("nom", categorie.getNom())
                .getResultList().isEmpty();
        em.close();
        return result;
    }
    public void linkCategorie(int produit_id, int categorie_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            CategorieProduit ap = new CategorieProduit(categorie_id, produit_id);
            em.persist(ap);

            transaction.commit();
        } catch (Exception e){}
        em.close();
    }
    public int getIdByName(Categorie c){
        int res = 0;
        EntityManager em = emf.createEntityManager();
        try {
            res = em.createQuery("select c from Categorie c where c.nom like :nom", Categorie.class)
                    .setParameter("nom", c.getNom())
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
