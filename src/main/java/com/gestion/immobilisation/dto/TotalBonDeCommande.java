package com.gestion.immobilisation.dto;

import lombok.Data;

@Data
public class TotalBonDeCommande {
    double totalHT;
    double totalTVA;
    double pourcentageTVA;
    double totalTTC;
}
