package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import javax.swing.*;
import java.util.ArrayList;

public interface FournisseurRepository  extends CrudRepository<Fournisseur,Integer>
{
        @Query("select * from fournisseur")
        public ArrayList<Fournisseur> obtenirFournisseur();
}

