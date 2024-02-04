package com.gestion.immobilisation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Personnel {
    public enum RolePersonnel {
        CHEF_DEPARTEMENT,
        SERVICE_ACHAT,
        RESPONSABLE_RH,
        FINANCES,
        DIRECTION_GENERALE,
        SIMPLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPersonnel;
    String nom;
    String prenom;
    String email;
    String motDePasse;
    Date dateEmbauche;
    Date dateNaissance;

    @ManyToOne
    @JoinColumn(name = "id_departement")
    Departement departement;

    RolePersonnel role = RolePersonnel.SIMPLE;
}

