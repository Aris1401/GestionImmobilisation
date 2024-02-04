package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BonDeCommande;
import com.gestion.immobilisation.model.Configuration;
import com.gestion.immobilisation.model.DemandeProduit;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;

public interface DemandeProduitRepository  extends CrudRepository<DemandeProduit,Integer>
{
}

