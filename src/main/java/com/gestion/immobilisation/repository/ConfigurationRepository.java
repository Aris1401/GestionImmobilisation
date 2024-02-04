package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BonDeCommande;
import com.gestion.immobilisation.model.Configuration;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;

public interface ConfigurationRepository  extends CrudRepository<Configuration,Integer>
{
}


