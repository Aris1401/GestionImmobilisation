package com.gestion.immobilisation.dto;

import com.gestion.immobilisation.model.Produit;
import lombok.Data;

@Data
public class DetailsBonDeCommande {
    Produit produit;
    double quantite;
    double prixUnitaireHT;
    double pourcentageTVA;

    public double getPrixTVA() {
        return getPrixUnitaireHT() * (getPourcentageTVA() / 100.0);
    }

    public double getPrixUnitaireTTC() {
        return getPrixUnitaireHT() + getPrixTVA();
    }

    public double getTotalPrixHT() {
        return getPrixUnitaireHT() * getQuantite();
    }

    public double getTotalPrixTTC() {
        return getPrixUnitaireTTC() * getQuantite();
    }
}
