package ma.projet.beans;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "assurances")
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Double montant;
    private String couverture;

    @OneToMany(mappedBy = "assurance", cascade = CascadeType.ALL)
    private List<Contrat> contrats = new ArrayList<>();

    public Assurance() {}

    public Assurance(String type, Double montant, String couverture) {
        this.type = type;
        this.montant = montant;
        this.couverture = couverture;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }
    public String getCouverture() { return couverture; }
    public void setCouverture(String couverture) { this.couverture = couverture; }
    public List<Contrat> getContrats() { return contrats; }
    public void setContrats(List<Contrat> contrats) { this.contrats = contrats; }

    @Override
    public String toString() {
        return "Assurance{id=" + id + ", type='" + type + "'}";
    }
}