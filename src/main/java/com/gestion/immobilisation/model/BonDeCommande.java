package com.gestion.immobilisation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class BonDeCommande {
    public enum EtatBonDeCommande {
        EN_COURS,
        VALIDER_RH,
        VALIDER_FINANCES,
        VALIDER_DG
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBonDeCommande;
    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    Fournisseur fournisseur;
    Date dateCreation;
    @ManyToOne
    @JoinColumn(name = "id_mode_de_paiement")
    ModeDePaimement modeDePaiement;
    String conditionDePaiement;
    Date dateDeLivraison;
    @JsonManagedReference
    @OneToMany(mappedBy = "bonDeCommande", fetch = FetchType.
            List<BonDeCommandeProduit> bonDeCommandeProduits;
            EtatBonDeCommande etatBonDeCommande;
            Conception gestion achat7public String obtenirIdBonDeCommande(); // BDC + 0000 + id
// Si mbola "EN_COURS" ny etat de mamerina RH
// Si "VALIDER_RH" ny etat marina FINANCES
// Si "VALIDER_FINANDES" ny etat marina DG
// Si "VALIDER_DG" tsy mamerina inin tsony
            public Peronnel.RolePersonnel obtenirRoleDeValidation();
// Si "EN_COURS" -> "VALIDER_RH"
// Si "VALIDER_RH" -> "VALIDER_FINANCES"
// Si "VALIDER_FINANCES" -> "VALIDER_DG"
// Si "VALIDER_DG" -> null
            public EtatBonDeCommande obtenirEtatSuivant();
