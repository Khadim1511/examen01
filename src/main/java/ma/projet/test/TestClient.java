package ma.projet.test;

import ma.projet.beans.Client;
import ma.projet.service.ClientService;

public class TestClient {
    public static void main(String[] args) {
        ClientService cs = new ClientService();
        Client c1 = new Client("CIN001", "SEYE", "KHADIM", "KHADIM@email.com", "123456");
        cs.create(c1);
        System.out.println("Contrats du client CIN001: " + cs.findContratsByClientCin(" ").size());
}}

