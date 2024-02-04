package com.gestion.immobilisation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
public class BesoinAchat {
    public enum EtatBesoin {
        EN_COURS,
        VALIDER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBesoinAchat;
    String titreBesoin;
    String description;
    Date dateDeCreation;
    @ManyToOne
    @JoinColumn(name = "id_departement")
    Departement departement;
    @JsonManagedReference
    @OneToMany(mappedBy = "besoinAchat", fetch = FetchType.LAZY
            List<DemandeProduit> demandeProduit;
            EtatBesoin etatBesoin;
}
@JsonBackReference
@ManyToOne(fetch = FetchType.LAZY