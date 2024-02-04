package com.gestion.immobilisation.service;

import com.gestion.immobilisation.dto.BesoinAchatEnNature;
import com.gestion.immobilisation.model.DemandeProforma;
import com.gestion.immobilisation.model.Fournisseur;
import com.gestion.immobilisation.model.Proforma;
import com.gestion.immobilisation.repository.DemandeProformaRepository;
import com.gestion.immobilisation.repository.FournisseurRepository;
import com.gestion.immobilisation.repository.ProduitRepository;
import com.gestion.immobilisation.repository.ProformaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ProformaService {
    @Autowired
    ProformaRepository proformaRepository;
    @Autowired
    DemandeProformaRepository demandeProformaRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;

    public DemandeProforma demanderProforma(BesoinAchatEnNature besoinEnNature, int idFournisseur){
        DemandeProforma demandeProforma = new DemandeProforma();
        demandeProforma.setProduit(besoinEnNature.getProduit());
        demandeProforma.setQuanite(besoinEnNature.getQuantite());
        demandeProforma.setDateDeDemande(Date.valueOf(LocalDate.now()));
        demandeProforma.setFournisseur(fournisseurRepository.findById(idFournisseur).get());
        return demandeProformaRepository.save(demandeProforma);
    }
    public Proforma obtenirMoinsDixAns(BesoinAchatEnNature besoinEnNature){
        return Proforma.obtenirMoinsDixAns(besoinEnNature.getProduit(),proformaRepository.findByProduit(besoinEnNature.getProduit()));
    }

    public void ajouterProforma(Proforma proforma, DemandeProforma demande){
        proforma = proformaRepository.save(proforma);
    }

    public List<Proforma> obtenirProformaPourProduit(int idProduit){
        return proformaRepository.findByProduit(produitRepository.findById(idProduit).get());
    }
}
