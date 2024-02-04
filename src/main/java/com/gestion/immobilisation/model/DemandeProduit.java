package com.gestion.immobilisation.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DemandeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDemandeProduit;

    @ManyToOne
    @JoinColumn(name = "id_besoin_achat")
    BesoinAchat besoinAchat;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;

    double quantite;
}
