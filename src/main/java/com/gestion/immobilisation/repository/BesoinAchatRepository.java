package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BesoinAchat;
import com.gestion.immobilisation.model.Departement;
import com.gestion.immobilisation.model.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.ArrayList;

public interface BesoinAchatRepository extends CrudRepository<BesoinAchat,Integer>
{
    public ArrayList<BesoinAchat> findByEtatBesoin(BesoinAchat.EtatBesoin etatBesoin);
    public ArrayList<BesoinAchat> allBesoinAchats();

    public ArrayList<BesoinAchat> findByProduit(int idProduit);

}
