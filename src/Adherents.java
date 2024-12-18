public class Adherents {
    private static int compteur = 1;

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private int anneeNaissance;

    public Adherents(String nom, String prenom, String adresse, String telephone, int anneeNaissance) {
        this.id = compteur;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.anneeNaissance = anneeNaissance;

        compteur += 1;
    }

    public String toString() {
        return "L'adhérent n°" + this.id + " s'appelle " + this.prenom + " " + this.nom + ". Il est né en " + this.anneeNaissance + ". Il habite au " + this.adresse + " et son numéro de téléphone est le " + this.telephone + ".";
    }

    public int getId() { return this.id; }
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public String getAdresse() { return this.adresse; }
    public String getTelephone() { return this.telephone; }
    public int getAnneeNaissance() { return this.anneeNaissance; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setAnneeNaissance(int anneeNaissance) { this.anneeNaissance = anneeNaissance; }
}
