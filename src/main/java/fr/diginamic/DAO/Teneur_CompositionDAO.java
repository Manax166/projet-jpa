package fr.diginamic.DAO;

import fr.diginamic.entity.Teneur_Composition;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class Teneur_CompositionDAO implements Dao{

    public void create(String type, String valeur) {
    }

    public void create(String type) {

    }

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return List.of();
    }

    public boolean doesntExist(Teneur_Composition teneurComposition){
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        result = em.createQuery("select tc from Teneur_Composition tc where tc.type like :type and tc.produit_id = :produit_id", Teneur_Composition.class)
                .setParameter("produit_id", teneurComposition.getProduit_id())
                .setParameter("type", teneurComposition.getType())
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
