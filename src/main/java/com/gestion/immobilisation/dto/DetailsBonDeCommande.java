package com.gestion.immobilisation.dto;

import com.gestion.immobilisation.model.Produit;
import lombok.Data;

@Data
public class DetailsBonDeCommande {
    Produit produit;
    double quantite;
    double prixUnitaireHT;
    double pourcentageTVA;
    double prixTVA;
    double prixUnitaireTTC;
    double totalPrixHT;
    double totalPrixTTC;
}
