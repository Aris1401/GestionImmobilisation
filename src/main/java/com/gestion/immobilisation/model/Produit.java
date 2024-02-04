package com.gestion.immobilisation.model;

@Entity
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idProduit;
    String designation;
}
