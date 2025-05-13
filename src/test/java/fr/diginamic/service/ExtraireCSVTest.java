package fr.diginamic.service;

import fr.diginamic.DAO.IngredientDAO;
import fr.diginamic.DTO.ProduitDTO;
import fr.diginamic.entity.Ingredient;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ExtraireCSVTest {

    @org.junit.jupiter.api.Test
    void extractionCSV() {
        List<String[]> res = new ExtraireCSV().extractionCSV();
        assertFalse(res.isEmpty());
        Arrays.stream(res.get(0)).toList().forEach(x -> System.out.println(x));
    }
    @org.junit.jupiter.api.Test
    void convertStringToDTO(){
        ExtraireCSV ecsv = new ExtraireCSV();
        List<String[]> allLines = ecsv.extractionCSV();
        List<String> res = Arrays.stream(allLines.get(0)).toList();
        ProduitDTO pdto = ecsv.convertStringsToDTO(res);
        System.out.println(pdto.toString());
    }

    @org.junit.jupiter.api.Test
    void addIngredient(){
        ExtraireCSV ecsv = new ExtraireCSV();
        List<String[]> allLines = ecsv.extractionCSV();
        List<String> res = Arrays.stream(allLines.get(0)).toList();
        ProduitDTO pdto = ecsv.convertStringsToDTO(res);
        ConnexionJPA.addIngredient((Ingredient) pdto.getListeIngredient().get(0));
        assertNotNull(new IngredientDAO().getById(pdto.getListeIngredient().get(0)));
    }

}