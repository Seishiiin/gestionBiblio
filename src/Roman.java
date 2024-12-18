public class Roman extends Livres {
    private int nbPages;
    private String langue;

    public Roman(String titre, String auteur, int annee, int nbPages, String langue) {
        super(titre, auteur, annee);
        this.nbPages = nbPages;
        this.langue = langue;
    }

    public String toString() {
        return "Le roman " + getTitre() + " de " + getAuteur() + " (" + getAnnee() + ") a " + nbPages + " pages et est en " + langue;
    }

    public int getNbPages() { return nbPages; }
    public String getLangue() { return langue; }

    public void setNbPages(int nbPages) { this.nbPages = nbPages; }
    public void setLangue(String langue) { this.langue = langue; }
}