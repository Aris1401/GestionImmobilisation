package com.gestion.immobilisation.repository;

import com.gestion.immobilisation.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.ArrayList;

public interface DepartementRepository  extends CrudRepository<Departement,Integer> {
    public ArrayList<Departement> allDepartement();
}


