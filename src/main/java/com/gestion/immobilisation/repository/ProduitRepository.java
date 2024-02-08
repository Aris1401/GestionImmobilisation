package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.BesoinAchat;
import com.gestion.immobilisation.model.Produit;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Repository;


@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {

}
