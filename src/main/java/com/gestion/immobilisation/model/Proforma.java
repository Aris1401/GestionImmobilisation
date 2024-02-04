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

    public int getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(int idProforma) {
        this.idProforma = idProforma;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixTotal() {
        return getQuantite() * getPrixUnitaire();
    }

    public Proforma(int idProforma, Fournisseur fournisseur, Produit produit, double quantite, double prixUnitaire) {
        this.setIdProforma(idProforma);
        this.setFournisseur(fournisseur);
        this.setProduit(produit);
        this.setQuantite(quantite);
        this.setPrixUnitaire(prixUnitaire);
    }

    public static ArrayList<Proforma> getByIdProduit(int produit)throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from proforma where produit = ?";
        ArrayList<Proforma> allProformas = new ArrayList<>();
        try{
            connection = accessToDB.ConnectTo.postgreS();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,produit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allProformas.add(new Proforma(resultSet.getInt(1),resultSet.getInt(1),resultSet.getInt(1),resultSet.getInt(1),resultSet.getInt(1)));
            }
        }catch (Exception e){
            throw e;
        }
    }
}