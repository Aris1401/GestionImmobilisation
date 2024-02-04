package com.gestion.immobilisation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDepartement;

    String nom;
    @JsonManagedReference
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    List<Personnel> personnels;

// Boucler la liste des personnels et checker si un perso
// est le chef de departement et le retourner
    public Personnel getChefDepartement() {
        return null;
    }
}
