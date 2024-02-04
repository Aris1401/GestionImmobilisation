package com.gestion.immobilisation.dto;


import com.gestion.immobilisation.model.Produit;
import lombok.Data;

@Data
public class BesoinAchatEnNature {
    Produit produit;
    double quantite;
}