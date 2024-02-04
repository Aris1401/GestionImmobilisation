package com.gestion.immobilisation.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

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

    public static Proforma obtenirMoinsDixAns(Produit produit,List<Proforma> allProformaByProduit){
        Proforma proforma = null;
        if(allProformaByProduit.size() > 0){
            proforma = allProformaByProduit.get(0);
            if (allProformaByProduit.size() > 1){
                for (int i = 1; i < allProformaByProduit.size(); i++){
                    if(allProformaByProduit.get(i).getPrixUnitaire() < proforma.getPrixUnitaire())proforma = allProformaByProduit.get(i);
                }
            }
        }
        return proforma;
    }
}