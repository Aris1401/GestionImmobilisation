package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BonDeCommande;
import com.gestion.immobilisation.model.Configuration;
import com.gestion.immobilisation.model.DemandeProduit;
import com.gestion.immobilisation.model.DemandeProforma;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;

public interface DemandeProformaRepository  extends CrudRepository<DemandeProforma,Integer>
{
}


