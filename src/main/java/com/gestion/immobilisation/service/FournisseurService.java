package com.gestion.immobilisation.service;

import com.gestion.immobilisation.model.Fournisseur;
import com.gestion.immobilisation.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class FournisseurService {
    @Autowired
    FournisseurRepository fournisseurRepository;

    public ArrayList<Fournisseur> obtenirFournisseurs(){
        return  fournisseurRepository.obtenirFournisseur();
    }

    public void ajouterFournisseur(Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
    }
}
