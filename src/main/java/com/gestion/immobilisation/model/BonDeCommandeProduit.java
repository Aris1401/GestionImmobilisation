package com.gestion.immobilisation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BonDeCommandeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBonDeCommandeProduit;

    @ManyToOne
    @JoinColumn(name = "id_bon_de_commande")
    BonDeCommande bonDeCommande;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;

    double quantite;
    double prixUnitaire;

    public double getPrixHTTotale() {
        return getQuantite() * getPrixUnitaire();
    }
}
