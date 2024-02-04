package com.gestion.immobilisation.model;

public class DemandeProduit {
    DemandeProduit:
    idDemandeProduit
    DemandeAchat -> ManyToOne + JoinColumn
    Produit -> ManyToOne + JoinColumn
    quantite
}
