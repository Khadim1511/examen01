package ma.projet.service;

import ma.projet.beans.Client;
import ma.projet.beans.Contrat;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ClientService extends AbstractFacade<Client> {
    public ClientService() {
        super(Client.class);
    }

    public Client findByCin(String cin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> q = session.createQuery("FROM Client WHERE cin = :cin", Client.class);
            q.setParameter("cin", cin);
            return q.uniqueResult();
        }
    }

    public List<Contrat> findContratsByClientCin(String cin) {
        Client client = findByCin(cin);
        if (client == null) return new ArrayList<>();
        return client.getContrats();
    }
}
