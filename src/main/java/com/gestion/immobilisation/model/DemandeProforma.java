package com.gestion.immobilisation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class DemandeProforma {
    public enum EtatDemandeProforma {
        EN_COURS,
        VALIDER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDemandeProforma;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;

    double quanite;
    Date dateDeDemande;

    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    Fournisseur fournisseur;

    EtatDemandeProforma etatDemande = EtatDemandeProforma.EN_COURS;
}