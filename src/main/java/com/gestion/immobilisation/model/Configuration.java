package com.gestion.immobilisation.model;

@Data
@Entity
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idConfiguration;
    double tva;
}
