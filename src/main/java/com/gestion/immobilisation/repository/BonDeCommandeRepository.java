package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BonDeCommande;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;

public interface BonDeCommandeRepository  extends CrudRepository<BonDeCommande,Long>
{
}

