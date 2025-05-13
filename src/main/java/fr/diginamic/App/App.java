package fr.diginamic.App;

import fr.diginamic.DAO.ProduitDAO;
import fr.diginamic.DTO.ProduitDTO;
import fr.diginamic.entity.Produit;
import fr.diginamic.entity.Teneur_Composition;
import fr.diginamic.service.ConnexionJPA;
import fr.diginamic.service.ExtractFromDTO;
import fr.diginamic.service.ExtraireCSV;

import java.util.List;

public class App {
    public static void main(String[] args){
        List<ProduitDTO> listProduits = ExtraireCSV.convertAllStringsToDTO(ExtraireCSV.extractionCSV());
        for(ProduitDTO produitDTO : listProduits){
            Produit produit = ExtractFromDTO.extractProduitFromDTO(produitDTO);
            ConnexionJPA.addProduit(produit);
            Produit produitInstancié = new ProduitDAO().getByName(produit);
            ConnexionJPA.addMultipleAdditif(produitDTO.getListeAdditif());
            ConnexionJPA.addMultipleAllergene(produitDTO.getListeAllergene());
            ConnexionJPA.addMultipleIngredient(produitDTO.getListeIngredient());
            ConnexionJPA.addMarque(ExtractFromDTO.extractMarqueFromDTO(produitDTO));
            ConnexionJPA.addCategorie(ExtractFromDTO.extractCategorieFromDTO(produitDTO));
            for(Teneur_Composition tc : produitDTO.getListeComposition()){
                tc.setProduit_id(produit.getId());
                ConnexionJPA.addTeneurComposition(tc);
            }
        }
    }
}
