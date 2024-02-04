package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BesoinAchat;
import com.gestion.immobilisation.model.Departement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.ArrayList;

public interface BesoinAchatRepository extends CrudRepository<BesoinAchat,Integer>
{
    public ArrayList<BesoinAchat> findByEtatBesoin(BesoinAchat.EtatBesoin etatBesoin);

    @Query("select * from BesoinAchat where =?")
    public ArrayList<BesoinAchat> obtenirBesoinsAchatsEnCours();
}
