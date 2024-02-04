package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BonDeCommande;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.List;

public interface BonDeCommandeRepository  extends CrudRepository<BonDeCommande,Integer> {
    List<BonDeCommande> findByEtatBonDeCommande(BonDeCommande.EtatBonDeCommande etatBonDeCommande);
}

