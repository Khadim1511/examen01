package ma.projet.service;

import ma.projet.beans.Assurance;
import ma.projet.beans.Contrat;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AssuranceService extends AbstractFacade<Assurance> {
    public AssuranceService() {
        super(Assurance.class);
    }

    public Assurance findByType(String type) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Assurance> q = session.createQuery("FROM Assurance WHERE type = :type", Assurance.class);
            q.setParameter("type", type);
            return q.uniqueResult();
        }
    }

    public List<Contrat> findContratsByAssuranceType(String type) {
        Assurance assurance = findByType(type);
        if (assurance == null) return new ArrayList<>();
        return assurance.getContrats();
    }
}
