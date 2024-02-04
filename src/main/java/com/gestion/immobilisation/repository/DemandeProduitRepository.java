package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BonDeCommande;
import com.gestion.immobilisation.model.Configuration;
import com.gestion.immobilisation.model.DemandeProduit;
import com.gestion.immobilisation.model.Produit;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.List;

public interface DemandeProduitRepository  extends CrudRepository<DemandeProduit,Integer>
{
    public List<DemandeProduit> findDemandeProduitsByProduit(Produit produit);
}

