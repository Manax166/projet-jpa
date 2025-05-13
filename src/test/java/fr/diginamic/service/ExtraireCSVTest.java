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
        List<String[]> res = ExtraireCSV.extractionCSV();
        assertFalse(res.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void convertStringToDTO(){;
        List<String[]> allLines = ExtraireCSV.extractionCSV();
        List<String> res = Arrays.stream(allLines.get(0)).toList();
        ProduitDTO pdto = ExtraireCSV.convertStringsToDTO(res);
        assertNotNull(pdto);
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
    @org.junit.jupiter.api.Test
    void cleanString(){
        String s = "Objet (description osef)";
        assertEquals(ExtraireCSV.cleanString(s), "Objet");
        s = "Objet : 25% Pomme au minimum*.";
        assertEquals(ExtraireCSV.cleanString(s), "Objet");
    }

}