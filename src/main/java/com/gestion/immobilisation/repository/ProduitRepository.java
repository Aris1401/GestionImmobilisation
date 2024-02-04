package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.ArrayList;

public interface ProduitRepository  extends CrudRepository<Produit,Long>
{
        @Query("select * from Produit")
        public ArrayList<Produit> getAllProduit();

        @Query("Insert into Produit(designation) VALUES (?)")
        public void saveProduit();
}

