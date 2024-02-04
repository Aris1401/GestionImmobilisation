package com.gestion.immobilisation.service;

import com.gestion.immobilisation.dto.DetailsBonDeCommande;
import com.gestion.immobilisation.dto.TotalBonDeCommande;
import com.gestion.immobilisation.model.BonDeCommande;
import com.gestion.immobilisation.model.BonDeCommandeProduit;
import com.gestion.immobilisation.repository.BonDeCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BonDeCommandeService {
    @Autowired
    BonDeCommandeRepository bonDeCommandeRepository;
    @Autowired
    ConfigurationService configurationService;

    public List<BonDeCommande> obtenirBonDeCommandeAvecEtat(BonDeCommande.EtatBonDeCommande etatBonDeCommande) {
        return bonDeCommandeRepository.findByEtatBonDeCommande(etatBonDeCommande);
    }

    public List<BonDeCommande> obtenirListeBonDeCommandeEnCoursRH() {
        return obtenirBonDeCommandeAvecEtat(BonDeCommande.EtatBonDeCommande.EN_COURS);
    }

    public List<BonDeCommande> obtenirListeBonDeCommandeEnCoursFinances() {
        return obtenirBonDeCommandeAvecEtat(BonDeCommande.EtatBonDeCommande.VALIDER_RH);
    }

    public List<BonDeCommande> obtenirListeBonDeCommandeEnCoursDG() {
        return obtenirBonDeCommandeAvecEtat(BonDeCommande.EtatBonDeCommande.VALIDER_FINANCES);
    }

    public List<BonDeCommande> obtenirListeBonDeCommandeValider() {
        return bonDeCommandeRepository.findByEtatBonDeCommande(BonDeCommande.EtatBonDeCommande.VALIDER_DG);
    }

    public List<DetailsBonDeCommande> obtenirDetailsBonDeCommandes(int idBonDeCommande) {
        // Obtenir bon de commande
        BonDeCommande bonDeCommande = bonDeCommandeRepository.findById(idBonDeCommande).get();

        List<DetailsBonDeCommande> detailsBonDeCommandes = new ArrayList<>();
        for (BonDeCommandeProduit bonDeCommandeProduit : bonDeCommande.getBonDeCommandeProduits()) {
            DetailsBonDeCommande detailsBonDeCommande = new DetailsBonDeCommande();

            detailsBonDeCommande.setProduit(bonDeCommandeProduit.getProduit());
            detailsBonDeCommande.setPrixUnitaireHT(bonDeCommandeProduit.getPrixUnitaire());
            detailsBonDeCommande.setQuantite(bonDeCommandeProduit.getQuantite());
            detailsBonDeCommande.setPourcentageTVA(configurationService.getTVA());

            detailsBonDeCommandes.add(detailsBonDeCommande);
        }

        return detailsBonDeCommandes;
    }

    public TotalBonDeCommande obtenirTotalBonDeCommande(int idBonDeCommnande) {
        // Details bon de commande
        List<DetailsBonDeCommande> detailsBonDeCommandes = obtenirDetailsBonDeCommandes(idBonDeCommnande);

        TotalBonDeCommande totalBonDeCommande = new TotalBonDeCommande();

        double totalHT = 0;
        double totalTVA = 0;
        double pourcentageTVA = configurationService.getTVA();
        double totalTTC = 0;
        for (DetailsBonDeCommande detailsBonDeCommande : detailsBonDeCommandes) {
//            double totalHT;
//            double totalTVA;
//            double pourcentageTVA;
//            double totalTTC;
            totalHT += detailsBonDeCommande.getTotalPrixHT();
            totalTVA += detailsBonDeCommande.getPrixTVA();
            totalTTC += detailsBonDeCommande.getTotalPrixTTC();
        }

        totalBonDeCommande.setPourcentageTVA(pourcentageTVA);
        totalBonDeCommande.setTotalHT(totalHT);
        totalBonDeCommande.setTotalTVA(totalTVA);
        totalBonDeCommande.setTotalTTC(totalTTC);
        return totalBonDeCommande;
    }

    public BonDeCommande ajouterBonDeCommande(BonDeCommande bonDeCommande) {
        return bonDeCommandeRepository.save(bonDeCommande);
    }

    public BonDeCommande.EtatBonDeCommande validerBonDeCommande(int idBonDeCommande) {
        // Personnel check
        BonDeCommande bonDeCommande = bonDeCommandeRepository.findById(idBonDeCommande).get();

        BonDeCommande.EtatBonDeCommande etatSuivant = bonDeCommande.obtenirEtatSuivant();
        bonDeCommande.setEtatBonDeCommande(etatSuivant);

        bonDeCommandeRepository.save(bonDeCommande);
        return etatSuivant;
    }
}
