package ma.projet.test;

import ma.projet.beans.Assurance;
import ma.projet.service.AssuranceService;

public class TestAssurance {
    public static void main(String[] args) {
        AssuranceService as = new AssuranceService();
        Assurance a1 = new Assurance("Auto1", 500.0, "Full");
        as.create(a1);

        System.out.println("Assurance par type: " + as.findByType("Auto1"));
        System.out.println("Contrats pour assurance Auto1: " + as.findContratsByAssuranceType("Auto1").size());


    }}
