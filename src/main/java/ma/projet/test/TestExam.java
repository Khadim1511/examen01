package ma.projet.test;

import ma.projet.beans.Assurance;
import ma.projet.beans.Client;
import ma.projet.beans.Contrat;
import ma.projet.service.AssuranceService;
import ma.projet.service.ClientService;
import ma.projet.service.ContratService;

import java.util.Calendar;
import java.util.Date;

public class TestExam {
    public static void main(String[] args) {
        ClientService cs = new ClientService();
        AssuranceService as = new AssuranceService();
        ContratService cos = new ContratService();


        Client c1 = new Client("CIN001", "SEYE", "KHADIM", "KHADIM@email.com", "123456");
        cs.create(c1);

        Assurance a1 = new Assurance("Auto1", 500.0, "Full");
        as.create(a1);

        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.YEAR, 1);
        Date nextYear = cal.getTime();

        Contrat con1 = new Contrat(today, nextYear, "Actif", c1, a1);
        cos.create(con1);


        System.out.println("Assurance par type: " + as.findByType("Auto1"));

        System.out.println("Contrats du client CIN001: " + cs.findContratsByClientCin(" ").size());

        System.out.println("Contrats pour assurance Auto1: " + as.findContratsByAssuranceType("Auto1").size());

        System.out.println("Contrats actifs après aujourd'hui: " + cos.findActiveAfterDate(today).size());
    }
}