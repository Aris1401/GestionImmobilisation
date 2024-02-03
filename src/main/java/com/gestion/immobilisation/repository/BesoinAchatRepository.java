package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BesoinAchat;
import com.gestion.immobilisation.model.Departement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.ArrayList;

public interface BesoinAchatRepository extends CrudRepository<BesoinAchat,Long>
{
    @Query("select * from BesoinAchat where =?")
    public ArrayList<BesoinAchat> obtenirBesoinsAchatsEnCours();

    @Query("select * from BesoinAchat where =?")
    public ArrayList<BesoinAchat> obtenirBesoinsAchatsValidee();

    @Query("select * from Departement")
    public ArrayList<BesoinAchat> getAllBesoinAchat();

    @Query("select count(idMatch) from ActionMatch where idJoueur=?1 GROUP BY idMatch")
    public double  getMatchJouerParJoueur(int idJoueur);
}
}
