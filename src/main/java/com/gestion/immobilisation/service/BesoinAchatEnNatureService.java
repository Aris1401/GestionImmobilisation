package com.gestion.immobilisation.service;

import com.gestion.immobilisation.model.BesoinAchat;
import com.gestion.immobilisation.model.Produit;
import com.gestion.immobilisation.model.Proforma;
import com.gestion.immobilisation.repository.BesoinAchatRepository;
import com.gestion.immobilisation.repository.ProduitRepository;
import com.gestion.immobilisation.repository.ProformaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BesoinAchatEnNatureService {
    @Autowired
    ProformaRepository proformaRepository;
    @Autowired
    ProduitRepository produitRepository;

    public ArrayList<Proforma> obtenirProformaProduit(int idProduit){
        Produit produit = produitRepository.findById(idProduit).get();
        return (ArrayList<Proforma>) proformaRepository.findByProduit(produit);
    }

    public ArrayList<BesoinAchat> obtenirBesoinAchatProduit(int idProduit){
        return (ArrayList<BesoinAchat>) BesoinAchatRepository.findByProduit(idProduit);
    }

    public List<BesoinAchat> obtenirBesoinsAchatsEnCours() {
        return obtenirBesoinsAchatsEnCours(BesoinAchat.EtatBesoin.EN_COURS);
    }

    public List<BesoinAchat> obtenirBesoinAchatsValidees() {
        return obtenirBesoinAchatsValidees(BesoinAchat.EtatBesoin.VALIDER);
    }

    public List<BesoinAchat> obtenirBesoinAchat() {
        return BesoinAchatRepository.allBesoinAchats();
    }
}
