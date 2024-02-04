package com.gestion.immobilisation.service;

import com.gestion.immobilisation.model.Produit;
import com.gestion.immobilisation.model.Proforma;
import com.gestion.immobilisation.repository.ProduitRepository;
import com.gestion.immobilisation.repository.ProformaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class BesoinAchatEnNatureService {
    @Autowired
    ProformaRepository proformaRepository;
    @Autowired
    ProduitRepository produitRepository;

    public ArrayList<Proforma> obtenirProformaProduit(int idProduit){
        Produit produit = produitRepository.findById(idProduit).get();
        return (ArrayList<Proforma>) proformaRepository.findByProduit(produit);
    }
}
