package com.gestion.immobilisation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
    String nomResponsable;
    String email;
}
