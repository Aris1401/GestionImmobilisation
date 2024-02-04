package com.gestion.immobilisation.service;

import com.gestion.immobilisation.model.Configuration;
import com.gestion.immobilisation.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    @Autowired
    ConfigurationRepository configurationRepository;

    public double getTVA() {
        return ((List<Configuration>) configurationRepository.findAll()).get(0).getTva();
    }
}
