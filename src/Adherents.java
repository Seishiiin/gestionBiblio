public class Adherents {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;

    public Adherents(String nom, String prenom, String adresse, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public String getNom() { return this.nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return this.prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return this.adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getTelephone() { return this.telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Adherent{" +
                "nom='" + this.nom + '\'' +
                ", prenom='" + this.prenom + '\'' +
                ", adresse='" + this.adresse + '\'' +
                ", telephone='" + this.telephone + '\'' +
                ", email='" + this.email + '\'' +
                '}';
    }
}