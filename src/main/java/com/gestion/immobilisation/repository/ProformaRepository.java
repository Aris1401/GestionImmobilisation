package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.*;
        import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.List;

public interface ProformaRepository  extends CrudRepository<Proforma,Integer> {
        public List<Proforma> findByProduit(Produit produit);
}


