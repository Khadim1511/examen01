package ma.projet.beans;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contrats")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "client_cin")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    public Contrat() {}

    public Contrat(Date dateDebut, Date dateFin, String statut, Client client, Assurance assurance) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.client = client;
        this.assurance = assurance;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Assurance getAssurance() { return assurance; }
    public void setAssurance(Assurance assurance) { this.assurance = assurance; }

    @Override
    public String toString() {
        return "Contrat{id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", statut='" + statut + "'}";
    }
}
