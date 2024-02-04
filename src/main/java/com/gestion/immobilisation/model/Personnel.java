package com.gestion.immobilisation.model;

import jakarta.persistence.Entity;
import lombok.Data;package com.gestion.immobilisation.model;

@Entity
@Data
public class Peronnel {
    public enum RolePersonnel {
        CHEF_DEPARTEMENT,
        SERVICE_ACHAT,
        RESPONSABLE_RH,
        FINANCES,
        DIRECTION_GENERALE
    }

    @Id
    @GeneratedValue(...)
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
    RolePersonnel role;
}

