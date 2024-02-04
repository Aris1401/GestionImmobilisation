package com.gestion.immobilisation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ModeDePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idModeDePaiement;
    String designation;
}
