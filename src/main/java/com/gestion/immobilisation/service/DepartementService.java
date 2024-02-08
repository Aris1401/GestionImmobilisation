package com.gestion.immobilisation.service;

import com.gestion.immobilisation.model.BesoinAchat;
import com.gestion.immobilisation.model.Departement;
import com.gestion.immobilisation.repository.BesoinAchatRepository;
import com.gestion.immobilisation.repository.DepartementRepository;
import com.gestion.immobilisation.repository.ProformaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartementService
{
    @Autowired
    DepartementRepository departementRepository;
    public List<Departement> obtenirDepartement() {
        return DepartementRepository.allDepartement();
    }
}
