package fr.diginamic.DAO;

import java.util.List;
import java.util.Optional;

public class AdditifDAO implements ComposantDAO{
    @Override
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
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
