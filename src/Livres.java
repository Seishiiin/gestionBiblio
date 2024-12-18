public abstract class Livres {
    private static int compteur = 1;

    private int isbn;
    private String titre;
    private String auteur;
    private int annee;

    public Livres(String titre, String auteur, int annee) {
        this.isbn = compteur;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;

        compteur += 1;
    }

    public String toString() {
        String message = "";

        message += ConsoleColors.println(ConsoleColors.CYAN, getIsbn() + " - ");
        message += ConsoleColors.println(ConsoleColors.PURPLE, getTitre() + " - ");
        message += ConsoleColors.println(ConsoleColors.YELLOW, getAuteur() + " - ");
        message += ConsoleColors.println(ConsoleColors.GREEN, getAnnee() + " - ");

        return message;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}