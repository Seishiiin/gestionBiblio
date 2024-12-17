public class Livres {
    private final String titre;
    private final String auteur;
    private final String isbn;
    private final int annee;
    private boolean emprunte;

    public Livres(String titre, String auteur, String isbn, int annee) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.annee = annee;
        this.emprunte = false;
    }

    public String getTitre() { return this.titre; }
    public String getAuteur() { return this.auteur; }
    public String getIsbn() { return this.isbn; }
    public int getAnnee() { return this.annee; }

    public boolean isEmprunte() { return this.emprunte; }
    public void setEmprunte(boolean emprunte) { this.emprunte = emprunte; }

    @Override
    public String toString() {
        return "Livres{" +
                "titre='" + this.titre + '\'' +
                ", auteur='" + this.auteur + '\'' +
                ", isbn='" + this.isbn + '\'' +
                ", annee=" + this.annee +
                ", emprunte=" + this.emprunte +
                '}';
    }
}