package ma.projet.service;

import ma.projet.beans.Contrat;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ContratService extends AbstractFacade<Contrat> {
    public ContratService() {
        super(Contrat.class);
    }

    public List<Contrat> findActiveAfterDate(Date date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Contrat> q = session.createQuery("FROM Contrat WHERE dateFin > :date", Contrat.class);
            q.setParameter("date", date);
            return q.list();
        }
    }
}

