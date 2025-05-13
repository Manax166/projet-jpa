package fr.diginamic.DAO;

import fr.diginamic.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public interface ComposantDAO extends Dao {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("openFoodFacts");
    default void create(String nom){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Composant c = new Composant(nom);
        em.persist(c);

        transaction.commit();
        em.close();
    }
    default void create(Composant c){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(c);

        transaction.commit();
        em.close();
    }
    default void linkIngredient(int produit_id, int ingredient_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            IngredientProduit ip = new IngredientProduit(ingredient_id, produit_id);
            em.persist(ip);

            transaction.commit();
        } catch (Exception e){}
        em.close();
    }
    default void linkAllergene(int produit_id, int allergene_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            AllergeneProduit ap = new AllergeneProduit(allergene_id, produit_id);
            em.persist(ap);

            transaction.commit();
        } catch (Exception e){}
        em.close();
    }
    default void linkAdditif(int produit_id, int additif_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            AdditifProduit ap = new AdditifProduit(additif_id, produit_id);
            em.persist(ap);

            transaction.commit();
        } catch (Exception e){}
        em.close();
    }
    default Composant getById(Composant c){
        /*  Regarder comment faire le filtre    */
        Composant comp = new Composant();
        EntityManager em = emf.createEntityManager();
        if (c instanceof Ingredient) comp = em.find(Ingredient.class, c.getId());
        else if (c instanceof Allergene) comp = em.find(Allergene.class, c.getId());
        else if (c instanceof Additif) comp = em.find(Additif.class, c.getId());
        em.close();
        return comp;
    }
    default boolean doesntExist(Composant c){
        boolean comp = false;
        EntityManager em = emf.createEntityManager();
        if (c instanceof Ingredient) comp = em.createQuery("select i from Ingredient i where i.nom like :nom", Ingredient.class)
                .setParameter("nom", c.getNom())
                .getResultList().isEmpty();
        else if (c instanceof Allergene) comp = em.createQuery("select al from Allergene al where al.nom like :nom", Allergene.class)
                .setParameter("nom", c.getNom())
                .getResultList().isEmpty();
        else if (c instanceof Additif) comp = em.createQuery("select ad from Additif ad where ad.nom like :nom", Additif.class)
                .setParameter("nom", c.getNom())
                .getResultList().isEmpty();
        em.close();
        return comp;
    }
    default int getIdByName(Composant c){
        int res = 0;
        EntityManager em = emf.createEntityManager();
        try {
            if (c instanceof Ingredient)
                res = em.createQuery("select i from Ingredient i where i.nom like :nom", Ingredient.class)
                        .setParameter("nom", c.getNom())
                        .getResultList().get(0).getId();
            else if (c instanceof Allergene)
                res = em.createQuery("select al from Allergene al where al.nom like :nom", Allergene.class)
                        .setParameter("nom", c.getNom())
                        .getResultList().get(0).getId();
            else if (c instanceof Additif)
                res = em.createQuery("select ad from Additif ad where ad.nom like :nom", Additif.class)
                        .setParameter("nom", c.getNom())
                        .getResultList().get(0).getId();
            em.close();
            return res;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
}
