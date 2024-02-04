package com.gestion.immobilisation.service;

import com.gestion.immobilisation.model.BesoinAchat;
import com.gestion.immobilisation.model.DemandeProduit;
import com.gestion.immobilisation.model.Produit;
import com.gestion.immobilisation.model.Proforma;
import com.gestion.immobilisation.repository.BesoinAchatRepository;
import com.gestion.immobilisation.repository.DemandeProduitRepository;
import com.gestion.immobilisation.repository.ProduitRepository;
import com.gestion.immobilisation.repository.ProformaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class BesoinAchatEnNatureService {
    @Autowired
    ProformaRepository proformaRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    BesoinAchatRepository besoinAchatRepository;
    @Autowired
    DemandeProduitRepository demandeProduitRepository;

    public ArrayList<Proforma> obtenirProformaProduit(int idProduit){
        Produit produit = produitRepository.findById(idProduit).get();
        return (ArrayList<Proforma>) proformaRepository.findByProduit(produit);
    }

    public List<BesoinAchat> obtenirBesoinsAchat(int idProduit){
        List<BesoinAchat> besoinAchats = new ArrayList<>();
        List<DemandeProduit> demandeProduits = demandeProduitRepository.findDemandeProduitsByProduit(produitRepository.findById(idProduit).get());
        for (int i = 0; i < demandeProduits.size(); i++) {
            besoinAchats.add(demandeProduits.get(i).getBesoinAchat());
        }
        return  besoinAchats;
    }
}
