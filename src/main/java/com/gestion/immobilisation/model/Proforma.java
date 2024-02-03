package com.gestion.immobilisation.model;

@Entity
@Data
public class Proforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idProforma;
    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    Fournisseur fournisseur;
    @ManyToOne
    @JoinColumn(name = "id_produit")
    Produit produit;
    double quantite;
    double prixUnitaire;
    public double getPrixTotal() {
        return getQuantite() * getPrixUnitaire();
    }
}