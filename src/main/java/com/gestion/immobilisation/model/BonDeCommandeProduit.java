package com.gestion.immobilisation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BonDeCommandeProduit {
    @Id
    @GeneratedValue(stratedy = GenerationType.IDENTITY)
    int idBonDeCommandeProduit;
    Conception gestion achat8@ManyToOne
    @JoinColumn(name = "id_bon_de_commande")
    BonDeCommande bonDeCommande;
    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;
    double quantite;
    double prixUnitaire;
    public double getPrixHTTotale() {
        return getQuantite() * getPrixUnitaire();
