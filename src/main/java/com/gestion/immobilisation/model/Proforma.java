package com.gestion.immobilisation.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

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
}