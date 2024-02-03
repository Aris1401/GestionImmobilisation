package com.gestion.immobilisation.model;

@Entity
@Data
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idFournisseur;
    String nom;
    String addresse;
    String contact;
    String localisation;
    Conception gestion achat4String nomResponsable;
    String email;
}
