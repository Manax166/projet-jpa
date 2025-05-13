package fr.diginamic.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import fr.diginamic.DAO.*;
import fr.diginamic.DTO.ProduitDTO;
import fr.diginamic.DTO.Teneur_Type;
import fr.diginamic.entity.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtraireCSV {
    public static List<String[]> extractionCSV(){
        try {
            String link = "src/main/resources/OpenFoodFacts.csv";
            Path path = Paths.get(".", link);
            Reader reader = Files.newBufferedReader(path);
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator('|')
                    .withIgnoreQuotations(true)
                    .build();
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();
            return csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public static ProduitDTO convertStringsToDTO(List<String> list){
        ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setCategorie(list.get(0));
        produitDTO.setMarque(list.get(1));
        produitDTO.setNom(list.get(2));
        produitDTO.setNutritionGrade(list.get(3));
        for(String ingredient : list.get(4).split("[,-]")){
            String cleanIngredient = cleanString(ingredient);
            Ingredient comp =  new Ingredient(cleanIngredient);
            produitDTO.addToListeIngredient(comp);
        }
        for(int i=0; i<23; i++){
            produitDTO.addToListeComposition(new Teneur_Composition(Teneur_Type.valueOfLabel(i),list.get(5+i)));
        }
        for(String allergenes : list.get(24).split(",")){
            String cleanAllergenes = cleanString(allergenes);
            Allergene comp =  new Allergene(cleanAllergenes);
            produitDTO.addToListeAllergene(comp);
        }
        for(String additif : list.get(25).split(",")){
            String cleanAdditif = cleanString(additif);
            Additif comp =  new Additif(additif);
            produitDTO.addToListeAdditif(comp);
        }

        return produitDTO;
    }

    public static List<ProduitDTO> convertAllStringsToDTO(List<String[]> lines){
        List<ProduitDTO> resultList = new ArrayList<>();
        for(String[] line : lines){
            resultList.add(convertStringsToDTO(Arrays.stream(line).toList()));
        }
        return resultList;
    }

    public static String cleanString(String s) {
        return s.replaceAll("%.*$", "").replaceAll("\\(.*$", "").replaceAll("[0-9:.*%]", "").trim();
    }
}
