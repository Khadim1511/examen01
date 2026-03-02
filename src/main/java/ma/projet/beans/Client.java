package ma.projet.beans;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "clients")
public class Client {
    @Id
    private String cin;

    private String nom;
    private String prenom;
    private String email;
    private String tel;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Contrat> contrats = new ArrayList<>();

    public Client() {}

    public Client(String cin, String nom, String prenom, String email, String tel) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
    }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public List<Contrat> getContrats() { return contrats; }
    public void setContrats(List<Contrat> contrats) { this.contrats = contrats; }

    @Override
    public String toString() {
        return "Client{cin='" + cin + "', nom='" + nom + "', prenom='" + prenom + "'}";
    }
}