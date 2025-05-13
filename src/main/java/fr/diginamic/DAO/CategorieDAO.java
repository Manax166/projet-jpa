package fr.diginamic.DAO;

import fr.diginamic.entity.Categorie;
import fr.diginamic.entity.Marque;
import jakarta.persistence.EntityManager;

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

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
