package fr.diginamic.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("openFoodFacts");

    Optional<T> get(long id);

    List<T> getAll();

    default void save(T t) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(t);

        transaction.commit();
        em.close();
    }

    void update(T t, String[] params);

    void delete(T t);
}
