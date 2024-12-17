public class Emprunts {
    private String dateEmprunt;
    private String dateRetour;
    private Livres livre;
    private Adherents adherent;

    public Emprunts(String dateEmprunt, String dateRetour, Livres livre, Adherents adherent) {
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.livre = livre;
        this.adherent = adherent;
    }

    public String getDateEmprunt() { return this.dateEmprunt; }
    public void setDateEmprunt(String dateEmprunt) { this.dateEmprunt = dateEmprunt; }

    public String getDateRetour() { return this.dateRetour; }
    public void setDateRetour(String dateRetour) { this.dateRetour = dateRetour; }

    public Livres getLivre() { return this.livre; }
    public void setLivre(Livres livre) { this.livre = livre; }

    public Adherents getAdherent() { return this.adherent; }
    public void setAdherent(Adherents adherent) { this.adherent = adherent; }

    public boolean isEnCours() {
        return this.dateRetour == null || this.dateRetour.isEmpty();
    }

    @Override
    public String toString() {
        return "Emprunts{" +
                "dateEmprunt='" + this.dateEmprunt + '\'' +
                ", dateRetour='" + this.dateRetour + '\'' +
                ", livre=" + this.livre +
                ", adherent=" + this.adherent +
                '}';
    }
}